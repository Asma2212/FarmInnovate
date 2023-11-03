package Model.Inventaire;

import java.awt.BorderLayout;
import java.util.Scanner;

public class Plante {
    private String culture;
    private String nature;
    private String saisonRecolte;
    private float qtEauJour;
    
 //************************Constructers*******************   
    public Plante(String culture, String nature, String saisonRecolte, float qtEaujour){
        this.culture= culture;
        this.nature=nature;
        this.saisonRecolte=saisonRecolte;
        this.qtEauJour=qtEauJour;
    }
    public Plante(){}
    
//************************Getters and Setters*******************   

    public String getCulture() { return culture; }

    public void setCulture(String culture) { this.culture = culture; }

    public String getNature() { return nature; }

    public void setNature(String nature) { this.nature = nature; }

    public String getSaisonRecolte() { return saisonRecolte; }

    public void setSaisonRecolte(String saisonRecolte) { this.saisonRecolte = saisonRecolte; }

    public float getQtEauJour() { return qtEauJour; }

    public void setQtEauJour(float qtEauJour) { this.qtEauJour = qtEauJour; }
    
//***********************Saisie******************** 
    public void saisir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("entrez la culture");
        this.culture=sc.nextLine();
        
        System.out.println("entrez la nature");
        this.nature=sc.nextLine();
        System.out.println("entrez la saison de recolte");
        this.saisonRecolte=sc.nextLine();
        System.out.println("entrez la quantite d'eau nessecaire par jour");
        this.qtEauJour=qtEauJour;
    }
//***********************Affichage********************     
}
