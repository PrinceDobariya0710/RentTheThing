package com.rent.project.productservice.controller;

import com.rent.project.productservice.models.ProductDetail;
import com.rent.project.productservice.repository.productDetailRepo;
import com.rent.project.productservice.services.productDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productdetail")
public class productDetailController {

    @Autowired
    productDetailRepo pdr;

    @Autowired
    productDetailService pds;

    @GetMapping("/all")
    public List<ProductDetail> getProductsDetail() {
        return pds.getProductDetail();
    }
}
