package com.petersimmons.testsession.models;

import java.util.List;

public class Panier {



    private List<Cours> liste;
    public List<Cours> getListe() {
        return liste;
    }

    public void ajouterCours(Cours cours){
        liste.add(cours);
    }
    public void supprimerCours(int id){
        liste.removeIf(cours-> cours.getId()== id);
    }
    public void viderPanier(){
        liste.clear();
    }
}
