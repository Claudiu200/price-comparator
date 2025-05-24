package com.example.price_comparator.controller;

import com.example.price_comparator.dto.ActiveDiscountDTO;
import com.example.price_comparator.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

//    public DiscountController(DiscountService discountService) {
//        this.discountService = discountService;
//    }

    @GetMapping("/best")
    public List<ActiveDiscountDTO> getBestDiscounts(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return discountService.getBestDiscountsToday(date);
    }

}
