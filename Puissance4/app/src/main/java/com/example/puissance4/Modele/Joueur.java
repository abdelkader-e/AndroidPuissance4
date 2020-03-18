package com.example.puissance4.Modele;

/**
 * @author Abdelkader
 * @version 1.0
 */

public class Joueur {

    private Couleur nom;

    public Joueur(Couleur nom) {
        this.nom = nom;
    }

    public Couleur getNom() {
        return nom;
    }

    public void setNom(Couleur nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom=" + nom +
                '}';
    }

    public Joueur() {
    }
}
