package com.geekshirt.customer.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caito Vilas
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreditCardDTO {
    private Long id;
    private String nameOnCard;
    private String number;
    private String cardType;
    private String expirationMonth;
    private String expirationYear;
    private String ccv;
}
