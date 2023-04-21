package com.geekshirt.customer.customerservice.dto;

import com.geekshirt.customer.customerservice.enums.AccountStatus;
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
public class AccountDTO {
    private Long id;
    private AddressDTO address;
    private CustomerDTO customer;
    private CreditCardDTO crecitCard;
    private AccountStatus accountStatus;
}
