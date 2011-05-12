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

public class menu_cours extends Activity implements OnItemClickListener
{
	private ListView maListViewPerso;
	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        //Récupération de la listview créée dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
 
        //Création de la ArrayList qui nous permettra de remplir la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
 
        //Création d'une HashMap pour insérer les informations du premier item de notre listView
        map = new HashMap<String, String>();
        //on insère un élément titre que l'on récupérera dans le textView titre créé dans le fichier affichageitem.xml
        map.put("titre", "Probabilit�");
        //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier affichageitem.xml
        map.put("description", "Cours sur les probabilit�s");
        //on insère la référence à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier affichageitem.xml
        map.put("img", String.valueOf(R.drawable.probabilite));
        //enfin on ajoute cette hashMap dans la arrayList
        listItem.add(map);
 
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
 
        map = new HashMap<String, String>();
        map.put("titre", "Matrice");
        map.put("description", "Cours sur les matrices");
        map.put("img", String.valueOf(R.drawable.matrice));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Suites");
        map.put("description", "Cours sur les suites arithm�tiques, g�om�triques ...");
        map.put("img", String.valueOf(R.drawable.suite));
        listItem.add(map);
       
 
       
        
 //génération de la listview avec les différents items créer 
        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitem,
               new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
 
        //On attribut à notre listView l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(mSchedule);
 
        //Enfin on met un écouteur d'évènement sur notre listView
        maListViewPerso.setOnItemClickListener(this);
			
       
         	
        		
    }
    
        public void onItemClick(AdapterView<?> a, View v, int position, long id)
    	{
			//on récupère la HashMap contenant les infos de notre item (titre, description, img)
    		HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
    		
    		
    		//selon le titre contenu dans le HashMap on lance l'intent en rapport
    		//Intent intent=null;
    		if(map.get("titre").equals("Suites"))
    			{
    			Bundle urlToOpen = new Bundle();
    			
    			urlToOpen.putString("url","https://docs.google.com/document/d/1_u9f6mCX6NX2chtPJKF2sqgnKPPboAN77R7w-zX9uCU/edit?hl=en&authkey=COPeufQN");
    			
    	       Intent intent = new Intent(this,navigator.class);
    	       intent.putExtras(urlToOpen);
    	     	startActivity(intent);
    	     	
    	     	}
    		
    		if(map.get("titre").equals("Matrice"))
				{
    			Toast.makeText(menu_cours.this,map.get("titre"+ "Pas encore développé"), Toast.LENGTH_LONG).show();
    			
				}
    		if(map.get("titre").equals("Probabilité"))
    			{
    			Toast.makeText(this, "Pas encore développé", Toast.LENGTH_LONG).show();
    			}
    		
    		
    	}
}