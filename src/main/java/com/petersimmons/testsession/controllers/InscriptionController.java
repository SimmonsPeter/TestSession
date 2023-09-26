package com.petersimmons.testsession.controllers;

import com.petersimmons.testsession.models.Panier;
import com.petersimmons.testsession.service.Lab04DataContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InscriptionController {

    private Lab04DataContext dataContext= new Lab04DataContext();
    private Panier getPanier(HttpSession session){
        Panier panier = (Panier) session.getAttribute("panier");
        if(panier == null){
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }

    @GetMapping("/inscription/afficher")
    public ModelAndView afficher(HttpSession session){
        ModelAndView mv = new ModelAndView("AfficherPanier");

        mv.addObject("panier",this.getPanier(session));
        return mv;
    }
    @GetMapping("/inscription/supprimer")
    public String supprimer(@RequestParam("id")int id, HttpSession session){
        Panier panier = getPanier(session);
        panier.supprimerCours(id);
        session.setAttribute("panier",panier);
        return "redirect:/inscription/afficher";
    }

    @GetMapping("/inscription/valider")
    public ModelAndView valider(HttpSession session){
        ModelAndView mv = new ModelAndView("ValiderEtudiant");
        mv.addObject("listeEtudiants",dataContext.get);


        return mv;
    }

}
