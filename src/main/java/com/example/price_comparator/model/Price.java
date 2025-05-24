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

    // methode to normalize the units
    public double getPackageQuantityInBaseUnit() {

        if (packageUnit == null) return packageQuantity;

        return switch (packageUnit.toLowerCase()) {
            case "g", "ml" -> packageQuantity / 1000.0; // g -> kg & ml -> l
            default -> packageQuantity;
        };

    }

    public double getValuePerUnit() {
        double baseQuantity = getPackageQuantityInBaseUnit();
        if(baseQuantity <= 0)
            return 0;
        return price/baseQuantity;
    }
}
