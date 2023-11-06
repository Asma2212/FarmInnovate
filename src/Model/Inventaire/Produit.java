package Model.Inventaire;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produit {
    
    protected String idProduit;
    protected String formulation;
    protected String periodeApp;
    protected double doseRec;
    protected double qtNet;
    protected int nbrProd;
    
    public Produit(String idProduit, String formulation, String periodeApp, double doseRec, double qtNet, int nbrProd){
        this.idProduit=idProduit;
        this.formulation=formulation;
        this.periodeApp=periodeApp;
        this.doseRec=doseRec;
        this.qtNet=qtNet;
        this.nbrProd=nbrProd;
    }
    public Produit() {
    }

    // Common input method
    private <T> T getInputWithRetain(String message, Scanner sc, T currentVal, InputParser<T> parser) {
        System.out.println(message);
        String input = sc.nextLine().trim();

        if (!input.isEmpty()) {
            input = input.replace(',', '.');
            try {
                return parser.parse(input);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("La valeur entrée n'est pas valide. La valeur précédente a été conservée.");
            } catch (Exception ex) {
                Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }

        return currentVal;
    }

    public void saisir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'identifiant du produit");
        this.idProduit = "produit" + sc.nextLine();

        int y;
        do {
            y = getInputWithRetain("Sélectionnez une formulation : 1. liquide, 2. poudre, 3. granulé", sc, 0, Integer::parseInt);
        } while (y < 1 || y > 3);

        switch (y) {
            case 1 -> this.formulation = "liquide";
            case 2 -> this.formulation = "poudre";
            case 3 -> this.formulation = "granulé";
        }

        System.out.println("entez la periode d'application");
        this.periodeApp=sc.nextLine();

        this.doseRec = getInputWithRetain("Entrez la dose recommandée :", sc, 0.0, Double::parseDouble);

        this.qtNet = getInputWithRetain("Entrez la quantité nette :", sc, 0.0, Double::parseDouble);

        this.nbrProd = getInputWithRetain("Entrez le nombre de produit :", sc, 0, Integer::parseInt);
    }

    public void modifier() {
        Scanner sc = new Scanner(System.in);

        // saisie de la formulation
        int y = getInputWithRetain("Sélectionnez une formulation : 1. liquide, 2. poudre, 3. granulé (appuyez sur Entrée pour conserver l'ancienne) :", sc, 0, Integer::parseInt);

        switch (y) {
            case 1 -> this.formulation = "liquide";
            case 2 -> this.formulation = "poudre";
            case 3 -> this.formulation = "granulé";
        }
        sc.nextLine(); 
        
        this.periodeApp = getInputWithRetain("Entrez la période d'application (appuyez sur Entrée pour conserver l'ancienne) :", sc, this.periodeApp, String::new);
        
        this.doseRec = getInputWithRetain("Entrez la dose recommandée (appuyez sur Entrée pour conserver l'ancienne) :", sc, this.doseRec, Double::parseDouble);
     
        this.qtNet = getInputWithRetain("Entrez la quantité nette (appuyez sur Entrée pour conserver l'ancienne) :", sc, this.qtNet, Double::parseDouble);

        this.nbrProd = getInputWithRetain("Entrez le nombre de produits (appuyez sur Entrée pour conserver l'ancienne) :", sc, this.nbrProd, Integer::parseInt);
    }


    @Override
    public String toString() {
        return "idProduit: " + idProduit + ", formulation: " + formulation + ", periode d'application: " + periodeApp + ", doseRec: " + doseRec + ", qtNet: " + qtNet + ", nbrProd: " + nbrProd;
    }

}
