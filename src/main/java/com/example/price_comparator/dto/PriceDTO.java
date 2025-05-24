package com.example.price_comparator.dto;

public record PriceDTO(
        String storeName,
        double price,
        double packageQuantity,
        String packageUnit,
        double pricePerUnit
) {}
