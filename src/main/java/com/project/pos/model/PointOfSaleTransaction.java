package com.project.pos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "point_of_sale_transaction")
public class PointOfSaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_of_sale_transaction_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "point_of_sale_id", nullable = false)
    private PointOfSale pointOfSale;

    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal transactionAmount;

    @Column(name = "card_number", nullable = false, length = 20)
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false, length = 6)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_network", nullable = false, length = 10)
    private CardNetwork cardNetwork;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 6)
    private TransactionStatus status;

    @Column(name = "status_message", nullable = false, length = 256)
    private String statusMessage;
}
