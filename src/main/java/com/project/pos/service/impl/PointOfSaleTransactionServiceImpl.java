package com.project.pos.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.pos.model.*;
import com.project.pos.repository.PointOfSaleRepository;
import com.project.pos.repository.PointOfSaleTransactionRepository;
import com.project.pos.repository.TransactionHistoryRepository;
import com.project.pos.request.CardTransactionRequest;
import com.project.pos.request.GetTokenRequest;
import com.project.pos.request.TransactionRequest;
import com.project.pos.response.BaseResponse;
import com.project.pos.service.AuthenticationTokenService;
import com.project.pos.service.PointOfSaleTransactionService;
import com.project.pos.utils.LocalDateTimeAdapter;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointOfSaleTransactionServiceImpl implements PointOfSaleTransactionService {

    private static final String JSON_MEDIA_TYPE = "application/json; charset=utf-8";
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";
    private final PointOfSaleRepository pointOfSaleRepository;
    private final PointOfSaleTransactionRepository pointOfSaleTransactionRepository;
    private final TransactionHistoryRepository transactionHistoryRepository;
    private final AuthenticationTokenService authenticationTokenService;

    @Value("${banking.card.transaction-uri}")
    private String apiUrl;

    @Override
    public BaseResponse processPayment(CardTransactionRequest transactionRequest) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        MediaType JSON = MediaType.get(JSON_MEDIA_TYPE);
        String json = gson.toJson(transactionRequest);
        RequestBody requestBody = RequestBody.create(json, JSON);

        String accessToken = authenticationTokenService.getToken();

        Request request = new Request.Builder()
                .url(apiUrl)
                .post(requestBody)
                .addHeader(AUTHORIZATION, BEARER + accessToken)
                .build();

        // Execute the request and get response
        try (Response response = client.newCall(request).execute()) {
            if(!Objects.isNull(response.body())){
                String responseBody = response.body().string();
                BaseResponse baseResponse = gson.fromJson(responseBody, BaseResponse.class);
                return BaseResponse.builder()
                        .status(baseResponse.getStatus())
                        .message(baseResponse.getMessage())
                        .build();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public CardTransactionRequest buildCardTransactionRequest(TransactionRequest request) {
        Optional<PointOfSale> optionalPos = pointOfSaleRepository.findById(request.getPosId());
        if (optionalPos.isPresent()) {
            PointOfSale pos = optionalPos.get();
            return CardTransactionRequest.builder()
                    .companyName(pos.getCompany().getName())
                    .companyCategory(pos.getCompany().getCategory().getName())
                    .transactionAmount(request.getTransactionAmount())
                    .cardNumber(request.getCardNumber())
                    .cardType(request.getCardType())
                    .cardNetwork(request.getCardNetwork())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public PointOfSaleTransaction savePosTransaction(TransactionRequest request, BaseResponse response) {
        Optional<PointOfSale> optionalPos = pointOfSaleRepository.findById(request.getPosId());
        if(optionalPos.isPresent()){
            PointOfSaleTransaction pointOfSaleTransaction = new PointOfSaleTransaction();
            pointOfSaleTransaction.setPointOfSale(optionalPos.get());
            pointOfSaleTransaction.setTransactionAmount(request.getTransactionAmount());
            pointOfSaleTransaction.setCardNumber(request.getCardNumber());
            pointOfSaleTransaction.setCardType(CardType.valueOf(request.getCardType()));
            pointOfSaleTransaction.setCardNetwork(CardNetwork.valueOf(request.getCardNetwork()));
            pointOfSaleTransaction.setTransactionDate(Objects.isNull(request.getTransactionDate()) ? LocalDateTime.now() : request.getTransactionDate());
            pointOfSaleTransaction.setStatus(TransactionStatus.valueOf(response.getStatus()));
            pointOfSaleTransaction.setStatusMessage(response.getMessage());
            pointOfSaleTransactionRepository.save(pointOfSaleTransaction);
            return pointOfSaleTransaction;
        } else {
            return null;
        }
    }

    @Override
    public TransactionHistory saveTransactionInTransactionHistory(PointOfSaleTransaction posTransaction, BaseResponse response, Company company) {
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setTransaction(posTransaction);
        transactionHistory.setStatus(TransactionStatus.valueOf(response.getStatus()));
        transactionHistory.setStatusMessage(response.getMessage());
        transactionHistory.setCompany(company);
        transactionHistoryRepository.save(transactionHistory);
        return transactionHistory;
    }
}
