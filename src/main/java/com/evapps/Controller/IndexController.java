/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    // Services
    // TODO: Add necessary services

    // Gets
    @GetMapping("/")
    public ModelAndView index(Model model){

        return new ModelAndView("");
    }


    // Posts
}
