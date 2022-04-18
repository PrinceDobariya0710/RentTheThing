package com.rent.project.productservice.repository;

import com.rent.project.productservice.models.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface productDetailRepo extends JpaRepository<ProductDetail,Integer> {

    @Query(value = "select * from product_detail where product_id=?1",nativeQuery = true)
    ProductDetail fetchProductDetail(Integer id);
}
