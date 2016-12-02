package com.evapps.Controller;

import com.evapps.Entity.Product;
import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;

/**
 * Created by Eduardo veras on 27-Nov-16.
 */
@Controller
public class StoreFrontController {
    // Services
    @Autowired
    private ReadDataService RDS;
    @Autowired
    private UpdateDataService UDS;

    // Gets
    @GetMapping("/")
    public ModelAndView storeFront(Model model) {

        model.addAttribute("user", RDS.getCurrentLoggedUser());

        if(RDS.getCurrentLoggedUser() != null)
            model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail()).getShoppingCart());
        else
            model.addAttribute("shoppingCart", new HashSet<Product>()); // empty cart

        model.addAttribute("selection", RDS.findAllRegisteredProducts());

        return new ModelAndView("StoreFront/index");
    }

    @GetMapping("/account")
    public ModelAndView account(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        return new ModelAndView("StoreFront/account");
    }

    @GetMapping("/cart")
    public ModelAndView cart(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        return new ModelAndView("StoreFront/cart");
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        return new ModelAndView("StoreFront/checkout");
    }

    @GetMapping("/product")
    public ModelAndView productList(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        return new ModelAndView("StoreFront/product");
    }

    @GetMapping("/product-detail/{id}")
    public ModelAndView product(Model model, @PathVariable("id") Integer productId) {

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("item", RDS.findRegisteredProduct(productId));

        return new ModelAndView("StoreFront/product-detail");
    }

    // Posts
}
