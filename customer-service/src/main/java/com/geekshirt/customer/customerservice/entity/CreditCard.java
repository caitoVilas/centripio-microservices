package com.geekshirt.customer.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caito Vilas
 */
@Entity
@Table(name = "credit_cars")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOnCard;
    private String number;
    private String cardType;
    private String expirationMonth;
    private String expirationYear;
    private String ccv;
}
