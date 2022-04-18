package com.rent.project.productservice.services;

import com.rent.project.productservice.models.ProductDetail;
import com.rent.project.productservice.models.ProductInventory;
import com.rent.project.productservice.repository.productDetailRepo;
import com.rent.project.productservice.repository.productInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LatestProductService {
    @Autowired
    productInventoryRepo productInventoryRepo;

    @Autowired
    productDetailRepo detailRepo;

    public List<ProductDetail> getLatestProduct()
    {
        final int[] i = new int[1];
        List<ProductInventory> pin = productInventoryRepo.fetchLatestProduct();
        System.out.println(pin);
        List<ProductDetail> pdmodel = new ArrayList<>();
        i[0] = 0;
        pin.forEach(s->
        {
            pdmodel.add(detailRepo.fetchProductDetail(pin.get(i[0]).getProduct().getId()));
            i[0] = i[0] + 1;
        });
        return pdmodel;
    }
}
