package com.project.pos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name", nullable = false, length = 256)
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_category_id", nullable = false)
    private CompanyCategory category;
}
