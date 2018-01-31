package com.example.demo.controllers;

import com.example.demo.models.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    ////////////////////DRUGI SPOSÓB ///////////////////////////

    @GetMapping("/loginTwo")
    public String loginTwo(Model model){
        LoginForm loginForm = new LoginForm();
        loginForm.setLogin("hehehe!");

        model.addAttribute("loginForm", loginForm);
        return "loginTemplateModel";
    }


    @PostMapping("/loginTwo")
    @ResponseBody
    public String loginPostTwo(@ModelAttribute LoginForm loginForm){
        if(loginForm.getLogin().equals("admin") && loginForm.getPassword().equals("admin")){
            return "Zalogowano!";
        }
        return "Błędne dane!";
    }

    @GetMapping("/sendMeName/{name}/{lastname}")
    @ResponseBody
    public String sendMeName(@PathVariable("name") String name,
                             @PathVariable("lastname") String lastname){
        return "Twoje imie to: " + name + " " + lastname;
    }
}
