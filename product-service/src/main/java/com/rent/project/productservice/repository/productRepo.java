package com.rent.project.productservice.repository;

import com.rent.project.productservice.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface productRepo extends JpaRepository<product,Integer> {

    @Query(value = "select * from product where user_id=?1",nativeQuery = true)
    List<product> fetchUserProduct(Integer id);

    @Query(value = "select * from product where sub_category=?1",nativeQuery = true)
    List<product> fetchCategoryProduct(String category);

}
