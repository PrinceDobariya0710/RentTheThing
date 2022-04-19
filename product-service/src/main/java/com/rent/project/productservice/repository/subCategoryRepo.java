package com.rent.project.productservice.repository;

import com.rent.project.productservice.models.subCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface subCategoryRepo extends JpaRepository<subCategory,Integer> {

    @Query(value = "select * from sub_category where sub_category_name=?1",nativeQuery = true)
    List<subCategory> getsubcategoryData(String category);
}
