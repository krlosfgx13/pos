package com.project.pos.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CardTransactionRequest {
    private String companyName;
    private String companyCategory;
    private BigDecimal transactionAmount;
    private String cardNumber;
    private String cardType;
    private String cardNetwork;
    private LocalDateTime transactionDate;
}
