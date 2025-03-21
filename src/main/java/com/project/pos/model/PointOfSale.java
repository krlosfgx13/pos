package com.project.pos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "point_of_sale")
public class PointOfSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_of_sale_id")
    private Long id;

    @Column(name = "point_of_sale_name", nullable = false, length = 256)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
