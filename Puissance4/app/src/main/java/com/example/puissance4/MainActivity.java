package com.example.puissance4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.puissance4.Modele.Couleur;
import com.example.puissance4.Modele.Grille;
import com.example.puissance4.Modele.Jeton;
import com.example.puissance4.Modele.Partie;
import com.example.puissance4.Modele.Position;
import com.example.puissance4.Modele.Puissance4;
import com.example.puissance4.adaptateur.AdapterGrid;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private GridView gv;
    private int plateau[];
    Grille g;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btnGiveUp;
    private Puissance4 ps4;
    TextView txtJoueur;
    Button btnRejouer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ps4 = new Puissance4(new Partie());

        this.btn0 = findViewById(R.id.btn0);
        this.btn1 = findViewById(R.id.btn1);
        this.btn2 = findViewById(R.id.btn2);
        this.btn3 = findViewById(R.id.btn3);
        this.btn4 = findViewById(R.id.btn4);
        this.btn5 = findViewById(R.id.btn5);
        this.btn6 = findViewById(R.id.btn6);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);


        init();

       }
    private void init(){
        this.ps4 = new Puissance4(new Partie());
        this.gv = findViewById(R.id.gv);
        this.plateau = new int[42];
        this.gv.setOnItemClickListener(this);
        this.txtJoueur = findViewById(R.id.TxtJoueurMain);
        this.btnGiveUp=findViewById(R.id.BtnAbandonner);
        this.btnRejouer=findViewById(R.id.btnRejoueur);
        btnGiveUp.setOnClickListener(this);



        btnRejouer.setOnClickListener(this);


        this.txtJoueur.setText("Jouer  : " + this.ps4.getPartie().getJoueurCourant().getNom());


    afficherPlateauJeton();
    }

    public void afficherPlateauJeton() {
        int k = 0;
        if (this.ps4.getPartie().isPartieFinie()) {
            this.txtJoueur.setText("partie finie et le gagnant est  : " +
                    this.ps4.getPartie().getGagnant().getNom());
        } else {
            this.txtJoueur.setText("Au tour du Joueur : " +
                    this.ps4.getPartie().getJoueurCourant().getNom() + " de jouer");
        }


        for (int i = 0; i < this.ps4.getPartie().getGrille().getPlateauJeton().length; i++) {
            for (int j = 0; j < this.ps4.getPartie().getGrille().getPlateauJeton()[i].length; j++) {
                if (this.ps4.getPartie().getGrille().getPlateauJeton()[i][j] == null) {
                    this.plateau[k] = R.drawable.jeton_blanc;
                    Log.i("test", "" + i);
                    k++;

                } else if (this.ps4.getPartie().getGrille().getPlateauJeton()[i][j].getCouleur() == Couleur.JAUNE) {
                    this.plateau[k] = R.drawable.jeton_jaune;

                    k++;
                } else if (this.ps4.getPartie().getGrille().getPlateauJeton()[i][j].getCouleur() == Couleur.ROUGE) {
                    this.plateau[k] = R.drawable.jeton_rouge;
                    k++;
                }
            }

        }
        this.gv.setAdapter(new AdapterGrid(getApplicationContext(), this.plateau));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                this.ps4.jouer(0);
                afficherPlateauJeton();
                break;
            case R.id.btn1:
                this.ps4.jouer(1);
                afficherPlateauJeton();
                break;
            case R.id.btn2:
                this.ps4.jouer(2);
                afficherPlateauJeton();
                break;
            case R.id.btn3:
                this.ps4.jouer(3);
                afficherPlateauJeton();
                break;
            case R.id.btn4:

                this.ps4.jouer(4);
                afficherPlateauJeton();
                break;
            case R.id.btn5:
                this.ps4.jouer(5);
                afficherPlateauJeton();
                break;
            case R.id.btn6:
                this.ps4.jouer(6);
                afficherPlateauJeton();
                break;
            case R.id.btnRejoueur:
                Log.i("zx","rejouer");

                this.ps4.getPartie().setPartieFinie(false);
                init();
                break;
            case R.id.BtnAbandonner:
                this.ps4.abandonner();
                afficherPlateauJeton();
                break;


            default:


        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("bb", "" + position);

        switch (position % 7) {
            case 0:
                this.ps4.jouer(0);
                afficherPlateauJeton();
                break;
            case 1:
                this.ps4.jouer(1);
                afficherPlateauJeton();
                break;
            case 2:
                this.ps4.jouer(2);
                afficherPlateauJeton();
                break;
            case 3:
                this.ps4.jouer(3);
                afficherPlateauJeton();
                break;
            case 4:
                this.ps4.jouer(4);
                afficherPlateauJeton();
                break;
            case 5:
                this.ps4.jouer(5);
                afficherPlateauJeton();
                break;
            case 6:
                this.ps4.jouer(6);
                afficherPlateauJeton();
                break;
        }
    }
}
