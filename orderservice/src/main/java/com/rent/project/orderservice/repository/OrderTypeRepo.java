package com.rent.project.orderservice.repository;

import com.rent.project.orderservice.models.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTypeRepo extends JpaRepository<OrderType,Long> {
}
