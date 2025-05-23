package com.example.price_comparator.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discounts")
public class Discount {

    @EmbeddedId
    private DiscountId id;

    private String productName;
    private String brand;
    private double packageQuantity;
    private String packageUnit;
    private String productCategory;

    private double percentageOfDiscount;

    private LocalDate registeredAt;

}
