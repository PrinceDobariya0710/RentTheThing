package com.rent.project.productservice.repository;

import com.rent.project.productservice.models.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepo extends JpaRepository<category,Integer> {

}
