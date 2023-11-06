/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package farminnovate;

import Model.Date;
import Model.Inventaire.Animal;
import Model.Inventaire.Batiment;
import Model.Inventaire.Espece;
import Model.Inventaire.Materiel;

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
        Batiment b = new Batiment("bat22","Enclos");
        Date d = new Date(12,12,2023);
        Materiel m = new Materiel("mat10","tracteur",d,2);
        Animal a1 = new Animal("An101",Espece.VACHE,"male",d,400.5);
        Animal a2 = new Animal("An100",Espece.VACHE,"femelle",d,300.5);
        b.ajouter(a1);
        System.out.println(b);
        b.ajouter(a2);
        System.out.println(b);
        b.ajouter(m);
        System.out.println(b);
        
        
    }
    
}
