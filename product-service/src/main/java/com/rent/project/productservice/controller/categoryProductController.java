package com.rent.project.productservice.controller;

import com.rent.project.productservice.models.ProductDetail;
import com.rent.project.productservice.services.categoryproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoryproduct")
public class categoryProductController {
    @Autowired
    com.rent.project.productservice.services.categoryproductService categoryproductService;

    @GetMapping("/get/{category}")
    public List<ProductDetail> getLatestProduct(@PathVariable String category)
    {
        return categoryproductService.getCategoryProduct(category);
    }
}
