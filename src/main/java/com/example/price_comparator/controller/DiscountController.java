package com.example.price_comparator.controller;

import com.example.price_comparator.dto.DiscountDTO;
import com.example.price_comparator.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/best")
    public ResponseEntity<List<DiscountDTO>> getBestDiscounts(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(discountService.getBestDiscountsToday(date));
    }

    @GetMapping("/new")
    public ResponseEntity<List<DiscountDTO>> getNewDiscounts() {
        return ResponseEntity.ok(discountService.getNewDiscounts());
    }

}
