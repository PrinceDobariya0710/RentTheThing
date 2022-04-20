package com.rent.project.orderservice.repository;

import com.rent.project.orderservice.models.productmodels.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long aLong);

    @Modifying
    @Query(value = "UPDATE product SET available_pieces=:ap WHERE id=:product_id",nativeQuery = true)
    void updateAvailablePiece(@Param("ap") Integer new_quantity,@Param("product_id") Long productID);
}
