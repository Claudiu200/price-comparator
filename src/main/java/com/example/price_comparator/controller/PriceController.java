package com.example.price_comparator.controller;

import com.example.price_comparator.dto.PriceDTO;
import com.example.price_comparator.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/substitutes")
    public ResponseEntity<List<PriceDTO>> getProductSubstitutes(@RequestParam String productName) {

        List<PriceDTO> substitutes = priceService.findProductSubstitutes(productName);
        if (substitutes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(substitutes);

    }
}
