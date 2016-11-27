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
import com.evapps.Tools.Enums.OrderStatus;
import com.evapps.Tools.Enums.Permission;
import freemarker.template.utility.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Set;

@Service
public class CreateDataService
{
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
    private EncryptionService encryptionService;

    // Product Creation
    public Product registerNewProduct(String productName, String supplier, String productDescription, Float productPrice, Integer productInStock) throws Exception{

        if (productPrice <= 0.00f)
            throw new IllegalArgumentException("All price must be positive decimal numbers");

        if (productInStock < 0)
            throw new IllegalArgumentException("There must be at least one unit registered");

        try {
            return productRepository.save(new Product(productName, supplier, productDescription, productPrice, productInStock));
        } catch (PersistenceException exp){
            throw new PersistenceException("Persistence Error --> " + exp.getMessage());
        } catch (NullArgumentException exp){
            throw new NullArgumentException("Null Argument Error --> " + exp.getMessage());
        } catch (Exception exp){
            throw new Exception("General Error --> " + exp.getMessage());
        }
    }

    // Receipt Creation
    public Receipt registerTransaction(String email, ArrayList<Integer> productList, Float total) throws Exception {

        if (!isEmailAddressTaken(email))
            throw new IllegalArgumentException("This user account does not exist");

        if (productList.isEmpty())
            throw new IllegalArgumentException("There needs to be purchased items to realize a transaction");

        if (total < 0.00f)
            throw new IllegalArgumentException("Nothing is free in life");

        try {

            // Clearing the shoppingCart
            History history = historyRepository.findByUser(email);
            Set<Product> shoppingCart = history.getShoppingCart(); // Fetching the user's shoppingCart
            for (Integer i:
                 productList) {
                Product product = productRepository.findByProductId(i); // Finding the product in the DB
                shoppingCart.remove(product); // Removing product
            }
            history.setShoppingCart(shoppingCart); // Updating History

            return receiptRepository.save(new Receipt(userRepository.findByEmail(email), productList, total));
        } catch (PersistenceException exp){
            throw new PersistenceException("Persistence Error --> " + exp.getMessage());
        } catch (NullArgumentException exp){
            throw new NullArgumentException("Null Argument Error --> " + exp.getMessage());
        } catch (Exception exp){
            throw new Exception("General Error --> " + exp.getMessage());
        }
    }

    // User and History Creation
    public User registerNewUser(String email, String firstName, String lastName, String shippingAddress, String password, Permission permission) throws Exception{

        if (isEmailAddressTaken(email))
            throw new IllegalArgumentException("This user Account already exist");

        try {
            User user = userRepository.save(new User(email, firstName, lastName, encryptionService.encryptPassword(password), shippingAddress, permission));
            historyRepository.save(new History(user)); // Creating the users history
            return user;
        } catch (PersistenceException exp){
            throw new PersistenceException("Persistence Error --> " + exp.getMessage());
        } catch (NullArgumentException exp){
            throw new NullArgumentException("Null Argument Error --> " + exp.getMessage());
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
