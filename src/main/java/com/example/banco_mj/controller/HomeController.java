package com.example.banco_mj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){

        return "home";
    }

    @PostMapping("/home")
    public String home_(Model model){

        return "home";
    }

}
