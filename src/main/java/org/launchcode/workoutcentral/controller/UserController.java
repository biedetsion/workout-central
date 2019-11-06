package org.launchcode.workoutcentral.controller;


import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify){
        // model.addAttribute(new User());
        if(!(user.getPassword().equals( verify) && (!errors.hasErrors())) ) {
            model.addAttribute("error", "There's a problem: "+user.getPassword() +":"+ verify);

            return "user/add";

        }
        model.addAttribute("message", "Hi, "
                + user.getUsername() +"!");
        return "user/index";
    }
}
