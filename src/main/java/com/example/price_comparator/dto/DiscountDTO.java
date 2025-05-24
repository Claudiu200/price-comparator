package com.example.price_comparator.dto;

import java.time.LocalDate;

public record DiscountDTO(
        String productId,
        String productName,
        String storeName,
        String brand,
        String category,
        double percentageOfDiscount,
        LocalDate fromDate,
        LocalDate toDate,
        LocalDate registeredAt
) {}
