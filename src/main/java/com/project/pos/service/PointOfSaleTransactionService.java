package com.project.pos.service;

import com.project.pos.model.Company;
import com.project.pos.model.PointOfSaleTransaction;
import com.project.pos.model.TransactionHistory;
import com.project.pos.request.CardTransactionRequest;
import com.project.pos.request.TransactionRequest;
import com.project.pos.response.BaseResponse;

public interface PointOfSaleTransactionService {

    BaseResponse processPayment(CardTransactionRequest request);
    CardTransactionRequest buildCardTransactionRequest(TransactionRequest request);
    PointOfSaleTransaction savePosTransaction(TransactionRequest request, BaseResponse response);
    TransactionHistory saveTransactionInTransactionHistory(PointOfSaleTransaction posTransaction, BaseResponse response, Company company);
}
