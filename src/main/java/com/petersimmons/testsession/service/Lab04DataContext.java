package com.petersimmons.testsession.service;

import com.petersimmons.testsession.models.Cours;
import com.petersimmons.testsession.models.Etudiant;
import com.petersimmons.testsession.models.Inscription;

import java.util.ArrayList;
import java.util.List;

public class Lab04DataContext {

    private List<Cours> listeCours =  new ArrayList<>();



    private List<Etudiant> listeEtudiants = new ArrayList<>();
    private List<Inscription> listeInscriptions= new ArrayList<>();

    public Lab04DataContext(){
        listeCours.add(new Cours("Math 101", 3, 1, "math101_syllabus.pdf"));
        listeCours.add(new Cours("Physique 101", 4, 2, "physics101_syllabus.pdf"));
        listeCours.add(new Cours("Chimie 101", 3, 1, "chemistry101_syllabus.pdf"));

        listeEtudiants.add(new Etudiant("123-45-6789", "John", "Doe", "555-5555", "123 Main St", "A1B 2C3", "john.doe@email.com", 'M'));
        listeEtudiants.add(new Etudiant("987-65-4321", "Jane", "Doe", "555-5556", "124 Main St", "A1B 2C4", "jane.doe@email.com", 'F'));
        listeEtudiants.add(new Etudiant("111-22-3333", "Sam", "Smith", "555-5557", "125 Main St", "A1B 2C5", "sam.smith@email.com", 'M'));
    }

    public void inscrire(Inscription inscription){
        listeInscriptions.add(inscription);
    }

    public Cours getCours(int id){
        return listeCours.stream().filter(cours->cours.getId()==id).findFirst().orElse(null);
    }

    public List<Cours> getListeCours() {
        return listeCours;
    }

    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }
    public Etudiant getEtudiant(String nas){
        return listeEtudiants.stream().filter(etudiant->etudiant.getNas().equals(nas)).findFirst().orElse(null);
    }
}
