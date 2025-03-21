package com.project.pos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction_history")
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_history_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "point_of_sale_transaction_id", nullable = false)
    private PointOfSaleTransaction transaction;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 6)
    private TransactionStatus status;

    @Column(name = "status_message", nullable = false, length = 256)
    private String statusMessage;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
