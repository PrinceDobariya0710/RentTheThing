package com.rent.project.orderservice.services.orders;
import com.rent.project.orderservice.models.OrderStatus;
import com.rent.project.orderservice.models.Orders;
import com.rent.project.orderservice.models.productmodels.Product;
import com.rent.project.orderservice.repository.OrderRepo;
import com.rent.project.orderservice.repository.ProductRepo;
import com.rent.project.orderservice.responses.OrderDataResponse;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate ;

    //Creating an Order
    public ResponseEntity<?> postOrder (Orders orders){
        Orders savedOrder = orderRepo.save(orders);
        return ResponseEntity.ok().body("Your Order is saved in rentCart as details : \n" + savedOrder);
    }

    //SearchUserHistory
    public List<Orders> userHistoryview(Long user_id){
        return orderRepo.orderHistory(user_id);
    }

    //Search User Rent
    public List<Orders> rentCartView(Long user_id){
        return orderRepo.orderRentCart(user_id);
    }

    @Transactional
    //Changing issue Date , Return Date and Quantity
    public Orders updateOrderField(OrderDataResponse orderDataResponse ,Long order_id){
        Date issueDate = orderDataResponse.getIssuedDate();
        Date returnDate = orderDataResponse.getReturnDate();
        Integer quantity = orderDataResponse.getQuantity();
        orderRepo.updateOrderDuration(issueDate,returnDate,quantity,order_id);
        Orders updatedOrder = orderRepo.getById(order_id);
        return updatedOrder;
    }


    //Changing order status
    @Transactional
    public ResponseEntity<?> updateOrderStatus(Integer orderStatusId,Long orderId){

        Orders orders = orderRepo.getById(orderId);
        Integer quantityInOrder = orders.getQuantity();
        Long product_id = orders.getProductDetails().getProduct().getId();
        Optional<Product> product = productRepo.findById(product_id);

        List<Integer> quantity_available = product.stream().map(Product::getAvailable_pieces).collect(Collectors.toList()); //get the quantity available latest from product table



        Integer order_status= orders.getOrderStatus().getOrderStatusId();

        if (orderStatusId==6 && order_status==1){ //Your status request is to change : 6-Notified to onwer and your previous status should : 1-In Rentcart
            this.orderRepo.updateOrder(6,orderId);
        }
        else if(orderStatusId==2 && order_status==6){//Your status request is to change : 2-Accepted and  your previous status should : 6-Notified to onwer
            this.orderRepo.updateOrder(2,orderId);
            Integer resulted_pieces = quantity_available.get(0)-quantityInOrder;//result the product quantity after updating
            productRepo.updateAvailablePiece(resulted_pieces,product_id); //UPDATE the Available Pieces in ProductTable

        }
        else if(orderStatusId==4 && order_status==2){//Your status request is to change : 4-Returned and completed  and your previous status should : 2-Accepted
            this.orderRepo.updateOrder(4,orderId);
            Integer resulted_pieces = quantity_available.get(0)+quantityInOrder;//result the product quantity after updating
            productRepo.updateAvailablePiece(resulted_pieces,product_id); //UPDATE the Available Pieces in ProductTable
        }
        else if(orderStatusId==3 && order_status==6){//Your status request is to change : 3-Reject and your previous status should : 6-Notified to onwer
            this.orderRepo.updateOrder(4,orderId);
        }
        else {
            throw new InvalidDataAccessApiUsageException("\n Invalid orderStatusId and orderId ");
        }
        Orders updatedOrder = orderRepo.getById(orderId);
        return ResponseEntity.ok().body("Your order is accepted and order status changed . Details of Order : \n "+ updatedOrder);

    }

    //Cron job to check return date and if it is expired the this cron job will change status to Due
    @Scheduled(cron = "0 13 * * 0/1")
    public void changeOrderStatusDue(){
        Orders orders = new Orders();
        List<Orders> dueOrders = orderRepo.dueOrders();
        for (Orders order:dueOrders
             ) {
            Long order_id = order.getOrderId();
            final Integer status_id = 5;
            String url="http://localhost:8080/orders/order/changestatus/"+status_id+"/"+order_id;
            ResponseEntity<String> result= restTemplate.getForEntity(url,String.class);
        }

    }


}
