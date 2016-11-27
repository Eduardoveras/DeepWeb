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
import com.evapps.Service.Auxiliary.EncryptionService;
import com.evapps.Tools.Enums.AccountStatus;
import com.evapps.Tools.Enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private HttpSession session;
    @Autowired
    private EncryptionService EncriptService;


    public Object getSessionAttr(String name)
    {
        return session.getAttribute(name);
    }

    public void setSessionAttr(String name,Object obj)
    {
        session.setAttribute(name,obj);
    }

    // Single Search
    public History findRegisteredUserHistory(String email) { return historyRepository.findByUser(email); }

    public Product findRegisteredProduct(Integer productId) { return productRepository.findByProductId(productId); }

    public Receipt findRegisteredTransaction(String fiscalCode) { return receiptRepository.findByFiscalCode(fiscalCode); }

    public User findRegisteredUserAccount(String email) { return userRepository.findByEmail(email); } // Used for profiles

    public boolean findRegisteredUserAccount(String email, String password) {
        User user = userRepository.findUserAccountWithUsernameAndPassword(email, EncriptService.encryptPassword(password));
        return (user != null);
    }

    // Complete Search
    public List<Product> findAllRegisteredProducts() { return productRepository.findAll(); }

    public List<Receipt> findAllRegisteredTransactions() { return receiptRepository.findAll(); }

    public List<User> findAllRegisteredAccounts() { return userRepository.findAll(); }

    // Specific Search
    public List<Product> findRegisteredProductsWithName(String name) { return productRepository.findByName(name); }

    public List<Product> findRegisteredProductsFromSupplier(String supplier) { return productRepository.findBySupplier(supplier); }

    public List<Product> findRegisteredProductsByPriceRange(Float minPrice, Float maxPrice){

        if (minPrice < 0.00f || maxPrice < 0.00f)
            throw new IllegalArgumentException("Price range must be in the positive");

        if (minPrice < maxPrice)
            return productRepository.findByPriceRange(minPrice, maxPrice);
        else
            return productRepository.findByPriceRange(maxPrice, minPrice);
    }

    public List<Receipt> findRegisteredUserTransactions(String email) {

        if (!isEmailAddressTaken(email))
            throw new IllegalArgumentException("This user account does not exist");

        return receiptRepository.findByUser(email);
    }

    public List<Receipt> findRegisteredTransactionByStatus(OrderStatus status) { return receiptRepository.findByOrderStatus(status); }

    public List<User> findRegisteredAccountsByStatus(AccountStatus status) { return userRepository.findByAccountStatus(status); }
    // TODO: Add specific searches as the need comes

    // Auxiliary Functions
    private boolean isEmailAddressTaken(String email){
        User user = userRepository.findByEmail(email);
        return (user != null);
    }

    public boolean isUserLoggedIn() {
        return null != session.getAttribute("user");
    }

    public void logOut()
    {
        session.invalidate();
    }

    public User getCurrentLoggedUser()
    {
        return (User)session.getAttribute("user");
    }

    // User Queries
    public User findUserInformation(String email) { return userRepository.findByEmail(email); }



}
