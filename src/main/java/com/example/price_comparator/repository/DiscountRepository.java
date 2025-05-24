package com.example.price_comparator.repository;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.DiscountId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, DiscountId> {

    @Query("SELECT d FROM Discount d where :today BETWEEN d.id.fromDate AND d.id.toDate ORDER BY d.percentageOfDiscount DESC")
    List<Discount> findActiveDiscountsOrderByPercentageDesc(@Param("today")LocalDate today);

    @Query("SELECT d FROM Discount d WHERE d.registeredAt >= :yesterday")
    List<Discount> findDiscountRegisteredAfter(@Param("yesterday") LocalDate yesterday);
}
