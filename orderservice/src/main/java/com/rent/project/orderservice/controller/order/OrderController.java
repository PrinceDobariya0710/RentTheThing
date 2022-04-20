package com.rent.project.orderservice.controller.order;

import com.rent.project.orderservice.models.Orders;
import com.rent.project.orderservice.models.Orders;
import com.rent.project.orderservice.repository.OrderRepo;
import com.rent.project.orderservice.responses.OrderDataResponse;
import com.rent.project.orderservice.services.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepo orderRepo ;

    @PostMapping("/create/")
    public ResponseEntity<?> createOrder(@RequestBody Orders orderdata){
        try {
            return orderService.postOrder(orderdata);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Unable to create an order due to Exception : " + e);
        }
    }

    @PutMapping("/update/order_field/{order_id}")
    public ResponseEntity<?> updateOrderFields(@RequestBody OrderDataResponse orderDataResponse ,@PathVariable Long order_id){
        return ResponseEntity.ok().body(orderService.updateOrderField(orderDataResponse,order_id));
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId){
        try {
            Orders orders = orderRepo.getById(orderId);
            return ResponseEntity.ok().body(orders);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Unable to get your Order  due to Exception : " + e);
        }
    }
    @Transactional
    @PutMapping("/changestatus/accept/{orderId}")
    public ResponseEntity<?> acceptOrder(@PathVariable Long orderId){
        try {
            this.orderRepo.updateAcceptedOrder(orderId);
            Orders orders = orderRepo.getById(orderId);
            return ResponseEntity.ok().body("Your order is accepted and order status changed to Accepted and In Progress. Details of Order : \n "+ orders);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Unable to change status of Order due to this Exception : \n"+e);
        }
    }

    @Transactional
    @PutMapping("/changestatus/{orderStatusId}/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable Integer orderStatusId,@PathVariable Long orderId){
        try {
            return orderService.updateOrderStatus(orderStatusId,orderId);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Unable to change status of Order due to this Exception : \n"+e);
        }
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId){
        try {
            this.orderRepo.deleteById(orderId);
            return ResponseEntity.ok().body("Your order is deleted which has order_id: "+orderId);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Unable to delete your order due to Exception : \n "+ e);
        }

    }

    @GetMapping("/get/user_history/{user_id}")
    public ResponseEntity<List<Orders>> userHistory(@PathVariable Long user_id){
        return ResponseEntity.ok().body(orderService.userHistoryview(user_id));
    }

    @GetMapping("/get/rent_cart/{user_id}")
    public ResponseEntity<List<Orders>> rentCart(@PathVariable Long user_id){
        return ResponseEntity.ok().body(orderService.rentCartView(user_id));
    }


}
