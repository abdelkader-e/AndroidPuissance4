package com.example.puissance4.Modele;

/**
 * @author  Abdelkader
 * @version A.0
 * Cette classe permet de créer un jeton.
 */

public class Jeton {

    private Couleur couleur;

    public Jeton(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Jeton{" +
                "couleur=" + couleur +
                '}';
    }
}
