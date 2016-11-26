/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Service.CRUD;

import com.evapps.Entity.History;
import com.evapps.Entity.Product;
import com.evapps.Entity.Receipt;
import com.evapps.Entity.User;
import com.evapps.Repository.HistoryRepository;
import com.evapps.Repository.ProductRepository;
import com.evapps.Repository.ReceiptRepository;
import com.evapps.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadDataService {

    // Repositories
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private UserRepository userRepository;

    // Single Search
    public History findRegisteredUserHistory(String email) { return historyRepository.findByUser(email); }

    public Product findRegisteredProduct(Integer productId) { return productRepository.findByProductId(productId); }

    public Receipt findRegisteredTransaction(String fiscalCode) { return receiptRepository.findByFiscalCode(fiscalCode); }

    public User findRegisteredUserAccount(String email) { return userRepository.findByEmail(email); }

    // Complete Search
    public List<Product> findAllRegisteredProducts() { return productRepository.findAll(); }

    public List<Receipt> findAllRegisteredTransactions() { return receiptRepository.findAll(); }

    public List<User> findAllRegisteredAccounts() { return userRepository.findAll(); }

    // Specific Search
    public List<Receipt> findRegisteredUserTransactions(String email) {

        if (!isEmailAddressTaken(email))
            throw new IllegalArgumentException("This user account does not exist");

        return receiptRepository.findByUser(email);
    }
    // TODO: Add specific searches as the need comes

    // Auxiliary Functions
    private boolean isEmailAddressTaken(String email){
        User user = userRepository.findByEmail(email);
        return (user != null);
    }
}
