package com.petersimmons.testsession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root(){
        return "redirect:/accueil";
    }

    @GetMapping("/accueil")
    public String accueil(){
        return "Accueil";
    }

}
