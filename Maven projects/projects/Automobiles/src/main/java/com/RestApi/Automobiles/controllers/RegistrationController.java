package com.RestApi.Automobiles.controllers;

import com.RestApi.Automobiles.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

     @GetMapping("/register")
        public String registerForm(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }



    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        // You can print or save the user object here
        model.addAttribute("username", user.getUsername());
        return "success";
    }
}
