package com.petersimmons.testsession.controllers;

import com.petersimmons.testsession.models.Inscription;
import com.petersimmons.testsession.models.Panier;
import com.petersimmons.testsession.service.Lab04DataContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.petersimmons.testsession.models.Etudiant;

import java.time.LocalDate;

@Controller
public class InscriptionController {

    private Lab04DataContext dataContext = new Lab04DataContext();

    private Panier getPanier(HttpSession session) {
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }

    @GetMapping("/inscription/afficher")
    public ModelAndView afficher(HttpSession session) {
        ModelAndView mv = new ModelAndView("afficherPanier");

        mv.addObject("panier", this.getPanier(session));
        return mv;
    }

    @GetMapping("/inscription/supprimer")
    public String supprimer(@RequestParam("id") int id, HttpSession session) {
        Panier panier = getPanier(session);
        panier.supprimerCours(id);
        session.setAttribute("panier", panier);
        return "redirect:/inscription/afficher";
    }

    @GetMapping("/inscription/valider")
    public ModelAndView valider(HttpSession session) {
        ModelAndView mv = new ModelAndView("validerEtudiant");
        mv.addObject("listeEtudiants", dataContext.getListeEtudiants());

        return mv;
    }

    @GetMapping("/inscription/confirmer")
    public ModelAndView confirmer(@RequestParam("nas") String nas, HttpSession session) {


        Etudiant selectedEtudiant = dataContext.getEtudiant(nas);
        ModelAndView mv = new ModelAndView("confirmation");

        if (selectedEtudiant != null) {
            Inscription newInscription = new Inscription();
            newInscription.setNas(nas);

            Panier panier = getPanier(session);
            mv.addObject("panier",panier);
            newInscription.setCours(panier.getListe());

            newInscription.setDate(LocalDate.now());

            dataContext.inscrire(newInscription);



            mv.addObject("confirmationMessage", "Inscription confirmé pour l'étudiant: " + nas);
        } else {
            mv.addObject("errorMessage", "L'étudiant avec le NAS: " + nas + " n'a pu être trouvé");
        }

        return mv;
    }


}
