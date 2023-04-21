package com.geekshirt.customer.customerservice.service.impl;

import com.geekshirt.customer.customerservice.dto.AccountDTO;
import com.geekshirt.customer.customerservice.entity.Account;
import com.geekshirt.customer.customerservice.mapper.SerciceMapper;
import com.geekshirt.customer.customerservice.repository.AccountRepository;
import com.geekshirt.customer.customerservice.service.contracts.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author caito Vilas
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final AccountRepository accountRepository;
    private final SerciceMapper mapper;


    @Override
    public AccountDTO save(AccountDTO dto) {
        log.info("inicio servicio guardar cuenta");
        Account account = Account.builder()
                .address(mapper.mapAddressToEntity(dto.getAddress()))
                .customer(mapper.mapToCustomerEntity(dto.getCustomer()))
                .creditCard(mapper.mapToCCEntity(dto.getCrecitCard()))
                .accountStatus(dto.getAccountStatus())
                .build();
        log.info("guardadndo cuenta...");
        return mapper.mapAccountToDto(accountRepository.save(account));
    }

    @Override
    public AccountDTO getOne(Long id) {
        log.info("inicio servicio buscar cuenta por id");
        log.info("buscando cuenta...");
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null)
            return null;
        return mapper.mapAccountToDto(account);
    }

    @Override
    public void delete(Long id) {
        log.info("inicio servicio eliminar cuenta");
        log.info("eliminando cuenta");
        accountRepository.deleteById(id);
    }


}
