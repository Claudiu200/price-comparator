package com.example.price_comparator.service;

import com.example.price_comparator.dto.ActiveDiscountDTO;
import com.example.price_comparator.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;

    public List<ActiveDiscountDTO> getBestDiscountsToday(LocalDate date) {

        return discountRepository.findActiveDiscountsOrderByPercentageDesc(date)
                .stream()
                .map(d -> new ActiveDiscountDTO(
                        d.getId().getProductId(),
                        d.getProductName(),
                        d.getId().getStoreName(),
                        d.getBrand(),
                        d.getProductCategory(),
                        d.getPercentageOfDiscount(),
                        d.getId().getFromDate(),
                        d.getId().getToDate()
                )).toList();
    }

}
