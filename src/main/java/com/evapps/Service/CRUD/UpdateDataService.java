/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Service.CRUD;

import com.evapps.Entity.History;
import com.evapps.Entity.Product;
import com.evapps.Entity.User;
import com.evapps.Repository.HistoryRepository;
import com.evapps.Repository.ProductRepository;
import com.evapps.Repository.UserRepository;
import freemarker.template.utility.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

@Service
public class UpdateDataService {

    // Repositories
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    // History Updates
    public void updareRegisteredUserHistory(History history) throws Exception{

        if (history == null)
            throw new NullArgumentException("This history is void");

        try {
            historyRepository.save(history);
        } catch (PersistenceException exp){
            throw new PersistenceException("Persistence Error --> " + exp.getMessage());
        } catch (Exception exp){
            throw new Exception("General Error --> " + exp.getMessage());
        }
    }

    // Product Updates
    public void updateRegisteredProduct(Product product) throws Exception {

        if (product == null)
            throw new NullArgumentException("This product is void");

        try {
            productRepository.save(product);
        } catch (PersistenceException exp){
            throw new PersistenceException("Persistence Error --> " + exp.getMessage());
        } catch (Exception exp){
            throw new Exception("General Error --> " + exp.getMessage());
        }
    }

    // User and History Updates
    public void updateRegisteredUserAccount(User user) throws Exception {

        if (user == null)
            throw new NullArgumentException("This user has a null value");

        if (!isEmailAddressTaken(user.getEmail()))
            throw new IllegalArgumentException("This user account does not exist");

        try {
            // Updating user
            userRepository.save(user);

            // Updating History
            History history = historyRepository.findByUser(user.getEmail());

            history.setUser(user);

            historyRepository.save(history);
        } catch (PersistenceException exp){
            throw new PersistenceException("Persistence Error --> " + exp.getMessage());
        } catch (Exception exp){
            throw new Exception("General Error --> " + exp.getMessage());
        }
    }

    // Auxiliary Functions
    private boolean isEmailAddressTaken(String email){
        User user = userRepository.findByEmail(email);
        return (user != null);
    }
}
