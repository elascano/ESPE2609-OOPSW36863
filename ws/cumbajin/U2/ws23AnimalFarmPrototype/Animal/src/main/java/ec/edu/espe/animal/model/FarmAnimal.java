/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animal.model;

import java.util.Date;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public abstract class FarmAnimal {
    private int id;
    private String bread;
    private Date bornOnDate;

    public FarmAnimal(int id, String bread, Date bornOnDate) {
        this.id = id;
        this.bread = bread;
        this.bornOnDate = bornOnDate;
    }

   
    @Override
    public String toString() {
    return "FarmAnimal{" + "id=" + id
            + ", bread=" + bread
            + ", bornOnDate=" + (bornOnDate.getYear() + 1900)
            + '}';
}

    
    
    public int getAgeInMonths(){
        return 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bread
     */
    public String getBread() {
        return bread;
    }

    /**
     * @param bread the bread to set
     */
    public void setBread(String bread) {
        this.bread = bread;
    }

    /**
     * @return the bornOnDate
     */
    public Date getBornOnDate() {
        return bornOnDate;
    }

    /**
     * @param bornOnDate the bornOnDate to set
     */
    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }
    
    
}
