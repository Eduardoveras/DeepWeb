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
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;
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
            jasperStream = new FileInputStream(new File("").getAbsolutePath().concat("\\src\\main\\resources\\templates\\jasperreports\\transaction.jasper"));

            if (jasperStream == null){
                 JasperCompileManager.compileReportToFile(new File("").getAbsolutePath().concat("\\src\\main\\resources\\templates\\jasperreports\\transaction.jrxml"), new File("").getAbsolutePath().concat("\\src\\main\\resources\\templates\\jasperreports\\transaction.jasper"));
                 jasperStream = this.getClass().getResourceAsStream(new File("").getAbsolutePath().concat("\\src\\main\\resources\\templates\\jasperreports\\transaction.jasper"));
            }

            Map<String, Object> params = new HashMap<>();
            params.put("FiscalCode", fiscalCode);

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

            JRDataSource data = new JRMapArrayDataSource(fetchTransactionDataSource());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, data/*new JREmptyDataSource()*/);

            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=Transaction_Report_" + fiscalCode + ".pdf");

            final OutputStream outputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            response.reset(); // Possibly cleans this stuff
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
            ArrayList<Integer> amount = history.getAmount(); // Fetching the amount bought of each product

            ArrayList<Integer> productList = new ArrayList<>();
            Float total = 0.00f;
            int count = 0;

            for (Product product:
                    shoppingCart) {
                if (product.getProductInStock() > 0){
                    // Saving transaction registry
                    productList.add(product.getProductId());
                    // Calculating total cost of transaction
                    total += product.getProductPrice() * amount.get(count);

                    // Updating inventory
                    product.setProductInStock(product.getProductInStock() - amount.get(count++));
                    UDS.updateRegisteredProduct(product);
                }
            }
            
            history.setShoppingCart(new HashSet<>()); // Clearing Shopping cart

            //Completing transaction
            Receipt receipt = CDS.registerTransaction(RDS.getCurrentLoggedUser().getEmail(), productList, amount, total);

            // TODO: Send email to admin for order confirmation
            return "redirect:/download_pdf/transaction?fiscalCode=" + receipt.getFiscalCode();

            //return "redirect:/myHistory";
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
            ArrayList<Integer> amount = history.getAmount();
            Product product = RDS.findRegisteredProduct(productId);

            int count = 0;
            for (Product p: shoppingCart)
                if (p.getProductId().equals(productId))
                    break;
                else
                    count++;

            amount.remove(count);
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
            int count = 0;
            for (Integer productId:
                 receipt.getProductList()) {
                Product product = RDS.findRegisteredProduct(productId);
                product.setProductInStock(product.getProductInStock() + receipt.getAmount().get(count));
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

    // Auxiliary Functions
    private Byte[] processImageFile(byte[] buffer) {
        Byte[] bytes = new Byte[buffer.length];
        int i = 0;

        for (byte b :
                buffer)
            bytes[i++] = b; // Autoboxing

        return bytes;
    }

    private Map[] fetchTransactionDataSource(){
        HashMap[] rows = new HashMap[RDS.findAllRegisteredTransactions().size()];
        int count = 0;

        for (Receipt r:
                RDS.findAllRegisteredTransactions()) {
            HashMap data = new HashMap();
            data.put("fiscal", r.getFiscalCode());
            data.put("user_email", r.getUser().getEmail());
            data.put("user_name", r.getUser().getFullName());
            data.put("time", r.getTransactionDate().toString().substring(0, r.getTransactionDate().toString().length() - 2));
            data.put("total", "$" + r.getTotal().toString());
            data.put("content", formatReceiptBody(r.getProductList(), r.getAmount()));

            rows[count++] = data;
        }

        return rows;
    }

    private String formatReceiptBody(ArrayList<Integer> products, ArrayList<Integer> amount){
        String buffer = "";
        int count = 0;

        for (Integer i:
             products) {
            Product product = RDS.findRegisteredProduct(i);
            buffer += amount.get(count++).toString() + "x " + product.getProductName() + " ------ $" + product.getProductPrice().toString() + "\n";
        }

        return buffer;
    }
}
