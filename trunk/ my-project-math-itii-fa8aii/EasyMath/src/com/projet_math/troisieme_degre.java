package com.projet_math;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class troisieme_degre extends Activity {
    /** Called when the activity is first created. */
	
	EditText x3;
	EditText x2;
	EditText x1;
	EditText x0;
	EditText constante;
	Button btnresoudre;
	TextView solution;
	
	
	double delta;
	double a,b,c,d,e;
	double sol1,sol2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.troisieme_degre);
        x3=(EditText)findViewById(R.id.eTx3);
        x2=(EditText)findViewById(R.id.eTx2);
        x1=(EditText)findViewById(R.id.eTx1);
        x0=(EditText)findViewById(R.id.eTx0);
        constante=(EditText)findViewById(R.id.eTconstante);
        btnresoudre=(Button)findViewById(R.id.btnresolution);
        solution=(TextView)findViewById(R.id.tVsolution1);
        
        
        btnresoudre.setOnClickListener(new View.OnClickListener() {
       	public void onClick(View v) {
       		if((x3.getText().length()!=0) && (x2.getText().length()!=0) && (x1.getText().length()!=0) && (x0.getText().length()!=0) && (constante.getText().length()!=0))	
       		{
      
       			resolution();	
       		}
       			else Toast.makeText(troisieme_degre.this, "Un des champs n'a pas �t� rempli", Toast.LENGTH_LONG).show();
    	}
    });
    }
    
    
    private void resolution()
    {
    	solution.setText("");
    	
    	
    	double p,k,q,gDelta,m,n,u,v,x,y,re,im,theta,z,sol;
    	
    	    
    	    a=Double.valueOf(x3.getText().toString());
    	    b=Double.valueOf(x2.getText().toString());
    	    c=Double.valueOf(x1.getText().toString());
    	    d=Double.valueOf(x0.getText().toString());
    	    e=Double.valueOf(constante.getText().toString());
    	    d=d-e;
    	    
    	    
    	    if(a==0)
    	    {
    	    	 if((b==0) && (c!=0))
    	    	    {
    	    	    sol=-d/c;
    	    	    solution.setText("L'unique solution est : "+String.valueOf(sol));
    	    	    	
    	    	    }
    	    	    else if((b==0) && (c==0)) solution.setText("Impossible");
    	    	    
    	    	    else{	
    	    	    delta =(c*c)-4*(b*d);
    	    	    
    	    	    
    	    		    if(delta==0)
    	    			    {
    	    			    sol1=(-c)/(2*b);
    	    			   	solution.setText("La seule solution est " + String.valueOf(sol1));
    	    			    }
    	    	    	if(delta>0)
    	    		    	{
    	    		    	sol1= (-c+(Math.sqrt((double)(delta/(2*b)))));	
    	    		    	sol2= (-c-(Math.sqrt((double)(delta/(2*b)))));
    	    		    	solution.setText("La premi�re solution est "+ String.valueOf(sol1)+"\n"+"La seconde solution est " + String.valueOf(sol2));
    	    		    	
    	    		    	}
    	    	    	else
    	    	    		{
    	    	    		sol1=(-c+(Math.sqrt((double)(delta/(2*b)))));	
    	    	        	sol2=(-c-(Math.sqrt((double)(delta/(2*b)))));
    	    	        	solution.setText("La premi�re solution est "+ String.valueOf(sol1)+"i"+"\n"+"La seconde solution est " + String.valueOf(sol2)+"i");
    	    	        
    	    	    		}
    	    	   
    	    	    }
    	    }	
    	    else 
    	    {	
    	    p=(c/a)-(Math.pow(b, 2.0)/(3*Math.pow(a, 2.0)));
			q= (((2*Math.pow(b, 3.0))/(27*Math.pow(a, 3.0)))-((b*c)/(3*Math.pow(a, 2.0)))+(d/a));
			gDelta= 4*Math.pow(p, 3.0)+27*Math.pow(q, 2.0);
     		m= ((-q)/2)+(0.5)*Math.sqrt(gDelta/27);
     		n= ((-q)/2)-(0.5)*Math.sqrt(gDelta/27);
    	    
     		u= Math.pow(Math.abs(m), 1.0/3);
     		v= Math.pow(Math.abs(n), 1.0/3);
     		
    	    Toast.makeText(this, String.valueOf(gDelta), Toast.LENGTH_SHORT).show();
     		if(gDelta>0)
		  		  {
		  			  if (m<0) u=-u;
		  			  if (n<0) v=-v;
		  			  x=u+v;
		  			  x+=(-b)/(3*a);
		  			  re=(-x)/2;
		  			  im=(float) ((Math.sqrt(3)/2)*(u-v));
		  			  re+=(-b)/(3*a);
		  			  //3 solutions
		  			  solution.setText("Il y a une racine r�elle: " +x+"\n"+"Il y a deux racines complexes: \n"+"y = "+re+"-"+im+"i ,\n z  = "+re+"+"+im+"i");
		  			  
		  			 	  
		  		  }
     		else if(gDelta==0)
						{
						  
						  if(b==0 && c==0 && d==0)
							  solution.setText("Il y a une racine r�elle de multiplicit� 3 :x = y = z = 0");
						  else
							  {
								x=(3*q)/p;
								x+=(-b)/(3*a);
								y=(-3*q)/(2*p);
								y+=(-b)/(3*a);
								solution.setText("Il y a une racine r�elle simple:"+" "+x+"\n"+"Il y a une racine r�elle double y = z="+" "+y);
								
							  }
							
						}
     		else
  		    {
  			  k = ((3*q)/((2*p)*Math.sqrt((-p)/3)));               
  			  theta = Math.acos(k);
  			  x =  (2*Math.sqrt((-p)/3)*Math.cos(theta/3));
  			  y =  (2*Math.sqrt((-p)/3)*Math.cos((theta+2*Math.PI)/3));
  			  z =  (2*Math.sqrt((-p)/3)*Math.cos((theta+4*Math.PI)/3));
 
  			  x+=(-c)/(3*b);
  			  y+=(-c)/(3*b);
  			  z+=(-c)/(3*b);
  			  solution.setText("Il y a 3 racines r�elles "+x+" \n"+" "+ y +"\n" +z);
  			
  			   
  		  }
    	}		
    }
}