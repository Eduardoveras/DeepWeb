/**
 * Created by Djidjelly Siclait on 10/2/2016.
 */
package com.evapps.Repository;

import com.evapps.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, String>{

    User findByUserId(String userId);

    @Query("select u from User u where u.clinic.clinicId = :clinic")
    List<User> findByClinicId(@Param("clinic") String clinicId);

    @Query("select u from User u where u.firstName = :first and u.lastName = :last")
    List<User> findByFullName(@Param("first") String firstName, @Param("last") String lastName);

    @Query("select u from User u where u.email = :email and u.password = :password")
    User findUserAccountWithUsernameAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("select u from User u where u.email = :email and u.password = :password")
    User findUserAccountWithUsernameAndClinicIdAndPassword(@Param("email") String email, @Param("password") String password);

}
