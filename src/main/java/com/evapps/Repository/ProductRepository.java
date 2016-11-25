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
    Product findByProductId(String productId);

    @Query("select p from Product p where p.clinic.clinicId = :clinic")
    List<Product> findByClinic(@Param("clinic") String clinicId);

    @Query("select p from Product p where p.productName = :name and p.clinic.clinicId = :clinic")
    List<Product> findByProductName(@Param("name") String productName, @Param("clinic") String clinicId);
}
