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
public class ChickenFarmer {
    int chickenFarmerId;
    String name;
    ChickenCoop coops[];

    @Override
    public String toString() {
        String localCoops;
        localCoops = "";
        for (int i = 0; i < coops.length; i++) {
            localCoops += coops[i];
            localCoops += "\n";
        }
        
        return "ChickenFarmer{" + "ckichenFarmerId=" + chickenFarmerId + ", name=" + name + ", coops=" + coops + '}';
    }
    
    public ChickenFarmer() {
        chickenFarmerId = 1;
        name = "";
        coops = new ChickenCoop[2];
        Chicken chickens[];
        chickens = new Chicken[2];
        chickens[0] = new Chicken(0, "pepita", "black", new Date(), true);
        chickens[1] = new Chicken(0, "marujita", "black", new Date(), true);
        
        coops[0] = new ChickenCoop(0, chickens);
        coops[1] = new ChickenCoop(1, chickens);
    }
}
