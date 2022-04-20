package com.rent.project.orderservice.services.notifications;

import com.rent.project.orderservice.models.Notification;
import com.rent.project.orderservice.models.Orders;
import com.rent.project.orderservice.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public ResponseEntity<?> postNotification (Notification notification ){
        Notification savedNotification = notificationRepo.save(notification);
        return ResponseEntity.ok().body("Your Order is saved in rentCart as details : \n" + savedNotification);
    }

    public List<Notification> getNotification(Long ownerId) {
        return notificationRepo.getByownerUser(ownerId);
    }
}
