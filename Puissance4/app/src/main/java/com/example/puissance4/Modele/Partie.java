package com.example.puissance4.Modele;

import java.util.Arrays;

public class Partie {

    private Grille grille;
    private Joueur[] joueurs;
    Joueur joueurCourant;
    boolean partieFinie;
    Joueur gagnant;
    boolean parAbandon;

    public  Partie(){
        this.grille = new Grille();
        this.joueurs = new Joueur[2];
        this.joueurs[0]=new Joueur(Couleur.JAUNE);
        this.joueurs[1]=new Joueur(Couleur.ROUGE);
        joueurCourant = new Joueur();
        this.joueurCourant=this.joueurs[(int)Math.random() * 2];
        this.partieFinie=false;
        this.parAbandon=false;
        this.gagnant = null;



    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Joueur[] joueurs) {
        this.joueurs = joueurs;
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public boolean isPartieFinie() {
        return partieFinie;
    }

    public void setPartieFinie(boolean partieFinie) {
        this.partieFinie = partieFinie;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    public void setGagnant(Joueur gagnant) {
        this.gagnant = gagnant;
    }

    public boolean isParAbandon() {
        return parAbandon;
    }

    public void setParAbandon(boolean parAbandon) {
        this.parAbandon = parAbandon;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "grille=" + grille +
                ", joueurs=" + Arrays.toString(joueurs) +
                ", joueurCourant=" + joueurCourant +
                ", partieFinie=" + partieFinie +
                ", gagnant=" + gagnant +
                ", parAbandon=" + parAbandon +
                '}';
    }


}
