package com.petersimmons.testsession.controllers;

import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/clearSession")
    public String clearSession(HttpSession session) {
        session.invalidate();
        return "redirect:/accueil";
    }

}
