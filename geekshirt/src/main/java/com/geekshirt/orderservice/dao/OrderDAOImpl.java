package com.geekshirt.orderservice.dao;

import com.geekshirt.orderservice.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * @author caito Vilas
 */

@Slf4j
@Repository
public class OrderDAOImpl implements OrderDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Order> getAll() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public Optional<Order> getOne(Long id) {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.id = :id", Order.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Order save(Order order) {
        em.persist(order);
        return order;
    }
}
