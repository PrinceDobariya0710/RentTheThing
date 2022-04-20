package com.rent.project.orderservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rent.project.orderservice.models.productmodels.ProductDetails;
import com.rent.project.orderservice.models.userprofile_models.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_details_id",referencedColumnName = "user_details_id")
    private UserDetails userDetails;

    @ManyToOne
    @JoinColumn(name = "productd_id",referencedColumnName = "productd_id")
    private ProductDetails productDetails;

    private Integer quantity;

    private Date issuedDate;

    private Date returnDate;

    private Double totalPay;

    @ManyToOne
    @JoinColumn(name = "order_status_id",referencedColumnName = "order_status_id")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "order_type_id",referencedColumnName = "order_type_id")
    private OrderType orderType;

    public Orders(UserDetails userDetails, ProductDetails productDetails, Integer quantity, Date issuedDate, Date returnDate, Double totalPay, OrderStatus orderStatus, OrderType orderType) {
        this.userDetails = userDetails;
        this.productDetails = productDetails;
        this.quantity = quantity;
        this.issuedDate = issuedDate;
        this.returnDate = returnDate;
        this.totalPay = totalPay;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
    }
}
