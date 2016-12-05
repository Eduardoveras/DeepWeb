/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import com.evapps.Entity.History;
import com.evapps.Entity.Product;
import com.evapps.Entity.Receipt;
import com.evapps.Entity.User;
import com.evapps.Service.CRUD.CreateDataService;
import com.evapps.Service.CRUD.DeleteDataService;
import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import com.evapps.Tools.Enums.AccountStatus;
import com.evapps.Tools.Enums.OrderStatus;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.*;

@Controller
public class AccessController {

    // Services
    @Autowired
    private CreateDataService CDS;
    @Autowired
    private DeleteDataService DDS;
    @Autowired
    private ReadDataService RDS;
    @Autowired
    private UpdateDataService UDS;

    // Gets
    @GetMapping("/login")
    public ModelAndView fetchLoginView(){

        if(RDS.isUserLoggedIn()) // There is no need to log in if already logged in
            return new ModelAndView("redirect:/");

        return new ModelAndView("/Backend/users/login_register");
    }

    @GetMapping("/profile")
    public ModelAndView viewProfile(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("user", RDS.findRegisteredUserAccount(RDS.getCurrentLoggedUser().getEmail()));

        return new ModelAndView("");
    }

    @GetMapping("/myHistory")
    public ModelAndView viewHistory(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("browsingHistory", RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail()).getBrowsingHistory());
        model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail()).getShoppingCart());
        model.addAttribute("transactions", RDS.findRegisteredUserTransactions(RDS.getCurrentLoggedUser().getEmail()));

        return new ModelAndView("");
    }

    @GetMapping("/transaction/{fiscalCode}")
    public ModelAndView viewTransaction(Model model, @PathVariable("fiscalCode") String fiscalCode){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("transaction", RDS.findRegisteredTransaction(fiscalCode));

        return new ModelAndView("");
    }

    @GetMapping("/download_pdf/transaction")
    @ResponseBody
    public void downloadTransaction(@RequestParam("fiscalCode") String fiscalCode, HttpServletResponse response) throws JRException, IOException{

        InputStream jasperStream;

        try {
             //jasperStream = this.getClass().getResourceAsStream("C:/Users/Djidjelly Siclait/Desktop/Repositories/DeepWeb/src/main/resources/templates/jasperreports/transaction.jasper");
            URL f = getClass().getResource("C:/Users/Djidjelly Siclait/Desktop/Repositories/DeepWeb/src/main/resources/templates/jasperreports/transaction.jasper");
            jasperStream = f.openStream();
             if (jasperStream == null){
                 //URL location = getClass().getResource("/templates/jasperreports/transaction.jrxml");
                 //File src = new File(location.getFile());
                 //String t = src.getPath();
                 //long size = src.length();
                 JasperCompileManager.compileReportToFile("C:/Users/Djidjelly Siclait/Desktop/Repositories/DeepWeb/src/main/resources/templates/jasperreports/transaction.jrxml", "C:/Users/Djidjelly Siclait/Desktop/Repositories/DeepWeb/src/main/resources/templates/jasperreports/transaction.jasper");
                 jasperStream = this.getClass().getResourceAsStream("C:/Users/Djidjelly Siclait/Desktop/Repositories/DeepWeb/src/main/resources/templates/jasperreports/transaction.jasper");
             }

            Map<String, Object> params = new HashMap<>();
            params.put("Title", "Transaction Report");
            params.put("fiscalCode", fiscalCode);

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=Transaction_Report_" + fiscalCode + ".pdf");

            final OutputStream outputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        } catch (Exception exp){
            System.out.println(exp.getMessage());
        }
    }

    // Post
    @PostMapping("/userLogin")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("origin") String origin){

        if(RDS.isUserLoggedIn()) // There is no need to log in if already logged in
            return "redirect:/";

        if (RDS.findRegisteredUserAccount(email.toLowerCase(), password))
        {
            User u = RDS.findRegisteredUserAccount(email.toLowerCase());

            if (u.getStatus() == AccountStatus.SUSPENDED)
                return "redirect:/login"; // TODO: Implement "You have been blocked" message

            RDS.setSessionAttr("user", u);
            return "redirect:" + origin;
        }
        else
            return "redirect:/login"; // TODO: Implement error exception or message to login
    }

    @PostMapping("/user/change_password")
    public String changePassword(@RequestParam("old") String oldPassword, @RequestParam("new") String newPassword, @RequestParam("confirm") String confirmPassword){

        if(!RDS.isUserLoggedIn())
            return "redirect:/login";

        if (!RDS.findRegisteredUserAccount(RDS.getCurrentLoggedUser().getEmail(), oldPassword))
            return "redirect:/profile"; // TODO: Add error message

        if (oldPassword.equals(newPassword))
            return "redirect:/profile"; // TODO: Add error message

        if (!newPassword.equals(confirmPassword))
            return "redirect:/profile"; // TODO: Add error message

        try {
            User user = RDS.findRegisteredUserAccount(RDS.getCurrentLoggedUser().getEmail());
            user.setPassword(newPassword);
            UDS.updateRegisteredUserAccount(user);

            return "redirect:/profile";
        } catch (Exception exp){
            //
        }

        return "redirect:/profile"; // TODO: Add error message
    }

    @RequestMapping("/logout")
    public ModelAndView logOut(){
        if (!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        RDS.logOut();
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/logout")
    public ModelAndView logOut2(@RequestParam("origin") String origin){

        if (!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        RDS.logOut();
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/edit/first_name")
    public String editFirstName(@RequestParam("email") String email, @RequestParam("new") String newName){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            User user = RDS.findRegisteredUserAccount(email);
            user.setFirstName(newName);
            UDS.updateRegisteredUserAccount(user);

            return "redirect:/profile";
        } catch (Exception exp){
            //
        }

        return "redirect:/profile"; // TODO: Add error message
    }

    @PostMapping("/edit/last_name")
    public String editLastName(@RequestParam("email") String email, @RequestParam("new") String newName){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            User user = RDS.findRegisteredUserAccount(email);
            user.setLastName(newName);
            UDS.updateRegisteredUserAccount(user);

            return "redirect:/profile";
        } catch (Exception exp){
            //
        }

        return "redirect:/profile"; // TODO: Add error message
    }

    @PostMapping("/edit/full_address")
    public String editCompleteAddress(@RequestParam("email") String email, @RequestParam("newAdress") String newAddress, @RequestParam("newCountry") String newCountry, @RequestParam("newCity") String newCity){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            User user = RDS.findRegisteredUserAccount(email);
            user.setShippingAddress(newAddress);
            user.setCountry(newCountry);
            user.setCity(newCity);
            UDS.updateRegisteredUserAccount(user);

            return "redirect:/profile";
        } catch (Exception exp){
            //
        }

        return "redirect:/profile"; // TODO: Add error message
    }

    @PostMapping("/upload/user_picture")
    public String uploadUserProfilePicture(@RequestParam("email") String email, @RequestParam("file") MultipartFile picture){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            User user = RDS.findRegisteredUserAccount(email);
            user.setPhoto(processImageFile(picture.getBytes()));
            UDS.updateRegisteredUserAccount(user);

            return "redirect:/profile";
        } catch (Exception exp){
            //
        }

        return "redirect:/profile"; // TODO: Add error message
    }

    @PostMapping("/confirm_transaction")
    public String buyItemsInCart(){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            // Fetching shoppingCart
            History history = RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail());
            Set<Product> shoppingCart = history.getShoppingCart(); // Fetching the user's shoppingCart

            ArrayList<Integer> productList = new ArrayList<>();
            Float total = 0.00f;

            for (Product product:
                    shoppingCart) {
                if (product.getProductInStock() > 0){
                    // Saving transaction registry
                    productList.add(product.getProductId());
                    // Calculating total cost of transaction
                    total += product.getProductPrice();

                    // Updating inventory
                    product.setProductInStock(product.getProductInStock() - 1);
                    UDS.updateRegisteredProduct(product);
                }
            }
            
            history.setShoppingCart(new HashSet<>()); // Clearing Shopping cart

            //Completing transaction
            Receipt receipt = CDS.registerTransaction(RDS.getCurrentLoggedUser().getEmail(), productList, total);

            // TODO: Send email to admin for order confirmation
            // TODO: create downloadable Jasper Report of Transaction

            return "redirect:/myHistory";
        } catch (Exception exp){
            //
        }

        return "redirect:/myHistory"; // TODO: Add error message
    }

    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathParam("productId") Integer productId){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            History history = RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail());
            Set<Product> shoppingCart = history.getShoppingCart();
            Product product = RDS.findRegisteredProduct(productId);

            shoppingCart.remove(product);
            history.setShoppingCart(shoppingCart);

            UDS.updateRegisteredUserHistory(history);

            return "redirect:/myHistory";
        } catch (Exception exp){
            //
        }

        return "redirect:/myHistory"; // TODO: Add error message
    }

    @PostMapping("/clear")
    public String clearCart(){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            History history = RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail());
            history.setShoppingCart(new HashSet<>());
            UDS.updateRegisteredUserHistory(history);

            return "redirect:/myHistory";
        } catch (Exception exp){
            //
        }

        return "redirect:/myHistory"; // TODO: Add error message
    }

    @PostMapping("/cancel/{fiscalCode}")
    public String cancelTransaction(@PathParam("fiscalCode") String fiscalCode){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        // Only pending orders can be deleted, once shipped or received it can no longer be canceled
        if (RDS.findRegisteredTransaction(fiscalCode).getStatus() != OrderStatus.PENDING)
            return "redirect:/myHistory"; // TODO: Add error message

        try {
            // Updating Inventory
            Receipt receipt = RDS.findRegisteredTransaction(fiscalCode);
            for (Integer productId:
                 receipt.getProductList()) {
                Product product = RDS.findRegisteredProduct(productId);
                product.setProductInStock(product.getProductInStock() + 1);
                UDS.updateRegisteredProduct(product);
            }

            DDS.deleteRegisteredPendingTransaction(fiscalCode);

            // TODO: email admin of order cancelation

            return "redirect:/myHistory";
        } catch (Exception exp){
            //
        }

        return "redirect:/myHistory"; // TODO: Add error message
    }

    @PostMapping("/received/{fiscalCode}")
    public String markTransactionAsReceived(@PathParam("fiscalCode") String fiscalCode){

        if (!RDS.isUserLoggedIn())
            return "redirect:/login";

        // Only shipped items can be received
        if (RDS.findRegisteredTransaction(fiscalCode).getStatus() != OrderStatus.SHIPPING)
            return "redirect:/myHistory"; // TODO: Add error message

        try {
            Receipt receipt = RDS.findRegisteredTransaction(fiscalCode);
            receipt.setStatus(OrderStatus.DELIVERED);
            UDS.updateRegisteredUserTransaction(receipt);

            return "redirect:/myHistory";
        } catch (Exception exp){
            //
        }

        return "redirect:/myHistory"; // TODO: Add error message
    }

                                                                                                // TODO: PrintTransaction

    // Auxiliary Functions
    private Byte[] processImageFile(byte[] buffer) {
        Byte[] bytes = new Byte[buffer.length];
        int i = 0;

        for (byte b :
                buffer)
            bytes[i++] = b; // Autoboxing

        return bytes;
    }
}
