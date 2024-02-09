package com.erkancetin.product.service;

import com.erkancetin.grpc.DiscountRequest;
import com.erkancetin.grpc.DiscountResponse;
import com.erkancetin.product.model.Product;
import com.erkancetin.product.service.grpc.DiscountGrpcService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final DiscountGrpcService discountGrpcService;
    private final ProductService productService;

    public DiscountResponse getDiscount(int productId, String code) {
        Product product = productService.getById(productId);
        DiscountRequest discountRequest = DiscountRequest.newBuilder()
                .setCode(code)
                .setPrice(product.getPrice().floatValue())
                .setExternalCategoryId(product.getCategory().getId())
                .build();
        return discountGrpcService.getDiscount(discountRequest);
    }
}
