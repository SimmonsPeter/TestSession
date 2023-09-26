package com.petersimmons.testsession.controllers;

import com.petersimmons.testsession.models.Cours;
import com.petersimmons.testsession.models.Panier;
import com.petersimmons.testsession.service.Lab04DataContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoursController {


    private Lab04DataContext dataContext = new Lab04DataContext();


    private Panier getPanier(HttpSession session){
        Panier panier = (Panier) session.getAttribute("panier");
        if(panier == null){
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }
    @GetMapping("/cours/liste")
    public ModelAndView liste(){
        ModelAndView mv = new ModelAndView("listeCours");
        mv.addObject("ListeCours",dataContext.getListeCours());
        return mv;
    }

    @GetMapping("/cours/ajouter")
    public String ajouter(@RequestParam("id") int id,HttpSession session) {
        Panier panier = getPanier(session);
        Cours coursToAdd = dataContext.getCours(id);
        if (coursToAdd != null) {
            panier.ajouterCours(coursToAdd);
        }
        session.setAttribute("panier",panier);
        return "redirect:/cours/liste";
    }



}
