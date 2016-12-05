package com.evapps.Controller;

import com.evapps.Entity.History;
import com.evapps.Entity.Product;
import com.evapps.Service.CRUD.CreateDataService;
import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eduardo veras on 27-Nov-16.
 */
@Controller
public class StoreFrontController {
    // Services
    @Autowired
    private CreateDataService CDS;
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


        return new ModelAndView("StoreFront/homepage/index");
    }

    @GetMapping("/account")
    public ModelAndView account(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        return new ModelAndView("StoreFront/account");
    }

    @GetMapping("/cart")
    public ModelAndView cart(Model model){
        if(RDS.getCurrentLoggedUser() != null)
            model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail()).getShoppingCart());
        else
            model.addAttribute("shoppingCart", new HashSet<Product>()); // empty cart


        return new ModelAndView("StoreFront/cart");
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(Model model){

        if(RDS.getCurrentLoggedUser() != null)
            model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail()).getShoppingCart());
        else
            model.addAttribute("shoppingCart", new HashSet<Product>()); // empty cart

        return new ModelAndView("StoreFront/checkout");
    }

    @GetMapping("/products")
    public ModelAndView productList(Model model){

        if(RDS.getCurrentLoggedUser() != null)
            model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail()).getShoppingCart());
        else
            model.addAttribute("shoppingCart", new HashSet<Product>()); // empty cart

        model.addAttribute("selection", RDS.findAllRegisteredProducts());

        return new ModelAndView("StoreFront/product_list/product");
    }

    @GetMapping("/product-detail/{id}")
    public ModelAndView product(Model model, @PathVariable("id") String productId) {
        if(RDS.getCurrentLoggedUser() != null)
            model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail()).getShoppingCart());
        else
            model.addAttribute("shoppingCart", new HashSet<Product>()); // empty cart


        Product product = RDS.findRegisteredProduct(Integer.parseInt(productId));

        model.addAttribute("item", product);

        try {
            History history = RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail());
            Set<Product> browsingHistory = history.getBrowsingHistory();

            // Updating the browsing history
            browsingHistory.add(product);
            history.setBrowsingHistory(browsingHistory);

            UDS.updateRegisteredUserHistory(history);
        } catch (Exception exp){
            //
        }

        return new ModelAndView("StoreFront/product_details/product-detail");
    }

    // Posts
    @PostMapping("/add_to_cart")
    public String addToCart(@RequestParam("productId") String productId){

        if(!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            Product product = RDS.findRegisteredProduct(Integer.parseInt(productId));

            if (product.getProductInStock() > 0) {
                History history = RDS.findRegisteredUserHistory(RDS.getCurrentLoggedUser().getEmail());
                Set<Product> shoppingCart = history.getShoppingCart();
                Set<Product> browsingHistory = history.getBrowsingHistory();

                // Adding to cart
                shoppingCart.add(product);
                history.setShoppingCart(shoppingCart);

                // Updating the browsing history
                browsingHistory.add(product);
                history.setBrowsingHistory(browsingHistory);

                UDS.updateRegisteredUserHistory(history);

                return "redirect:/"; // TODO: this should go back to the origin - store page, or product detail
            } else
                return "redirect:/"; // TODO: this should go back to the origin - store page, or product detail with error message
        } catch (Exception exp){
            //
        }

        return "redirect:/"; // TODO: Add error handling
    }

    @PostMapping("/one_click/quick_buy")
    public String oneClickBuy(@RequestParam("productId") Integer productId){

        if(!RDS.isUserLoggedIn())
            return "redirect:/login";

        try {
            Product product = RDS.findRegisteredProduct(productId);
            ArrayList<Integer> list = new ArrayList<>();

            if (product.getProductInStock() > 0) {
                list.add(product.getProductId());

                // Updating Inventory
                product.setProductInStock(product.getProductInStock() - 1);
            }

            CDS.registerTransaction(RDS.getCurrentLoggedUser().getEmail(), list, product.getProductPrice());

            // TODO: send email to admin to confirm transaction
            // TODO: Add jasper Report

            return "redirect:/"; // TODO: this should go back to the origin - store page, or product detail
        } catch (Exception exp){
            //
        }

        return "redirect:/"; // TODO: Add error handling
    }

}
