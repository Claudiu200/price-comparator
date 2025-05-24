package com.example.price_comparator.dto;

import java.time.LocalDate;

public record ActiveDiscountDTO(
        String productId,
        String productName,
        String storeName,
        String brand,
        String category,
        double percentageOfDiscount,
        LocalDate fromDate,
        LocalDate toDate
) {}
