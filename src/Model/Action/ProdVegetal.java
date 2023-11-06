/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Action;

import Model.Date;

/**
 *
 * @author ADMIN
 */
public class ProdVegetal extends Production{
    private String nature ;
    private Date dateRecolte;

    public ProdVegetal() {
    }

    public ProdVegetal(String nature, Date dateRecolte, int refP, int qteStock, Double prix) {
        super(refP, qteStock, prix);
        this.nature = nature;
        this.dateRecolte = dateRecolte;
    }
    
    
}
