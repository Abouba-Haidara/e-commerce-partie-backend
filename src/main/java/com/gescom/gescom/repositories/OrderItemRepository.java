package com.gescom.gescom.repositories;

import com.gescom.gescom.entities.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
