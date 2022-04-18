package com.rent.project.productservice.services;

import com.rent.project.productservice.models.ProductDetail;
import com.rent.project.productservice.models.product;
import com.rent.project.productservice.repository.productDetailRepo;
import com.rent.project.productservice.repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class categoryproductService {
    @Autowired
    productRepo productRepo;

    @Autowired
    productDetailRepo detailRepo;

    public List<ProductDetail> getCategoryProduct(String Category)
    {
        final int[] i = new int[1];
        List<product> pin = productRepo.fetchCategoryProduct(Category) ;
        System.out.println(pin);
        List<ProductDetail> pdmodel = new ArrayList<>();
        i[0] = 0;
        pin.forEach(s->
        {
            pdmodel.add(detailRepo.fetchProductDetail(pin.get(i[0]).getId()));
            i[0] = i[0] + 1;
        });
        return pdmodel;
    }
}
