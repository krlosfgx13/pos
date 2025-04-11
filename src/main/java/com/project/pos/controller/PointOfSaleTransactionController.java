package com.project.pos.controller;

import com.project.pos.model.Company;
import com.project.pos.model.PointOfSaleTransaction;
import com.project.pos.repository.CompanyRepository;
import com.project.pos.request.CardTransactionRequest;
import com.project.pos.request.TransactionRequest;
import com.project.pos.response.BaseResponse;
import com.project.pos.service.CompanyService;
import com.project.pos.service.impl.PointOfSaleTransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/pos")
public class PointOfSaleTransactionController {

    private final PointOfSaleTransactionServiceImpl pointOfSaleTransactionService;
    private final CompanyService companyService;
    private static final String SUCCESS = "SUCCESS";
    private final Logger logger = LoggerFactory.getLogger(PointOfSaleTransactionController.class);

    @PostMapping("transaction")
    public ResponseEntity<BaseResponse> processPayment(@RequestBody TransactionRequest request){

        try{
            CardTransactionRequest cardTransactionRequest = pointOfSaleTransactionService.buildCardTransactionRequest(request);
            BaseResponse response = pointOfSaleTransactionService.processPayment(cardTransactionRequest);
            if(response.getStatus().equals(SUCCESS)){
                Company company = companyService.getCompanyByName(cardTransactionRequest.getCompanyName());
                PointOfSaleTransaction posTransaction = pointOfSaleTransactionService.savePosTransaction(request, response);
                pointOfSaleTransactionService.saveTransactionInTransactionHistory(posTransaction, response, company);
                return new ResponseEntity<>(BaseResponse
                        .builder()
                        .status(response.getStatus())
                        .message(response.getMessage())
                        .build(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(BaseResponse
                        .builder()
                        .status(response.getStatus())
                        .message(response.getMessage())
                        .build(), HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception ex){
            logger.error("CG LOG --> " + ex.getMessage());
            return new ResponseEntity<>(BaseResponse
                    .builder()
                    .status("FAILED")
                    .message("UNEXPECTED ERROR")
                    .build(), HttpStatus.FORBIDDEN);
        }
    }
}
