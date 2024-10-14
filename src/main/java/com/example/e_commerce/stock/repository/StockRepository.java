package com.example.e_commerce.stock.repository;

import com.example.e_commerce.stock.domain.Stock;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT s FROM Stock s WHERE s.productId = :productId")
    Optional<Stock> findByIdWithLock(@Param("productId") long productId);
}
