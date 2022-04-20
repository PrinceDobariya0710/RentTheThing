package com.rent.project.orderservice.responses;

import com.rent.project.orderservice.models.OrderStatus;
import com.rent.project.orderservice.models.OrderType;
import com.rent.project.orderservice.models.productmodels.ProductDetails;
import com.rent.project.orderservice.models.userprofile_models.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDataResponse {

    private Integer quantity;

    private Date issuedDate;

    private Date returnDate;

}
