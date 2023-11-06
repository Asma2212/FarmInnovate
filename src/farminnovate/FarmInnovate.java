/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package farminnovate;

import Model.Inventaire.Animal;
import Model.Inventaire.Batiment;
import Model.Inventaire.Espece;
import Model.Date;
import Model.Inventaire.Engrais;
import Model.Inventaire.Materiel;
import Model.Inventaire.Pesticide;
import Model.Inventaire.Produit;



/**
 *
 * @author ADMIN
 */
public class FarmInnovate {

    /**100
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here  
        Date d = new Date(12,12,2023);
        Produit p = new Produit();
        p.saisir();
        System.out.println(p);
        p.modifier();
        System.out.println(p);
        
    }
    
}
