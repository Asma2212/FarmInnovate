package Model.Inventaire;

import Model.Date;
import java.util.Scanner;

public class Animal {
    
    private int idAnimal;
    private Espece espece;
    private String genre;
    private Date dateNaiss;
    private float poids;
    
 //***************************constructeur***************************
    
    public Animal(int idAnimal, Espece espece, String genre, Date dateNaiss, float poids){
        this.idAnimal=idAnimal;
        this.espece=espece;
        this.genre=genre;
        this.dateNaiss=dateNaiss;
        this.poids=(float) poids;
    }
    
    public Animal(){this.dateNaiss=new Date();}
//***************************getters and setters***************************
   
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    
    public Espece getEspece() {
        return espece;
    }
    
    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date age) {
        this.dateNaiss = dateNaiss;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }
 /***************************toString***************************/ 
    
    @Override
    public String toString() {
        return "Espece: " + espece + ", genre: " + genre + ", Date de Naissance: " + dateNaiss+ ", poids: " + poids;
    }
 /***************************Saisir***************************/ 
    public void saisir(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Entrez l'identifiant");
        this.idAnimal=sc.nextInt();
        System.out.println("Select an Espece attribute:");
        for (Espece esp : Espece.values()) {
            System.out.println(esp.ordinal() + 1 + "." + esp);
        }
        int x = sc.nextInt();
        if (x >= 1 && x <= Espece.values().length) {
            this.espece = Espece.values()[x - 1];
            System.out.println("Vous avez selectinner: " + espece);
        } else {
            System.out.println("Selection invalide");
        }
        sc.nextLine();
        //Scanner sc1= new Scanner(System.in);
        do {
        System.out.println("Enterez 'F' for female or 'M' for male: ");
        this.genre = sc.nextLine().toUpperCase();
         } while (!"F".equals(this.genre) && !"M".equals(this.genre));        
        System.out.println("entrez la date de naissance ");
        this.dateNaiss.SaisieDate(sc);
        System.out.println("entrez le poids en kilogramme");
        this.poids= sc.nextFloat();
    }
    
  /***************************Affichage***************************/ 
    public void affichageAnimal(){
          String str = ", Espece: ";

    if (genre != null) {
        if ("M".equals(genre)) {
            switch (espece) {
                case VACHE -> str += "TAUREAU";
                case POULE -> str += "COQ";
                case DINDE -> str += "DINDON";
                case CHEVRE -> str += "BOUC";
                case ABEILLE -> str += "FAUX BOURDON";
                default -> {
                }
            }
        } else if ("F".equals(genre)) {
            switch (espece) {
                case CHEVAL -> str += "JUMENT";
                case MOUTON -> str += "BREBIS";
                case LAPIN -> str += "LAPINE";
                default -> {str+=String.valueOf(espece);}
            }
        }    
        System.out.println("idAnimal: "+idAnimal+str+ ", genre: " + genre + ", age: " + dateNaiss + ", poids: " + poids);
     }  
    }
//************************Modifier***********************************
    public void modifierAnimal(Animal a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Modification de l'animal");

       // System.out.println("Entrez l'âge:");
      //  a.dateNaiss = sc.nextInt();

        sc.nextLine(); // Consume the newline character left by nextInt()

        do {
            System.out.println("Entrez 'F' for female or 'M' for male: ");
            a.genre = sc.nextLine().toUpperCase();
        } while (!"F".equals(a.genre) && !"M".equals(a.genre));

        System.out.println("Entrez le poids en kilogrammes:");
        a.poids = sc.nextFloat();
}

    
    
}
