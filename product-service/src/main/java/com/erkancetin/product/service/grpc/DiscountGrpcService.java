package com.erkancetin.product.service.grpc;

import com.erkancetin.grpc.DiscountRequest;
import com.erkancetin.grpc.DiscountResponse;

public interface DiscountGrpcService {

    DiscountResponse getDiscount(DiscountRequest discountRequest);
}
