package Model.Inventaire;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Pesticide extends Produit{

    private TypePesticide typepest;
    private String subActive;
    private ArrayList<String> cultures ;
    private ArrayList<String> ravageurs ;
    private int DAR;
    
    
    //constructeur
    public Pesticide(){}
    
    public Pesticide(TypePesticide typepest, String subActive, ArrayList<String> cultures,ArrayList<String> ravageurs ){
        super();
        this.typepest=typepest;
        this.subActive=subActive;
        this.cultures=cultures;
        this.ravageurs=ravageurs;
    }
    
    //saisie d'un pesticide
    @Override
    public void saisir() {
        Scanner sc = new Scanner(System.in);
        super.saisir();
        //saisie du type de pesticide
        System.out.println("selectionner le type de pesticide");
        String str="";
        for (TypePesticide type : TypePesticide.values()) {
            str+=type.ordinal() + 1 + "." + type+", ";
        }
        System.out.println(str);
        int x = sc.nextInt();
        if (x >= 1 && x <= TypePesticide.values().length) {
            this.typepest = TypePesticide.values()[x - 1];
            System.out.println("Vous avez selectinner: " + typepest);
        } else {
            System.out.println("Selection invalide");
        }
        sc.nextLine();
        //saisie subActive
        System.out.println("entrez le subActive");
        this.subActive=sc.nextLine();
        //saisie des cultures à traite
        this.cultures = inputList("cultures",sc);
        //saisie des ravageurs à traite
        this.ravageurs = inputList("ravageurs",sc);
       
        try {
            System.out.println("Entrez le délai avant récolte (appuyez sur Entrée pour conserver l'ancienne) :");
            this.DAR= sc.nextInt();
        } catch (InputMismatchException e) {
             System.out.println("La valeur entrée n'est pas un nombre entier valide. La valeur précédente a été conservée.");
             this.DAR=0;
        }
        
    }
    //modifier pesticide
    @Override
    public void modifier() {
        Scanner sc = new Scanner(System.in);
        super.modifier();

        System.out.println("Sélectionnez le type de pesticide(appyuez sur 9 pour conserver la valeur ancinne) :");
        String str = "";
        for (TypePesticide type : TypePesticide.values()) {
            str+=(type.ordinal() + 1) + ". " + type+", ";
        }
        System.out.println(str);
        int x = sc.nextInt();
        if (x >= 1 && x <= TypePesticide.values().length) {
            this.typepest = TypePesticide.values()[x - 1];
            System.out.println("Vous avez sélectionné : " + typepest);
        } else {
            System.out.println("Sélection invalide. La valeur précédente sera conservée.");
        }
        sc.nextLine();

        System.out.println("Entrez le subActive :");
        String newSubActive = sc.nextLine();
        if (!newSubActive.isEmpty()) {
            this.subActive = newSubActive;
        }

        this.cultures = inputList("culture", sc);

        this.ravageurs = inputList("ravageur", sc);

        try {
            System.out.println("Entrez le délai avant récolte :");
            int newDAR = sc.nextInt();
            this.DAR = newDAR;
        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide pour le délai avant récolte. La valeur précédente sera conservée.");
                sc.nextLine();  
        }
    }
    
    //methode pour entrer une list 
    private ArrayList<String> inputList(String itemName, Scanner sc) {
        ArrayList<String> items = new ArrayList<>();
        char rep;

        do {
            System.out.println("Entrez un " + itemName + " (ou une lettre pour arrêter) :");
            String item = sc.nextLine().trim();
            if (!item.isEmpty()) {
                items.add(item);
            } 
            System.out.println("Voulez-vous ajouter un autre " + itemName + " (o/n) ?");
            rep = sc.next().charAt(0);
            sc.nextLine();
        } while (rep == 'o' || rep == 'O');

        return items;
    }
    
    
    @Override
    public String toString() {
        String str = super.toString() + ", typepest: " + typepest + ", subActive: " + subActive + ", cultures:[";

        // Concatenation des elements du tableau cultures
        Iterator<String> it = cultures.iterator();
        while (it.hasNext()) {
            str += it.next();
            if (it.hasNext()) {
                str += ", "; 
            }
        }

        str += "], ravageurs:[ ";
        
        // Concatenation des elements du tableau ravageurs
        Iterator<String> it1 = ravageurs.iterator();
        while (it1.hasNext()) {
            str += it1.next();
            if (it1.hasNext()) {
                str += ", "; 
            }
        }
        str += "], DAR: " + DAR;
        return str;
    }
    
}
