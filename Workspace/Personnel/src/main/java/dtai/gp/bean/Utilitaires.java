/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtai.gp.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author lndiaye
 */
public class Utilitaires {
    
    /**
     * mehode qui formate une chaine de caractére en ajoutant 
     * des espaces en fonction de la taille voulu et donné en argument
     * @param chaine
     * @param taille
     * @return String
     */
    public static String formater(String chaine,int taille){    
      
    if (chaine.length()<taille){
        int j=chaine.length()+1;
        while(j<taille){
            String str=" ";
            chaine=chaine.concat(str);
            j++;
        }       
    }
    return chaine;
    }
    
    public static String DateQuatre(Date dat){
    	//String res="";
    	Calendar calendar = new GregorianCalendar();
    	if(dat==null){
    		calendar.set(9999,01,01);
    	}
    	else{
    		calendar.setTime(dat);	
    	}
		int mois=  calendar.get(Calendar.MONTH)+1;
		int annee=calendar.get(Calendar.YEAR);
		StringBuilder str=new StringBuilder();
		if (mois <10) {

			str.append("0"+mois);
        }else{		str.append(mois);}
		
		str.append(String.valueOf(annee).substring(2));
	  return str.toString();
    }
    
    
    public static String DateSix(Date dat){
    	//String res="";
    	Calendar calendar = new GregorianCalendar();
		calendar.setTime(dat);		
		int mois=  calendar.get(Calendar.MONTH)+1;
		int annee=calendar.get(Calendar.YEAR);
		int jour=calendar.get(Calendar.DAY_OF_MONTH);
		StringBuilder str=new StringBuilder();
		
		if (jour <10) { 

			str.append("0"+jour);
        }else{		str.append(jour);}
		
		if (mois <10) {

			str.append("0"+mois);
        }else{		str.append(mois);}		
		
		str.append(String.valueOf(annee).substring(2));
	  return str.toString();
    }
    
   
}
