package com.rent.project.productservice.controller;

import com.rent.project.productservice.models.Product;
import com.rent.project.productservice.repository.ProductRepo;
import com.rent.project.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepo productrepo;

    @Autowired
    ProductService ps;
    @PostMapping("/add")
    public ResponseEntity<Product> addproduct(@RequestBody Product Product)
    {
        return ps.addProduct(Product);
    }

    @PutMapping("/edit/{Id}")
    public ResponseEntity<Product> editproduct(@PathVariable Integer Id, @RequestBody Product Product)
    {
        return ps.editProduct(Id,Product);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteproduct(@PathVariable Integer Id)
    {
        ps.deleteProduct(Id);
    }

    @GetMapping ("/all")
    public List<Product> getProducts() {
        return ps.getProduct();
    }
}
