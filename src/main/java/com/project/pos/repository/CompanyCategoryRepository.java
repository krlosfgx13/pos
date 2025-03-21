package com.project.pos.repository;

import com.project.pos.model.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCategoryRepository extends JpaRepository<CompanyCategory, Long> {
}
