package com.project.pos.repository;

import com.project.pos.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);

    //c.category.id is to navigate through relationships between entities.
    @Query("SELECT c FROM Company c WHERE c.category.id = :companyCategoryId ")
    List<Company> findByCompanyByCategoryId(@Param(("companyCategoryId")) Long id);
}
