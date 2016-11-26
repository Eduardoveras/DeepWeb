/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
public class StoreController {
    // Services
    @Autowired
    private ReadDataService RDS;
    @Autowired
    private UpdateDataService UDS;

    // Gets
    @GetMapping("/home")
    public ModelAndView store(Model model){

        // TODO: Use current logged in users email
        //model.addAttribute("shoppingCart", RDS.findRegisteredUserHistory(email).getShoppingCart());
        model.addAttribute("selection", RDS.findAllRegisteredProducts());

        return new ModelAndView("");
    }

    @GetMapping("/item/{id}")
    public ModelAndView item(Model model, @PathParam("id") Integer productId){

        model.addAttribute("item", RDS.findRegisteredProduct(productId));

        return new ModelAndView("");
    }

    // Posts
    // TODO: AddToCart
    // TODO: On-click Buy form one item
}
