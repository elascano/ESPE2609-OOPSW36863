/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animal.model;

/**
 * food
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Food {
    
    private String description;

    public Food(String description) {
        this.description = description;
    }
    
    

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
    
    
    
    
    
    
    
    
}
