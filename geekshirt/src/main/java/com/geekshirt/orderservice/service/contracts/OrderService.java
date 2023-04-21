package com.geekshirt.orderservice.service.contracts;

import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;

import java.util.List;

/**
 * @author caito Vilas
 */

public interface OrderService {
    OrderResponse save(OrderRequest dto);
    List<OrderResponse> getAll();
}
