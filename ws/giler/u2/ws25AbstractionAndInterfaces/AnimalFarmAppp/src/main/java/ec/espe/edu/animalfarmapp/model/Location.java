/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.animalfarmapp.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Location {
    private int id;
    private String desciption;

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", desciption=" + desciption + '}';
    }

    public Location(int id, String desciption) {
        this.id = id;
        this.desciption = desciption;
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
     * @return the desciption
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * @param desciption the desciption to set
     */
    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
    
    
}
