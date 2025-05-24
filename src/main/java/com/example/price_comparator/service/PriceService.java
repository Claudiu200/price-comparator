package com.example.price_comparator.service;

import com.example.price_comparator.dto.PriceDTO;
import com.example.price_comparator.model.Price;
import com.example.price_comparator.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public List<PriceDTO> findProductSubstitutes(String productName) {

        List<Price> allProducts = priceRepository.findByProductName(productName);

        return allProducts.stream()
                .sorted(Comparator.comparingDouble(Price::getValuePerUnit))
                .map(p -> new PriceDTO(
                        p.getId().getStoreName(),
                        p.getPrice(),
                        p.getPackageQuantity(),
                        p.getPackageUnit(),
                        p.getValuePerUnit()
                )).collect(Collectors.toList());

    }
}
