/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import com.evapps.Entity.Product;
import com.evapps.Service.CRUD.CreateDataService;
import com.evapps.Service.CRUD.DeleteDataService;
import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import com.evapps.Tools.Enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
public class AdminController {

    // Services
    @Autowired
    private CreateDataService CDS;
    @Autowired
    private ReadDataService RDS;
    @Autowired
    private UpdateDataService UDS;
    @Autowired
    private DeleteDataService DDS;

    // Gets
    @GetMapping("/admin")
    public ModelAndView index(Model model){

        if (!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("userRole", RDS.getCurrentLoggedUser().getRole());
        model.addAttribute("user", RDS.getSessionAttr("user"));

        if (RDS.getCurrentLoggedUser().getRole() != Permission.ADMIN)
            model.addAttribute("isAdmin", false);
        else
            model.addAttribute("isAdmin", true);

        return new ModelAndView("/Backend/homepage/index");
    }

    @GetMapping("/admin/inventory")
    public ModelAndView viewInventory(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("selection", RDS.findAllRegisteredProducts());

        return new ModelAndView("");
    }

    @GetMapping("/admin/users")
    public ModelAndView viewUsers(Model model){

        if (!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("userList", RDS.findAllRegisteredAccounts());

        return new ModelAndView("Backend/users/allUsers");
    }

    @GetMapping("/admin/transactions")
    public ModelAndView viewTransactions(Model model){

        if(!RDS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");

        model.addAttribute("transactions", RDS.findAllRegisteredTransactions());

        return new ModelAndView("");
    }

    // Posts
    @PostMapping("/add_new_product")
    public String registerNewProduct(@RequestParam("name") String productName, @RequestParam("supplier") String supplier, @RequestParam("description") String productDescription, @RequestParam("price") Float productPrice, @RequestParam("quantity") Integer productInStock){

        if(!RDS.isUserLoggedIn())
            return "redirect:/login";

        if (RDS.getCurrentLoggedUser().getRole() != Permission.ADMIN)
            return "redirect:/login"; // User must be an admin

        try {
            CDS.registerNewProduct(productName, supplier, productDescription, productPrice, productInStock);
            return "redirect:/admin/inventory";
        } catch (Exception exp){
            //
        }

        return "redirect:/admin/inventory"; // TODO: Add error handling
    }

    @PostMapping("/edit/product/{productId}")
    public String editProductInformation(@PathParam("productId") Integer productId, @RequestParam("name") String productName, @RequestParam("supplier") String supplier, @RequestParam("description") String productDescription, @RequestParam("price") Float productPrice){

        if(!RDS.isUserLoggedIn())
            return "redirect:/login";

        if (RDS.getCurrentLoggedUser().getRole() != Permission.ADMIN)
            return "redirect:/login"; // User must be an admin

        try {
            Product product = RDS.findRegisteredProduct(productId);

            if (!productName.equals(""))
                product.setProductName(productName);

            if (!supplier.equals(""))
                product.setSupplier(supplier);

            if (!productDescription.equals(""))
                product.setProductDescription(productDescription);

            if (productPrice != product.getProductPrice())
                product.setProductPrice(productPrice);

            UDS.updateRegisteredProduct(product);

            return "redirect:/admin/inventory";
        } catch (Exception exp){
            //
        }

        return "redirect:/admin/inventory"; // TODO: Add error handling
    }

    // TODO: deleteProduct
    // TODO: restockProduct
    // TODO: uploadProductImage
    // TODO: emailUser
    // TODO: suspendUserAccount
    // TODO: makeAdmin
    // TODO: printTransaction
    // TODO: downloadReport
}
