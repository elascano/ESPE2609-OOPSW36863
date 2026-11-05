/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;

/**
 *
 * @author Alejandro Fuel
 */
public class ChickenFarmer {
    private int chickenFarmerId;
    private String name;
    private ChickenCoop[] coops;

    // Constructor vacío
    public ChickenFarmer() {
    }

    // Constructor con parámetros
    public ChickenFarmer(int chickenFarmerId, String name, ChickenCoop[] coops) {
        this.chickenFarmerId = chickenFarmerId;
        this.name = name;
        this.coops = coops;
    }

    /**
     * @return the chickenFarmerId
     */
    public int getChickenFarmerId() {
        return chickenFarmerId;
    }

    /**
     * @param chickenFarmerId the chickenFarmerId to set
     */
    public void setChickenFarmerId(int chickenFarmerId) {
        this.chickenFarmerId = chickenFarmerId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coops
     */
    public ChickenCoop[] getCoops() {
        return coops;
    }

    /**
     * @param coops the coops to set
     */
    public void setCoops(ChickenCoop[] coops) {
        this.coops = coops;
    }

    @Override
    public String toString() {
        return "ChickenFarmer{" + "chickenFarmerId=" + chickenFarmerId + ", name=" + name + ", coops=" + Arrays.toString(coops) + '}';
    }
}