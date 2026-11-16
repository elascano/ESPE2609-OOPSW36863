/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmapp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public abstract class FarmAnimal {
    private int id;
    private String breed;
    private Date lastSheering;

    public FarmAnimal(int id, String breed, Date bornOnDate) {
        this.id = id;
        this.breed = breed;
        this.lastSheering = bornOnDate;
    }
    
    @Override
    public String toString() {
        return "id=" + id + ", breed=" + breed + 
        ", bornOnDate=" + lastSheering.getDate() + 
        "/" + (lastSheering.getMonth() + 1) + 
        "/" + (lastSheering.getYear() + 1900) +  ", ";
    }
    
    public int getAgeInMonths(LocalDate birthDate){
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null.");
        }
        LocalDate currentDate = LocalDate.now();
        if (birthDate.isAfter(currentDate)) {
            throw new IllegalArgumentException("Birth date cannot be in the future.");
        }
        return (int) Period.between(birthDate, currentDate).toTotalMonths();
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
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the lastSheering
     */
    public Date getBornOnDate() {
        return lastSheering;
    }

    /**
     * @param bornOnDate the lastSheering to set
     */
    public void setBornOnDate(Date bornOnDate) {
        this.lastSheering = bornOnDate;
    }
    
}
