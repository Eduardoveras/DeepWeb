/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import com.evapps.Service.CRUD.CreateDataService;
import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import com.evapps.Tools.Enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessController {

    // Services
    @Autowired
    private CreateDataService CDS;
    @Autowired
    private ReadDataService RDS;
    @Autowired
    private UpdateDataService URS;

    // Gets
    @GetMapping("/login_page")
    public ModelAndView loginPage(Model model){

        return new ModelAndView("");
    }

    @GetMapping("/register_page")
    public ModelAndView registerPage(Model model){

        return new ModelAndView("");
    }

    @GetMapping("/profile")
    public ModelAndView viewProfile(Model model){

        // TODO: Use current logged in users email
        //model.addAttribute("user", RDS.findRegisteredUserAccount(email));

        return new ModelAndView("");
    }

    @GetMapping("/myHistory")
    public ModelAndView viewHistory(Model model){

        // TODO: Use current logged in users email
        // model.addAttribute("browsingHistory", RDS.findRegisteredUserHistory(email).getBrowsingHistory());
        //model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(email).getShoppingCart());
        //model.addAttribute("transactions", RDS.findRegisteredUserTransactions(email));

        return new ModelAndView("");
    }

    @GetMapping("/transaction/{fiscalCode}")
    public ModelAndView viewTransaction(Model model, @PathVariable("fiscalCode") String fiscalCode){

        model.addAttribute("transaction", RDS.findRegisteredTransaction(fiscalCode));

        return new ModelAndView("");
    }

    // Post
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password){

        try {

            if (RDS.findRegisteredUserAccount(email, password))
                return "redirect:/"; // Login Successful
            else
                return "redirect:/login_page"; // TODO: Add error message
        } catch (Exception exp){
            //
        }

        return "redirect:/login_page"; // TODO: Add error message
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("first") String firstName, @RequestParam("last") String lastName, @RequestParam("address") String shippingAddress, @RequestParam("password") String password, @RequestParam("confirm") String confirmPassword, @RequestParam("type") Permission role){

        if (!password.equals(confirmPassword))
            return "redirect:/register_page"; // TODO: Add error message

        try {
            CDS.registerNewUser(email, firstName, lastName, shippingAddress, password, role);
            return "redirect:/login_page";
        } catch (Exception exp){
            //
        }

        return "redirect:/register_page"; // TODO: Add error message
    }

    @PostMapping("/user/change_password")
    public String changePassword(@RequestParam("old") String oldPassword, @RequestParam("new") String newPassword, @RequestParam("confirm") String confirmPassword){

        // TODO: Get Current User that is logged in
        //if (!RDS.findRegisteredUserAccount(email, password))
          //  return "redirect:/profile"; // TODO: Add error message

        if (oldPassword.equals(newPassword))
            return "redirect:/profile"; // TODO: Add error message

        if (!newPassword.equals(confirmPassword))
            return "redirect:/profile"; // TODO: Add error message

        try {
            // TODO: Change Current Users password
            return "redirect:/profile";
        } catch (Exception exp){
            //
        }

        return "redirect:/profile"; // TODO: Add error message
    }

    // TODO: Add edit posts and Upload Photo

    // TODO: RemoveFromCart
    // TODO: ClearCart
    // TODO: CancelTransaction
}
