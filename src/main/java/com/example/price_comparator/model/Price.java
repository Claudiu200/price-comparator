package com.example.price_comparator.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prices")
public class Price {

    @EmbeddedId
    private PriceId id;

    private String productName;
    private String productCategory;
    private String brand;

    private double packageQuantity;
    private String packageUnit;

    private double price;
    private String currency;

}
