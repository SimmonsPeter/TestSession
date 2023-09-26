package com.petersimmons.testsession.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompteurController {

    @RequestMapping("/session/afficher")
    public ModelAndView compter(HttpSession session){

        ModelAndView mv = new ModelAndView("affichesession");
        int cpt = 1;

        if(session.getAttribute("compteur") != null){
            //recuperer le cpt de la session
            cpt=(int)session.getAttribute("compteur");
            //incrementer le cpt
            cpt++;

        }
        //sauvegarder le nouveau cpt dans la session
        session.setAttribute("compteur",cpt);
        mv.addObject("compteur",cpt);

        return mv;
    }
}
