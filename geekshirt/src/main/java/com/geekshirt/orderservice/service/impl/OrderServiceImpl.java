package com.geekshirt.orderservice.service.impl;

import com.geekshirt.orderservice.dao.OrderDAO;
import com.geekshirt.orderservice.dto.AccountDTO;
import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import com.geekshirt.orderservice.entity.Order;
import com.geekshirt.orderservice.service.contracts.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caito Vilas
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Value("${customer-service.url}")
    private String customerURL;

    private final RestTemplate restTemplate;
    private final OrderDAO orderDAO;

    @Override
    @Transactional
    public OrderResponse save(OrderRequest dto) {
        log.info("inicio servicio guardar orden");
        Order order = Order.builder()
                .status(dto.getStatus())
                .accountId(dto.getAccountId())
                .totalAmount(dto.getTotalAmount())
                .totalTax(dto.getTotalTax())
                .transactionDate(dto.getTransactionDate())
                .build();
        Order response = orderDAO.save(order);
        return this.mapToDto(response);
    }

    @Override
    public List<OrderResponse> getAll() {
        List<Order> response = orderDAO.getAll();
        if (response.isEmpty())
            return null;
        List<OrderResponse> reponses = response.stream().map(this::mapToDto).collect(Collectors.toList());
        return reponses;
    }

    @Override
    public AccountDTO getAccount(Long id) {
        log.info("llamando servicio externo consultar cuenta");
        AccountDTO account = null;
        try {
            log.info("llamando a : " + customerURL + "/" + id );
            account = restTemplate.getForObject(customerURL +"/" + id, AccountDTO.class);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return account;
    }

    private OrderResponse mapToDto(Order order){
        OrderResponse response = OrderResponse.builder()
                .id(order.getId())
                .status(order.getStatus())
                .accountId(order.getAccountId())
                .totalAmount(order.getTotalAmount())
                .totalTax(order.getTotalTax())
                .transactionDate(order.getTransactionDate())
                .build();
        return response;
    }
}
