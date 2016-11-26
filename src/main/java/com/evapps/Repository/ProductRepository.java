/**
 * Created by Djidjelly Siclait on 11/1/2016.
 */
package com.evapps.Repository;

import com.evapps.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByProductId(Integer productId);

    @Query("select p from Product p where p.productName = :name")
    List<Product> findByName(@Param("name") String productName);

    @Query("select p from Product p where p.supplier = :supplier")
    List<Product> findBySupplier(@Param("supplier") String supplier);

    @Query("select p from Product p where p.productPrice between :low and :high")
    List<Product> findByPriceRange(@Param("low") Float minPrice, @Param("high") Float maxPrice);
}
