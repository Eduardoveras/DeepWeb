package com.evapps.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Eduardo veras on 27-Nov-16.
 */
@Controller
public class StoreFrontController {


    // Gets
    @GetMapping("/")
    public ModelAndView storeFront(Model model){
        return new ModelAndView("StoreFront/index");
    }

    @GetMapping("/account")
    public ModelAndView account(Model model){
        return new ModelAndView("StoreFront/account");
    }

    @GetMapping("/cart")
    public ModelAndView cart(Model model){
        return new ModelAndView("StoreFront/cart");
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(Model model){
        return new ModelAndView("StoreFront/checkout");
    }

    @GetMapping("/product")
    public ModelAndView productList(Model model){
        return new ModelAndView("StoreFront/product");
    }

    @GetMapping("/product-detail")
    public ModelAndView product(Model model){
        return new ModelAndView("StoreFront/product-detail");
    }
}
