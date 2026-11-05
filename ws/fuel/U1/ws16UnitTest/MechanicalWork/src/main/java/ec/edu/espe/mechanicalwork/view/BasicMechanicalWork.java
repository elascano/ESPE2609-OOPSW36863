/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.mechanicalwork.view;

import ec.edu.espe.mechanicalwork.model.MechanicalWork;

/**
 *
 * @author Aleandro Fuel
 */
public class BasicMechanicalWork {

    public static void main(String[] args) {
        System.out.println("--- Mechanical Work Calculations ---");
        
        MechanicalWork workObj = new MechanicalWork();
        
        // Caso de prueba 1: Fuerza de 10 N y distancia de 5 m
        float force = 10.0F;
        float distance = 5.0F;
        float result = workObj.calculateWork(force, distance);
        
        System.out.println("The work done with force " + force + " N and distance " + distance + " m is --> " + result + " J");
    }
}