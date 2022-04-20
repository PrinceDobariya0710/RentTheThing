package com.rent.project.orderservice.controller.notification;

import com.rent.project.orderservice.models.Notification;
import com.rent.project.orderservice.services.notifications.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/notifications/")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create/")
    public ResponseEntity<?> createNotification(@RequestBody Notification notification) {
        try {
            return notificationService.postNotification(notification);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Your product is not able to send via notification to owner due to Exception : \n" + e);
        }

    }

    @GetMapping("/get/owner/{ownerId}")
    public ResponseEntity<List<Notification>> getNotification(@PathVariable Long ownerId){
            return ResponseEntity.ok().body(this.notificationService.getNotification(ownerId));
    }



}
