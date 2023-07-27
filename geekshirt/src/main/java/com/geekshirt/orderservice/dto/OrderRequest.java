package com.geekshirt.orderservice.dto;

import com.geekshirt.orderservice.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "modelo que representa una orden a guardar")
public class OrderRequest {

    private OrderStatus status;
    @Schema(name = "accountId", required = true, example = "1234567")
    private String accountId;
    private Double totalAmount;
    private List<LineItemDTO> items;
    private Double totalTax;
    private LocalDateTime transactionDate;
}
