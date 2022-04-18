package com.rent.project.productservice.services;

import com.rent.project.productservice.models.ProductDetail;
import com.rent.project.productservice.repository.productDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class productDetailService {
    @Autowired
    productDetailRepo proDR;

    public List<ProductDetail> getProductDetail() {
        return proDR.findAll();
    }
}
