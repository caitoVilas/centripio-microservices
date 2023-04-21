package com.geekshirt.customer.customerservice.mapper;

import com.geekshirt.customer.customerservice.dto.AccountDTO;
import com.geekshirt.customer.customerservice.dto.AddressDTO;
import com.geekshirt.customer.customerservice.dto.CreditCardDTO;
import com.geekshirt.customer.customerservice.dto.CustomerDTO;
import com.geekshirt.customer.customerservice.entity.Account;
import com.geekshirt.customer.customerservice.entity.Address;
import com.geekshirt.customer.customerservice.entity.CreditCard;
import com.geekshirt.customer.customerservice.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class SerciceMapper {
    public Address mapAddressToEntity(AddressDTO dto){
        return Address.builder()
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .country(dto.getCountry())
                .zipCode(dto.getZipCode())
                .build();
    }
    public Customer mapToCustomerEntity(CustomerDTO dto){
        return Customer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
    }

    public CreditCard mapToCCEntity(CreditCardDTO dto){
        return CreditCard.builder()
                .nameOnCard(dto.getNameOnCard())
                .number(dto.getNumber())
                .cardType(dto.getCardType())
                .expirationMonth(dto.getExpirationMonth())
                .expirationYear(dto.getExpirationYear())
                .ccv(dto.getCcv())
                .build();
    }

    public AccountDTO mapAccountToDto(Account account){
        return AccountDTO.builder()
                .id(account.getId())
                .address(this.mapAddressToDto(account.getAddress()))
                .customer(this.mapToCustomerDto(account.getCustomer()))
                .crecitCard(this.mapToCCDto(account.getCreditCard()))
                .accountStatus(account.getAccountStatus())
                .build();
    }

    public AddressDTO mapAddressToDto(Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .build();
    }

    public CustomerDTO mapToCustomerDto(Customer customer){
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

    public CreditCardDTO mapToCCDto(CreditCard cc){
        return CreditCardDTO.builder()
                .id(cc.getId())
                .nameOnCard(cc.getNameOnCard())
                .number(cc.getNumber())
                .cardType(cc.getCardType())
                .expirationMonth(cc.getExpirationMonth())
                .expirationYear(cc.getExpirationYear())
                .ccv(cc.getCcv())
                .build();
    }
}
