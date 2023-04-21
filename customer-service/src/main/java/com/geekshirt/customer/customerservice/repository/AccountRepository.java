package com.geekshirt.customer.customerservice.repository;

import com.geekshirt.customer.customerservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caito Vilas
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
