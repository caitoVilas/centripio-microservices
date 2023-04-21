package com.geekshirt.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author caito Vilas
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    private String orderId;
    private String status;
    private String accountId;
    private Double totalAmount;
    private Double totalTax;
    private LocalDateTime transactionDate;
}
