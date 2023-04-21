package com.geekshirt.customer.customerservice.controller;

import com.geekshirt.customer.customerservice.dto.AccountDTO;
import com.geekshirt.customer.customerservice.service.contracts.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/geekshirts/customers")

@Slf4j
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<AccountDTO> save(@RequestBody AccountDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getOne(@PathVariable Long id){
        AccountDTO response = customerService.getOne(id);
        if (response == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(null);
    }
}
