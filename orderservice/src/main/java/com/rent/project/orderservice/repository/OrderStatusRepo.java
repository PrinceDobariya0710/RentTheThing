package com.rent.project.orderservice.repository;

import com.rent.project.orderservice.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepo extends JpaRepository<OrderStatus,Integer> {
}
