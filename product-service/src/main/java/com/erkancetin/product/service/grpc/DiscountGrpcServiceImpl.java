package com.erkancetin.product.service.grpc;

import com.erkancetin.grpc.DiscountRequest;
import com.erkancetin.grpc.DiscountResponse;
import com.erkancetin.grpc.DiscountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscountGrpcServiceImpl implements DiscountGrpcService{

    private DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceBlockingStub;
    private ManagedChannel channel;

    public DiscountGrpcServiceImpl(@Value("${discount.grpc.host}") String grpcHost, @Value("${discount.grpc.port}") int grpcPort) {
        System.out.println("--> Discount grpc: " + grpcHost + " " + grpcPort);
        channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort)
                .usePlaintext()
                .build();
    }

    @Override
    public DiscountResponse getDiscount(DiscountRequest discountRequest) {
        discountServiceBlockingStub = DiscountServiceGrpc.newBlockingStub(channel);
        DiscountResponse discountResponse = discountServiceBlockingStub.getDiscount(discountRequest);
        return discountResponse;
    }
}
