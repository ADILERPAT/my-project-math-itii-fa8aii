package com.projet_math;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calculatrice extends Activity {
	//On d�clare toutes les variables dont on aura besoin
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button buttonPlus;
	Button buttonMoins;
	Button buttonDiv;
	Button buttonMul;
	Button buttonC;
	Button buttonEgal;
	Button buttonPoint;
	Button buttonBack;
	EditText ecran;
 
	private double chiffre1;
	private boolean clicOperateur = false;
	private boolean update = false;
	private String operateur = "";
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatrice);
 
        //On r�cup�re tout les �l�ments de notre interface graphique gr�ce aux ID
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMoins = (Button) findViewById(R.id.buttonMoins);
        buttonDiv = (Button) findViewById(R.id.buttonDivision);
        buttonMul = (Button) findViewById(R.id.buttonMultiplier);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        buttonBack = (Button)findViewById(R.id.buttonBack);
 
        ecran = (EditText) findViewById(R.id.EditText01);
 
        //On attribut un �couteur d'�v�nement � tout les boutons
        buttonPlus.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		plusClick();
        	}
        });
 
       buttonBack.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		backClick();
        	}
        });
        
        buttonMoins.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		moinsClick();
        	}
        });
 
        buttonDiv.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		divClick();
        	}
        });
 
        buttonMul.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		mulClick();
        	}
        });
 
        buttonC.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		resetClick();
        	}
        });
 
        buttonEgal.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		egalClick();
        	}
        });
 
        buttonPoint.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick(".");
        	}
        });
 
        button0.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("0");
        	}
        });
 
        button1.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("1");
        	}
        });
 
        button2.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("2");
        	}
        });
 
        button3.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("3");
        	}
        });
 
        button4.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("4");
        	}
        });
 
        button5.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("5");
        	}
        });
 
        button6.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("6");
        	}
        });
 
        button7.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("7");
        	}
        });
 
        button8.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("8");
        	}
        });
 
        button9.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		chiffreClick("9");
        	}
        });
 
    }
 
    //voici la m�thode qui est ex�cut�e lorsque l'on clique sur un bouton chiffre
    public void chiffreClick(String str) {
       
    	if(update){
                update = false;
        }else{
            if(!ecran.getText().equals("0"))
            	str = ecran.getText() + str;
        }
        ecran.setText(str);
    }
 
    //voici la m�thode qui est  ex�cut�e lorsque l'on clique sur le bouton +
    public void plusClick(){
    	if(ecran.getText().length()==0)
        	Toast.makeText(this, "Aucune valeur entr�e", Toast.LENGTH_SHORT).show();
        else{
    	if(clicOperateur){
    		calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }}
 
    //voici la m�thode qui est  ex�cut�e lorsque l'on clique sur le bouton -
    public void moinsClick(){
    	if(ecran.getText().length()==0)
        	Toast.makeText(this, "Aucune valeur entr�e", Toast.LENGTH_SHORT).show();
        else{
    	if(clicOperateur){
    		calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }}
 
    //voici la m�thode qui est  ex�cut�e lorsque l'on clique sur le bouton *
    public void mulClick(){
    	if(ecran.getText().length()==0)
        	Toast.makeText(this, "Aucune valeur entr�e", Toast.LENGTH_SHORT).show();
        else{
    	if(clicOperateur){
    		calcul();
    		ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }}
 
    public void backClick(){
    if(ecran.getText().length()!=0)
    	{
    	if(!update)
    	ecran.setText(ecran.getText().subSequence(0, ecran.getText().length()-1));
    	}
    }
    
    //voici la m�thode qui est  ex�cut�e lorsque l'on clique sur le bouton /
    public void divClick(){
    	if(ecran.getText().length()==0)
        	Toast.makeText(this, "Aucune valeur entr�e", Toast.LENGTH_SHORT).show();
        else{
    	if(clicOperateur){
    		 calcul();
    		 ecran.setText(String.valueOf(chiffre1));
         }else{
        	 chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
        	 clicOperateur = true;
         }
         operateur = "/";
         update = true;
    }}
 
    //voici la m�thode qui est  ex�cut�e lorsque l'on clique sur le bouton =
    public void egalClick(){
    	calcul();
        update = true;
        clicOperateur = false;
    }
 
    //voici la m�thode qui est  ex�cut�e lorsque l'on clique sur le bouton C
    public void resetClick(){
    	 clicOperateur = false;
         update = true;
         chiffre1 = 0;
         operateur = "";
         ecran.setText("");
    }
 
    //Voici la m�thode qui fait le calcul qui a �t� demand� par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
        	chiffre1 = chiffre1 + Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
 
        if(operateur.equals("-")){
        	chiffre1 = chiffre1 - Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
 
        if(operateur.equals("*")){
                chiffre1 = chiffre1 * Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
        }
 
        if(operateur.equals("/")){
        	try{
            	chiffre1 = chiffre1 / Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                ecran.setText("0");
            }
        }
    }
}