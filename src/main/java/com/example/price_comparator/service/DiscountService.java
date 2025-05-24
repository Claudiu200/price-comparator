package com.example.price_comparator.service;

import com.example.price_comparator.dto.DiscountDTO;
import com.example.price_comparator.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;

    public List<DiscountDTO> getBestDiscountsToday(LocalDate date) {

        return discountRepository.findActiveDiscountsOrderByPercentageDesc(date)
                .stream()
                .map(d -> new DiscountDTO(
                        d.getId().getProductId(),
                        d.getProductName(),
                        d.getId().getStoreName(),
                        d.getBrand(),
                        d.getProductCategory(),
                        d.getPercentageOfDiscount(),
                        d.getId().getFromDate(),
                        d.getId().getToDate(),
                        d.getRegisteredAt()
                )).toList();
    }

    public List<DiscountDTO> getNewDiscounts() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return discountRepository.findDiscountRegisteredAfter(yesterday)
                .stream()
                .map(d -> new DiscountDTO(
                        d.getId().getProductId(),
                        d.getProductName(),
                        d.getId().getStoreName(),
                        d.getBrand(),
                        d.getProductCategory(),
                        d.getPercentageOfDiscount(),
                        d.getId().getFromDate(),
                        d.getId().getToDate(),
                        d.getRegisteredAt()
                )).toList();
    }

}
