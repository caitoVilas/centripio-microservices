package com.geekshirt.orderservice.controller;

import com.geekshirt.orderservice.dto.AccountDTO;
import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import com.geekshirt.orderservice.service.contracts.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caito Vilas
 */

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll(){
        log.info("***** POST endpoint creacion de orden *****");
        List<OrderResponse> response = orderService.getAll();
        if (response == null || response.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOne(@PathVariable String orderId){
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> save(@RequestBody OrderRequest request){
        log.info("***** POST endpoint creacion de orden *****");
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(request));
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getAccount(id));
    }
}
