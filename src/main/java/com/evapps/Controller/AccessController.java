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
import com.evapps.Tools.Enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.Set;

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

                                                                                                // TODO: Add edit posts

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
            DDS.deleteRegisteredPendingTransaction(fiscalCode);
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
