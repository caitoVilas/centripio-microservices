package com.geekshirt.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description = "modelo que representa un item de una orden")
public class LineItemDTO {
    private Long upc;
    private int quantity;
    private Double price;
}
