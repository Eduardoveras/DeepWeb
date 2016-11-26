/**
 * Created by Djidjelly Siclait on 10/2/2016.
 */
package com.evapps.Repository;

import com.evapps.Entity.User;
import com.evapps.Tools.Enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, String>{

    User findByEmail(String email);

    @Query("select u from User u where u.email = :email and u.password = :password")
    User findUserAccountWithUsernameAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("select u from User u where u.firstName = :first and u.lastName = :last")
    List<User> findByFullName(@Param("first") String firstName, @Param("last") String lastName);

    @Query("select u from User u where u.status = :status")
    List<User> findByAccountStatus(@Param("status") AccountStatus status);
}
