package com.example.puissance4.Modele;

import java.util.Arrays;

/**
 * @author Abdelkader
 * @version 1.0
 */
public class Grille {

    private static final int NB_LIGNE=Config.NB_LIGNES;
    private static final int NB_COLONNE=Config.NB_COLONNES;
    private Jeton[][] plateauJeton;

    public Grille() {

         this.plateauJeton = new Jeton[NB_LIGNE][NB_COLONNE];

    }

    public Jeton getJeton(Position position){
        return this.plateauJeton[position.getLigne()][position.getColonne()];
    }

    public boolean isFullCollones(int numColonne){
        Position pos=new Position(0,numColonne);

        return getJeton(pos) != null;
    }

    public boolean isFullGrille(){
        boolean isFull=true;
        int numColonne=0;
        while (numColonne <NB_COLONNE && isFull){
            if(isFullCollones(numColonne)){
                numColonne++;
            }else{
                isFull=false;
            }
        }return isFull;
    }

    public int insererJeton(Jeton jeton,int numColonne){
        int ligne= -1;
        int i=NB_LIGNE-1;

        while(ligne ==-1){
            Position pos = new Position(i,numColonne);
            if (getJeton(pos)==null){
                this.plateauJeton[i][numColonne]=jeton;
                ligne = i;
            }
            i--;
        }return ligne;
    }

    @Override
    public String toString() {
        String chaine="\n";
        for(int j=0;j<this.plateauJeton[0].length;j++){
            chaine = chaine + " " + j;
        }
        chaine=chaine +"\n";

        for (int i=0;i<this.plateauJeton.length;i++){

                for(int k=0;k<this.plateauJeton[0].length;k++){

    chaine=chaine +"-----";
                }
                chaine=chaine+"\n";


                for(int j=0;j<this.plateauJeton[i].length;j++){

                if(this.plateauJeton[i][j]==null){
                    chaine = chaine +"|  ";

                }else if(this.plateauJeton[i][j].getCouleur() ==Couleur.ROUGE){
                    chaine = chaine +"| R ";
                }else {
                    chaine = chaine +"| J ";
                }
            }
            chaine = chaine+"|";
            chaine = chaine+"\n";
        }


        for(int j=0;j<this.plateauJeton[0].length;j++){
            chaine=chaine+"----";
        }

        return chaine;
    }

    public boolean alignementHorizontale(Position position){
        //initialisation des variables
        int ligne = position.getLigne();
        int colonne = position.getColonne()-1;
        boolean memeCouleur = true;
        int compteur =1;

        Couleur couleur = getJeton(position).getCouleur();

        //parcours à gauche de la position
        while(colonne >=0 && memeCouleur ){//&& compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    colonne--;
                }else{
                    memeCouleur = false;
                }
            }else{
                memeCouleur = false;
            }
        }
        //vérification à droite
        colonne = position.getColonne()+1;
        memeCouleur = true;

        //parcours à gauche de la position
        while(colonne < NB_COLONNE && memeCouleur){ //&&compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    colonne++;
                }else{
                    memeCouleur = false;
                }
            }else {
                memeCouleur = false;
            }
        }
        return compteur>=4;
    }

    public boolean alignementVerticale(Position position){

        //initialisation des variables
        int ligne = position.getLigne()+1;
        int colonne = position.getColonne();
        boolean memeCouleur = true;
        int compteur =1;
        Couleur couleur = getJeton(position).getCouleur();

        //parcours vers le bas
        while(ligne < NB_LIGNE && memeCouleur ){//&& compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    ligne++;
                }else{
                    memeCouleur = false;
                }
            }else{
                memeCouleur = false;
            }
        }
        //parcours vers le haut
        ligne = position.getLigne()-1;
        memeCouleur = true;
        //parcours vers le bas
        while(ligne >=0 && memeCouleur ){//&& compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    ligne--;
                }else{
                    memeCouleur = false;
                }
            }else{
                memeCouleur = false;
            }
        }
        return compteur>=4;

    }

    public boolean alignementDiagGauche(Position position){
        //initialisation des variables
        int ligne = position.getLigne()-1;
        int colonne = position.getColonne()-1;
        boolean memeCouleur = true;
        int compteur =1;
        Couleur couleur = getJeton(position).getCouleur();

        //parcours vers le haut
        while(ligne >=0 && colonne >=0 && memeCouleur ){//&& compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    ligne--;
                    colonne--;
                }else{
                    memeCouleur = false;
                }
            }else{
                memeCouleur = false;
            }
        }
        //parcours vers le bas
        ligne = position.getLigne()+1;
        colonne = position.getColonne()+1;
        memeCouleur = true;
        //parcours vers le bas
        while(ligne <NB_LIGNE && colonne <NB_COLONNE && memeCouleur ){//&& compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    ligne++;
                    colonne++;
                }else{
                    memeCouleur = false;
                }
            }else{
                memeCouleur = false;
            }
        }
        return compteur>=4;
    }

    public boolean alignementDiagDROITE(Position position){
        //initialisation des variables
        int ligne = position.getLigne()-1;
        int colonne = position.getColonne()+1;
        boolean memeCouleur = true;
        int compteur =1;
        Couleur couleur = getJeton(position).getCouleur();

        //parcours vers le haut
        while(ligne >=0 && colonne <NB_COLONNE  && memeCouleur ){//&& compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    ligne--;
                    colonne++;
                }else{
                    memeCouleur = false;
                }
            }else{
                memeCouleur = false;
            }
        }
        //parcours vers le bas
        ligne = position.getLigne()+1;
        colonne = position.getColonne()-1;
        memeCouleur = true;
        //parcours vers le bas
        while(ligne <NB_LIGNE && colonne >=0 && memeCouleur ){//&& compteur <4){
            Position pos = new Position(ligne,colonne);
            if(getJeton(pos)!=null){
                if(couleur==getJeton(pos).getCouleur()){
                    compteur++;
                    ligne++;
                    colonne--;
                }else{
                    memeCouleur = false;
                }
            }else{
                memeCouleur = false;
            }
        }
        return compteur>=4;

    }

    public boolean alignementRealise(Position position){
        return  alignementDiagGauche(position)||
                alignementDiagDROITE(position)||
                alignementVerticale(position) ||
                alignementHorizontale(position);
    }

    public Jeton[][] getPlateauJeton() {
        return plateauJeton;
    }

    public void setPlateauJeton(Jeton[][] plateauJeton) {
        this.plateauJeton = plateauJeton;
    }
}

