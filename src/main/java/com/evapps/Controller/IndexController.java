/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import com.evapps.Service.CRUD.ReadDataService;
import com.evapps.Tools.Enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class IndexController {

    // Services
    // TODO: Add necessary services
    @Autowired
    private ReadDataService DQS;

    // Gets
    @GetMapping("/admin")
    public ModelAndView index(Model model){
        if (!DQS.isUserLoggedIn())
            return new ModelAndView("redirect:/login");
        
        model.addAttribute("userRole",DQS.getCurrentLoggedUser().getRole());

        
        model.addAttribute("user",DQS.getSessionAttr("user"));

        if (DQS.getCurrentLoggedUser().getRole() != Permission.ADMIN)
            model.addAttribute("isAdmin", false);
        else
            model.addAttribute("isAdmin", true);

        return new ModelAndView("/Backend/homepage/index");
    }

}
