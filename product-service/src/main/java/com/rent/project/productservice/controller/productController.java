package com.rent.project.productservice.controller;

import com.rent.project.productservice.models.product;
import com.rent.project.productservice.repository.productRepo;
import com.rent.project.productservice.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    productRepo productrepo;

    @Autowired
    productService ps;
    @PostMapping("/add")
    public ResponseEntity<product> addproduct(@RequestBody product Product)
    {
        return ps.addProduct(Product);
    }

    @PutMapping("/edit/{Id}")
    public ResponseEntity<product> editproduct(@PathVariable Integer Id,@RequestBody product Product)
    {
        return ps.editProduct(Id,Product);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteproduct(@PathVariable Integer Id)
    {
        ps.deleteProduct(Id);
    }

    @GetMapping ("/all")
    public List<product> getProducts() {
        return ps.getProduct();
    }
}
