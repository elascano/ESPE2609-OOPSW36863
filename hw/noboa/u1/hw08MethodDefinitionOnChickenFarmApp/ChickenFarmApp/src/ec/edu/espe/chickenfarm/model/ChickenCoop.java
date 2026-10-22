/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[] = new Chicken[10];
    private int currentIndex;
    
    // we need to know the maximum, in this case is 10
    // we need to know the index 
    
    public void add(Chicken chicken) {
        boolean added = false;
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] == null) {
                chickens[i] = chicken;
                added = true;
                System.out.println("Chicken with ID " + chicken.getId() + " added successfully");
                break;
            }
        }
        if (!added) {
            System.out.println("Error: Coop is full! Couldn't add chicken.");
        }
    }
    
    public void remove(int chickenId) {
        boolean found = false;
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] != null && chickens[i].getId() == chickenId) {
                chickens[i] = null;
                found = true;
                System.out.println("Chicken with ID " + chickenId + " was removed from coop");
                break;
            }
        }
        if (!found) {
            System.out.println("Chicken with ID " + chickenId + " was not found in coop");
        }
        
    }
    
    public void resetIteration() {
        this.currentIndex = 0;
        System.out.println("Iteration reset to the start of coop");
    }
    
    public Chicken next() {
        while (currentIndex < chickens.length) {
            Chicken current = chickens[currentIndex];
            currentIndex++;
            if (current != null) {
                System.out.println("Next chicken retrieved: " + current.getName());
                return current;
            }
        }
        System.out.println("No more chickens available in the coop iteration");
        return null;
    }

    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + chickens + '}';
    }
    
    /**
     * @return the chickenCoopId
     */
    public int getChickenCoopId() {
        return chickenCoopId;
    }

    /**
     * @param chickenCoopId the chickenCoopId to set
     */
    public void setChickenCoopId(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
    }

    /**
     * @return the chickens
     */
    public Chicken[] getChickens() {
        return chickens;
    }

    /**
     * @param chickens the chickens to set
     */
    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
    }
}
