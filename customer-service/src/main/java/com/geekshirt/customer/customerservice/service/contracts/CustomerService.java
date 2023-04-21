package com.geekshirt.customer.customerservice.service.contracts;

import com.geekshirt.customer.customerservice.dto.AccountDTO;
/**
 * @author caito Vilas
 */
public interface CustomerService {
    AccountDTO save(AccountDTO dto);
    AccountDTO getOne(Long id);
    void delete(Long id);
}
