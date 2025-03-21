package com.project.pos.repository;

import com.project.pos.model.PointOfSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfSaleRepository extends JpaRepository<PointOfSale, Long> {
}
