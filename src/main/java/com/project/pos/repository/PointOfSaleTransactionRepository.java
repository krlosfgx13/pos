package com.project.pos.repository;

import com.project.pos.model.PointOfSaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfSaleTransactionRepository extends JpaRepository<PointOfSaleTransaction, Long> {
}
