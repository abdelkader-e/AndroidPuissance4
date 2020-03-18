package com.example.puissance4.Modele;

public class Puissance4 {

    private Partie partie;

    public Puissance4(Partie partie) {
        this.partie = partie;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    @Override
    public String toString() {
        return "Puissance4{" +
                "partie=" + partie +
                '}';
    }

    public boolean gameIsOver() {
        return this.partie.isPartieFinie();
    }

    public void jouer(int numColone) {
        if (!this.gameIsOver()) {

            Jeton jeton = new Jeton(this.partie.getJoueurCourant().getNom());
            int ligne = this.partie.getGrille().insererJeton(jeton, numColone);

            Position pos = new Position(ligne, numColone);

            if (this.partie.getGrille().alignementRealise(pos)){
                this.partie.setPartieFinie(true);
                this.partie.setGagnant(this.partie.getJoueurCourant());

             }

            if (this.partie.getGrille().isFullGrille()){
                this.partie.setPartieFinie(true);
                }

            if(this.partie.getJoueurCourant()==this.partie.getJoueurs()[0]){
                this.partie.setJoueurCourant(this.partie.getJoueurs()[1]);
            }else{
                this.partie.setJoueurCourant(this.partie.getJoueurs()[0]);
            }


            }


        }
    public void abandonner(){
        this.getPartie().setParAbandon(true);
        this.getPartie().setPartieFinie(true);
        if(this.getPartie().getJoueurCourant().getNom()==Couleur.JAUNE){
            this.getPartie().setGagnant(new Joueur(Couleur.ROUGE));
        }else{
            this.getPartie().setGagnant(new Joueur(Couleur.JAUNE));
        }
    }
        }


