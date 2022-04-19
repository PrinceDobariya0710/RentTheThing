package com.rent.project.productservice.services;

import com.rent.project.productservice.models.Product;
import com.rent.project.productservice.repository.CategoryRepo;
import com.rent.project.productservice.repository.ProductRepo;
import com.rent.project.productservice.repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    CategoryRepo categoryrepo;

    @Autowired
    SubCategoryRepo subcategoryRepo;

    @Autowired
    ProductRepo productrepo;

    public ResponseEntity<Product> addProduct(Product Product)
    {
         productrepo.save(Product);
        return ResponseEntity.ok(Product);
    }

    public ResponseEntity<Product> editProduct(Integer id, Product Product)
    {
        System.out.println("hello parent");
       /*productrepo.findById(id).map(p1->
       {
           System.out.println("hello");
           Product.setId(id);
           productrepo.save(Product);
           return ResponseEntity.ok("updated..");
       });*/
        if(productrepo.findById(id).isPresent())
        {
            Product.setId(id);
            productrepo.save(Product);
            return ResponseEntity.ok(Product);
        }
       return ResponseEntity.notFound().build();
    }
    public void deleteProduct(Integer id){ productrepo.deleteById(id);}

    public List<Product> getProduct() {
        return productrepo.findAll();
    }

}
