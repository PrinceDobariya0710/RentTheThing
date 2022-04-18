package com.rent.project.productservice.services;

import com.rent.project.productservice.models.product;
import com.rent.project.productservice.repository.categoryRepo;
import com.rent.project.productservice.repository.productRepo;
import com.rent.project.productservice.repository.subCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    categoryRepo categoryrepo;

    @Autowired
    subCategoryRepo subcategoryRepo;

    @Autowired
    productRepo productrepo;

    public ResponseEntity<product> addProduct(product Product)
    {
         productrepo.save(Product);
        return ResponseEntity.ok(Product);
    }

    public ResponseEntity<product> editProduct(Integer id,product Product)
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

    public List<product> getProduct() {
        return productrepo.findAll();
    }

}
