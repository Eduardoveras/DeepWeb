/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import com.evapps.Service.CRUD.CreateDataService;
import com.evapps.Service.CRUD.DeleteDataService;
import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Service.CRUD.UpdateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping("/dashboard")
    public ModelAndView home(Model model){

        return new ModelAndView("");
    }

    @GetMapping("/inventory")
    public ModelAndView viewInventory(Model model){

        model.addAttribute("selection", RDS.findAllRegisteredProducts());

        return new ModelAndView("");
    }

    @GetMapping("/users")
    public ModelAndView viewUsers(Model model){

        model.addAttribute("users", RDS.findAllRegisteredAccounts());

        return new ModelAndView("");
    }

    @GetMapping("/transactions")
    public ModelAndView viewTransactions(Model model){

        model.addAttribute("transactions", RDS.findAllRegisteredTransactions());

        return new ModelAndView("");
    }

    // Posts
    // TODO: registerNewProduct
    // TODO: editProduct
    // TODO: deleteProduct
    // TODO: restockProduct
    // TODO: uploadProductImage
    // TODO: emailUser
    // TODO: suspendUserAccount
    // TODO: makeAdmin
    // TODO: printTransaction
    // TODO: downloadReport
}
