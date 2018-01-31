package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "loginTemplate";
    }


    @PostMapping("/login")
    @ResponseBody
    public String loginPost(@RequestParam("login") String login,
                            @RequestParam("password") String password){
        if(login.equals("admin") && password.equals("admin")){
            return "Zalogowano!";
        }
        return "Błędne dane!";
    }
}
