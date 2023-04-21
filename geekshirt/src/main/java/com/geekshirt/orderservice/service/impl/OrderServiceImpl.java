package com.geekshirt.orderservice.service.impl;

import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import com.geekshirt.orderservice.entity.Order;
import com.geekshirt.orderservice.service.contracts.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caito Vilas
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Override
    public OrderResponse save(OrderRequest dto) {
        log.info("inicio servicio guardar orden");
        Order order = Order.builder()
                .status(dto.getStatus())
                .accountId(dto.getAccountId())
                .totalAmount(dto.getTotalAmount())
                .totalTax(dto.getTotalTax())
                .transactionDate(dto.getTransactionDate())
                .build();
        return this.mapToDto(order);
    }

    @Override
    public List<OrderResponse> getAll() {
        return null;
    }

    private OrderResponse mapToDto(Order order){
        OrderResponse response = OrderResponse.builder()
                .orderId(order.getOrderId())
                .status(order.getStatus())
                .accountId(order.getAccountId())
                .totalAmount(order.getTotalAmount())
                .totalTax(order.getTotalTax())
                .transactionDate(order.getTransactionDate())
                .build();
        return response;
    }
}
