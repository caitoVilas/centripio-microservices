package com.geekshirt.orderservice.dao;

import com.geekshirt.orderservice.entity.Order;

import java.util.List;
import java.util.Optional;

/**
 * @author caito Vilas
 */

public interface OrderDAO {
    List<Order> getAll();
    Optional<Order> getOne(Long id);
    Order save(Order order);
}
