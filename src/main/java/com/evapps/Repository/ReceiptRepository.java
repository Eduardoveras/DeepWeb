/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Repository;

import com.evapps.Entity.Receipt;
import com.evapps.Tools.Enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, String> {

    Receipt findByFiscalCode(String fiscalCode);

    @Query("select r from Receipt r where r.user.email = :email")
    List<Receipt> findByUser(@Param("email") String email);

    @Query("select r from Receipt r where r.status = :status")
    List<Receipt> findByOrderStatus(@Param("status") OrderStatus status);
}
