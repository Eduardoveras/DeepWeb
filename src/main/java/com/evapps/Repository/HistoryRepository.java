/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Repository;

import com.evapps.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HistoryRepository extends JpaRepository<History, String> {

    History findByHistoryId(Integer historyId);

    @Query("select h from History h where h.user.email = :email")
    History findByUser(@Param("email") String email);
}
