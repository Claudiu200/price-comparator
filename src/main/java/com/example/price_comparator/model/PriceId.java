package com.example.price_comparator.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PriceId implements Serializable {
    private String productId;
    private String storeName;
    private LocalDate recordedDate;
}
