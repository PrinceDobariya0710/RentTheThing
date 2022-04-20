package com.rent.project.orderservice.repository;

import com.rent.project.orderservice.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification,Long> {

    @Query(value = "SELECT * FROM notification WHERE owner_user_id=:ownerId",nativeQuery = true)
    List<Notification> getByownerUser (Long ownerId);
}
