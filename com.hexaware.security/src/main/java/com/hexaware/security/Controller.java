package com.hexaware.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/AboutUS")
    public String AboutUS() {
        return "This is About us page. Anyone can access.";
    }

    @GetMapping(value = "/ContacUs")
    public String ContacUs() {
        return "This is Contact us page. Anyone can access.";
    }

    @GetMapping(value = "/SignIn")
    public String SignIn() {
        return "This is SignIn page. Anyone can access.";
    }

    @GetMapping(value = "/SignUp")
    public String SignUp() {
        return "This is SignUp page. Anyone can access.";
    }

    @GetMapping(value = "/addProducts")
    public String addProducts() {
        return "This is addProducts Method. Only admins can access.";
    }

    @GetMapping(value = "/removeProducts")
    public String removeProducts() {
        return "This is removeProducts Method. Only admins can access.";
    }
}
