package com.projet_math;
 
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class outils_math extends Activity implements OnItemClickListener {
 
	private ListView maListViewPerso;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        //R�cup�ration de la listview cr��e dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
 
        //Cr�ation de la ArrayList qui nous permettra de remplir la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On d�clare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
 
        //Cr�ation d'une HashMap pour ins�rer les informations du premier item de notre listView
        map = new HashMap<String, String>();
        //on ins�re un �l�ment titre que l'on r�cup�rera dans le textView titre cr�� dans le fichier affichageitem.xml
        map.put("titre", "Calculatrice");
        //on ins�re un �l�ment description que l'on r�cup�rera dans le textView description cr�� dans le fichier affichageitem.xml
        map.put("description", "Calculatrice");
        //on ins�re la r�f�rence � l'image (convertit en String car normalement c'est un int) que l'on r�cup�rera dans l'imageView cr�� dans le fichier affichageitem.xml
        map.put("img", String.valueOf(R.drawable.calculatrice));
        //enfin on ajoute cette hashMap dans la arrayList
        listItem.add(map);
 
        //On refait la manip plusieurs fois avec des donn�es diff�rentes pour former les items de notre ListView
 
        map = new HashMap<String, String>();
        map.put("titre", "Equation");
        map.put("description", "R�solveur d'�quation du second et troisi�me degr�");
        map.put("img", String.valueOf(R.drawable.equation));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Variable al�atoire");
        map.put("description", "Variable al�atoire d'une s�rie statistique");
        map.put("img", String.valueOf(R.drawable.variable));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Statistique");
        map.put("description", "Calcul de moyenne,�cart type, mode et m�diane");
        map.put("img", String.valueOf(R.drawable.statistique));
        listItem.add(map);
        
        map = new HashMap<String, String>();
        map.put("titre", "Probabilit�");
        map.put("description", "Loi de probabilit�: loi Uniforme, loi Binomiale, loi de Poisson, loi Normal, et test de KHI");
        map.put("img", String.valueOf(R.drawable.probabilite));
        listItem.add(map);
        
 //g�n�ration de la listview avec les diff�rents items cr�er 
        //Cr�ation d'un SimpleAdapter qui se chargera de mettre les items pr�sent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitem,
               new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
 
        //On attribut � notre listView l'adapter que l'on vient de cr�er
        maListViewPerso.setAdapter(mSchedule);
 
        //Enfin on met un �couteur d'�v�nement sur notre listView
        maListViewPerso.setOnItemClickListener(this);
			
        	
         	
        		
    }
    
        public void onItemClick(AdapterView<?> a, View v, int position, long id)
    	{
			//on r�cup�re la HashMap contenant les infos de notre item (titre, description, img)
    		HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
    		
    		
    		//selon le titre contenu dans le HashMap on lance l'intent en rapport
    		Intent intent=null;
    		if(map.get("titre").equals("Calculatrice"))
    			{
    			intent= new Intent(outils_math.this,calculatrice.class);
    			startActivity(intent);
    			}
    		
    		if(map.get("titre").equals("Statistique"))
				{
    			//Toast.makeText(outils_math.this,map.get("titre"), Toast.LENGTH_LONG).show();
    			intent=new Intent(outils_math.this,statistique.class);
    			startActivity(intent);
				}
    		
    		if(map.get("titre").equals("Equation"))
				{
				intent= new Intent(outils_math.this,equation.class);
				startActivity(intent);
				}
    		
    		if(map.get("titre").equals("Variable al�atoire"))
				{
    			
    			Toast.makeText(outils_math.this,map.get("titre"), Toast.LENGTH_LONG).show();
				}
    		
    		if(map.get("titre").equals("Probabilit�"))
				{
    			Toast.makeText(outils_math.this,map.get("titre"), Toast.LENGTH_LONG).show();
				}
    		
    		
    		
    	}	
}