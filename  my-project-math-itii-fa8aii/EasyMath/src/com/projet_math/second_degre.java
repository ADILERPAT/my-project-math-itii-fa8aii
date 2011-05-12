package com.projet_math;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class second_degre extends Activity
{
	EditText x2;
	EditText x1;
	EditText x0;
	EditText constante;
	Button btnresoudre;
	TextView solution;
	float delta;
	float a,b,c,d;
	float sol1,sol2,sol;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_degre);
        
        x2=(EditText)findViewById(R.id.eTx2);
        x1=(EditText)findViewById(R.id.eTx1);
        x0=(EditText)findViewById(R.id.eTx0);
        constante=(EditText)findViewById(R.id.eTconstante);
        btnresoudre=(Button)findViewById(R.id.btnresolution);
        solution=(TextView)findViewById(R.id.tVsolution1);
       
       
       btnresoudre.setOnClickListener(new View.OnClickListener() {
       	public void onClick(View v) {
       		if((x2.getText().length()!=0) && (x1.getText().length()!=0) && (x0.getText().length()!=0) && (constante.getText().length()!=0))	
    		resolution();	
    		else Toast.makeText(second_degre.this, "Un des champs n'a pas �t� rempli", Toast.LENGTH_LONG).show();
    	}
    });
        
        
    }
   private void resolution()
    {
    a=Float.parseFloat(x2.getText().toString());
    b=Float.parseFloat(x1.getText().toString());
    c=Float.parseFloat(x0.getText().toString());
    d=Float.parseFloat(constante.getText().toString());
    
    c=c-d;
    
    if((a==0) && (b!=0))
    {
    sol=-c/b;
    solution.setText("L'unique solution est : "+String.valueOf(sol));
    	
    }
    else if((a==0) && (b==0)) solution.setText("Impossible");
    
    else{	
    delta =(b*b)-4*(a*c);
    
    
	    if(delta==0)
		    {
		    sol1=(-b)/(2*a);
		   	solution.setText("La seule solution est " + String.valueOf(sol1));
		    }
    	if(delta>0)
	    	{
	    	sol1=(float) (-b+(Math.sqrt((double)(delta/(2*a)))));	
	    	sol2=(float) (-b-(Math.sqrt((double)(delta/(2*a)))));
	    	solution.setText("La premi�re solution est "+ String.valueOf(sol1)+"\n"+"La seconde solution est " + String.valueOf(sol2));
	    	
	    	}
    	else
    		{
    		sol1=(float) (-b+(Math.sqrt((double)(delta/(2*a)))));	
        	sol2=(float) (-b-(Math.sqrt((double)(delta/(2*a)))));
        	solution.setText("La premi�re solution est "+ String.valueOf(sol1)+"i"+"\n"+"La seconde solution est " + String.valueOf(sol2)+"i");
        
    		}
   
    }
    }
    
    }
