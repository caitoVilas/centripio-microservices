package com.geekshirt.orderservice.dto;

import com.geekshirt.orderservice.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description = "modelo que representa una orden par las respuestas")
public class OrderResponse {

    private Long id;
    private OrderStatus status;
    private String accountId;
    private Double totalAmount;
    private Double totalTax;
    private LocalDateTime transactionDate;
}
