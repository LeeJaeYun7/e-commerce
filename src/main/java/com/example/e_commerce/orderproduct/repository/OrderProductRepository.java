package com.example.e_commerce.orderproduct.repository;

import com.example.e_commerce.orderproduct.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    @Query("SELECT o FROM OrderProduct o WHERE o.createdAt >= :threshold")
    List<OrderProduct> findAllIn3Days(@Param("threshold") LocalDateTime threshold);
}
