package com.rent.project.orderservice.repository;

import com.rent.project.orderservice.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Orders, Long> {

    @Override
    Optional<Orders> findById(Long aLong);

    @Modifying
    @Query(value = "UPDATE orders SET order_status_id = 2 WHERE order_id =:orderid",nativeQuery = true)
    void updateAcceptedOrder(@Param("orderid") Long orderId);

    @Modifying
    @Query(value = "UPDATE orders SET order_status_id =:status WHERE order_id =:orderid",nativeQuery = true)
    void updateOrder(@Param("status") Integer OrderStatusId,@Param("orderid") Long orderId);

    @Override
    void deleteById(Long aLong);

    @Query(value = "SELECT order_id FROM orders WHERE DATE(return_date) > CURRENT_DATE",nativeQuery = true)
    List<Orders> dueOrders();

    @Query(value = "SELECT * FROM orders WHERE order_status_id=2 OR order_status_id=4 OR order_status_id=5 OR order_status_id=3 AND user_details_id=:user_id",nativeQuery = true)
    List<Orders> orderHistory(@Param("user_id") Long user_id);

    @Query(value = "SELECT * FROM orders WHERE order_status_id=1 OR order_status_id=6 AND user_details_id=:user_id",nativeQuery = true)
    List<Orders> orderRentCart(@Param("user_id") Long user_id);

    @Modifying
    @Query(value = "UPDATE orders SET issued_date =:idate, return_date =:rdate, quantity =:q WHERE order_id =:oid",nativeQuery = true)
    void updateOrderDuration(@Param("idate") Date i_date,@Param("rdate") Date r_date, @Param("q") Integer quantity,@Param("oid") Long order_id);

}
