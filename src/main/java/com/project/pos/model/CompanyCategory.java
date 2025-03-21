package com.project.pos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "company_category")
public class CompanyCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_category_id")
    private Long id;

    @Column(name = "company_category_name", nullable = false, length = 256)
    private String name;
}
