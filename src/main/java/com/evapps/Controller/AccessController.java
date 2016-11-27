/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import com.evapps.Entity.User;
import com.evapps.Service.CRUD.CreateDataService;
import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import com.evapps.Tools.Enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/login")
    public ModelAndView fetchLoginView(){
        return new ModelAndView("/Backend/users/login_register");
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
    @PostMapping("/userLogin")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,@RequestParam("origin") String origin){

        if (RDS.findRegisteredUserAccount(email.toLowerCase(), password))
        {
            User u = RDS.findRegisteredUserAccount(email.toLowerCase());
            RDS.setSessionAttr("user",u);
            return "redirect:"+origin; // TODO: filter which user is login in to redirect them to the correct url
        }
        else
            return "redirect:/login"; // TODO: Implement error exception or message to login
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

    @RequestMapping("/logout")
    public ModelAndView logOut(){
        if (!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/");

        RDS.logOut();
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/logout")
    public ModelAndView logOut2(@RequestParam("origin") String origin){
        if (!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/");

        RDS.logOut();
        return new ModelAndView("redirect:/");
    }

    // TODO: Add edit posts and Upload Photo

    // TODO: RemoveFromCart
    // TODO: ClearCart
    // TODO: CancelTransaction
    // TODO: MarkTransactionAsReceived
    // TODO: PrintTransaction
}
