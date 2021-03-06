package com.rent.project.productservice.services;

import com.rent.project.productservice.models.Product;
import com.rent.project.productservice.repository.CategoryRepo;
import com.rent.project.productservice.repository.ProductRepo;
import com.rent.project.productservice.repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productrepo;

    public ResponseEntity<Product> addProduct(Product product,MultipartFile file) throws IOException {
//        String s = uploadFile(file);
//        Product.setProduct_image(s);
//        System.out.println(s);
//        file.transferTo(new File("C:\\Users\\bbdnet10198\\Desktop\\ProjectSpringBoot\\RentTheThing\\uploads\\"+file.getOriginalFilename()));
//        Product.setProduct_image(file.getOriginalFilename());
        file.transferTo(new File("C:\\Users\\bbdnet10198\\Desktop\\ProjectSpringBoot\\RentTheThing\\uploads\\" + file.getOriginalFilename()));
        product.setProduct_image(file.getOriginalFilename());
        productrepo.save(product);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<Product> editProduct(Long id, Product product,MultipartFile file) throws IOException {
        if(productrepo.findById(id).isPresent())
        {
            product.setId(id);
            file.transferTo(new File("C:\\Users\\bbdnet10198\\Desktop\\ProjectSpringBoot\\RentTheThing\\uploads\\" + file.getOriginalFilename()));
            product.setProduct_image(file.getOriginalFilename());
            productrepo.save(product);
            return ResponseEntity.ok(product);
        }
       return ResponseEntity.notFound().build();
    }
    public void deleteProduct(Long id){ productrepo.deleteById(id);}

    public List<Product> getProduct() {
        return productrepo.findAll();
    }


//    public String uploadFile(MultipartFile file) throws IOException {
//        String path = "C:\\Users\\bbdnet10198\\Desktop\\ProjectSpringBoot\\RentTheThing\\uploads\\"+file.getOriginalFilename();
//        file.transferTo(new File("C:\\Users\\bbdnet10198\\Desktop\\ProjectSpringBoot\\RentTheThing\\uploads\\"+file.getOriginalFilename()));
//        return path;
//    }

}
