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
        map.put("description", "Probabilit� conditionnelle, variable al�atoire, lois discr�tes, loi continue.");
        //on insère la référence à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier affichageitem.xml
        map.put("img", String.valueOf(R.drawable.probabilite));
        //enfin on ajoute cette hashMap dans la arrayList
        listItem.add(map);
 
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
 
        map = new HashMap<String, String>();
        map.put("titre", "Produit scalaire dans l�espace");
        map.put("description", "Carr� scalaire, orthogonalit�, vecteur normal � un plan, �quation cart�sienne.");
        map.put("img", String.valueOf(R.drawable.scalaire));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Suites");
        map.put("description", "Comportement globale d'une suite, op�rations et comparaisons, suites g�om�triques, arithm�tiques, principe de r�currence.");
        map.put("img", String.valueOf(R.drawable.suite));
        listItem.add(map);
       
        map= new HashMap<String,String>();
        map.put("titre", "Complexe");
        map.put("description", "Module , argument, diff�rnetes �critures d'un nombre complexe, g�om�trie et transformations g�om�triques.");
        map.put("img", String.valueOf(R.drawable.complex));
        listItem.add(map);
        
        map= new HashMap<String,String>();
        map.put("titre", "Primitives et int�grales");
        map.put("description", "Primitives , int�grales, in�galit�s, int�gration par partie.");
        map.put("img", String.valueOf(R.drawable.integral));
        listItem.add(map);
        
        map= new HashMap<String,String>();
        map.put("titre", "D�nombrement");
        map.put("description", "Listes, arrangement, permutation, combinaisons, bin�me de Newton, principe fondamental du d�nombrement.");
        map.put("img", String.valueOf(R.drawable.denombrement));
        listItem.add(map);
        
        map= new HashMap<String,String>();
        map.put("titre", "Droites et plans dans l'espace");
        map.put("description", "Barycentre, droites de l'espace, intersection et �quations lin�aires.");
       map.put("img", String.valueOf(R.drawable.droites));
        listItem.add(map);		
       
        map= new HashMap<String,String>();
        map.put("titre", "Exponentielles, logarithmes, puissances");
        map.put("description", "Fonctions exponentielle, logarythme, puissance, courbes repr�sentatives, fonctions de bases associ�es.");
        map.put("img", String.valueOf(R.drawable.logarythme));
        listItem.add(map);		
       
        map= new HashMap<String,String>();
        map.put("titre", "Les fonctions");
        map.put("description", "Limites , comportement asymptotique, d�rivation, continuit�.");
        map.put("img", String.valueOf(R.drawable.fonction));
        listItem.add(map);
        
        
         //g�n�ration de la listview avec les diff�rents items cr�er 
        //Cr�ation d'un SimpleAdapter qui se chargera de mettre les items pr�sent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitem,
               new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
 
        //On attribut @ notre listView l'adapter que l'on vient de cr�er
        maListViewPerso.setAdapter(mSchedule);
 
        //Enfin on met un �couteur d'�v�nement sur notre listView
        maListViewPerso.setOnItemClickListener(this);
			
       
         	
        		
    }
    
        public void onItemClick(AdapterView<?> a, View v, int position, long id)
    	{
			//on récupère la HashMap contenant les infos de notre item (titre, description, img)
    		HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
    		
    		
    		//selon le titre contenu dans le HashMap on lance l'intent en rapport
    		//Intent intent=null;
    		if(map.get("titre").equals("Exponentielles, logarithmes, puissances"))
    			{
    			openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypZTdiZDA5MTYtNThkMS00NThiLWI5M2YtNjBiYTIxMDYxNzhi&hl=en&authkey=CMH2x-4K");
    	        }
    		
    		if(map.get("titre").equals("D�nombrement"))
				{
    			openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypZDVjZDJiYzAtNWU2ZS00YzcwLTkwZjgtNGVjOWE1YjVhZWFk&hl=en&authkey=CJfR0KcP");
    	        }
    		
    		if(map.get("titre").equals("Probabilit�"))
    			{
    			openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypNjZmYWYzNTctMzBmNC00ZjcwLTk0N2YtMGVhOTA1YTI1ODFj&hl=en&authkey=CKnj4ZIE");
    			}
    		
    		if(map.get("titre").equals("Complexe"))
    			{
    			openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypYmNjOTZmNDItMmZmNS00MTA5LWJjMWQtZDY4ZDFmMmI4ZjQ3&hl=en&authkey=CKbz644G");
    			}
    		
    		if(map.get("titre").equals("Primitives et int�grales"))
				{
    			openUrl( "https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypZWY2MjZlZGMtYzEzOC00Zjk5LWFlYzAtMTI0NmIxNTMyMGFh&hl=en&authkey=CPP3lPIK");
    			}
    		
    		if(map.get("titre").equals("Suites"))
				{
    			openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypMWNiNjkwMjctYTNhYi00ZDc4LWFlM2UtMGYyZjY5NTdmODlm&hl=en&authkey=CIKakssE");
				}
    		
    		if(map.get("titre").equals("Produit scalaire dans l�espace"))
				{
				openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypMGIyNGEwZjctMDAyOS00ZmUyLTg2MTYtYTliODYyODAwZjMz&hl=en&authkey=CK6pnZQI");
				}
    		
    		if(map.get("titre").equals("Les fonctions"))
				{
    			openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypYjMzMTIwODktZWVkYy00OTcyLWFmZTItMGRkNzFmZDg0M2Zj&hl=en&authkey=CLit-EE");
			    }
    		
    		if(map.get("titre").equals("Droites et plans dans l'espace"))
				{	
    			openUrl("https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B52lTSusrwypZmU1ZjMzZjctNzhhNi00MmQ2LWI1NmItMWU3OWUwNzA0OTYw&hl=en&authkey=CIOgh4oN");
				}
    		
    		
    	}
 
        //fonction permettant de cr�er un bundle pour passer une url en extra � un intent vers l'activit� navigator
public void openUrl(String url)
	{
	Bundle urlToOpen = new Bundle();
	urlToOpen.putString("url", url);
	Intent intent = new Intent (this, navigator.class);
	intent.putExtras(urlToOpen);
	startActivity(intent);
	}
}
