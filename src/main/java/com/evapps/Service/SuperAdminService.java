/**
 * Created by Djidjelly Siclait on 10/30/2016.
 */
package com.evapps.Service;

import com.evapps.Entity.User;
import com.evapps.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminService {


    @Autowired
    private UserRepository userRepository;

    // User Queries
    public List<User> findAllRegisteredUserAccounts(){ return userRepository.findAll(); }

    public User findUserInformation(String userId) { return userRepository.findByUserId(userId); }

    public User findRegisteredUserAccount(String email, String clinicId){ return userRepository.findUserAccountWithUsernameAndPassword(email, clinicId); }

    public List<User> findAllAllRegisteredUsersForClinic(String clinicId) { return userRepository.findByClinicId(clinicId); }

}
