package com.erkancetin.product.controller;

import com.erkancetin.grpc.DiscountResponse;
import com.erkancetin.product.model.dto.DiscountResponseDTO;
import com.erkancetin.product.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping
    public ResponseEntity<DiscountResponseDTO> getDiscount(int productId, String code) {
        DiscountResponse discountResponse = discountService.getDiscount(productId,code);
        return ResponseEntity.ok(
                DiscountResponseDTO.builder()
                        .newPrice(discountResponse.getNewPrice())
                        .oldPrice(discountResponse.getOldPrice())
                        .code(discountResponse.getCode())
                        .build()
        );

    }
}
