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
public class productDetailOfSpecificUserService {
    @Autowired
    productRepo pr;

    @Autowired
    productDetailRepo pdr;

    public List<ProductDetail> getUserProduct(Integer id)
    {
        final int[] i = new int[1];
        List<product> pmodel = pr.fetchUserProduct(id);

        List<ProductDetail> pdmodel = new ArrayList<>();

        i[0] =0;
        pmodel.forEach(s->
        {
            pdmodel.add(pdr.fetchProductDetail(pmodel.get(i[0]).getId()));
            i[0] = i[0] +1;
        });

        return pdmodel;
    }
}
