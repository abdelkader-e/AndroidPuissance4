package com.example.puissance4.Modele;

import java.util.Objects;

/**
 * @author Abdelkader
 * @version 1.0
 * Cette classe permet de definir la position du jeton.
 */

public class Position {

    private int ligne;
    private int colonne;

    public Position(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    @Override
    public String toString() {
        return "Position{" +
                "ligne=" + ligne +
                ", colonne=" + colonne +
                '}';
    }


    public boolean equals(Position position) {

        return this.ligne == position.ligne &&
                colonne == position.colonne;
    }

}
