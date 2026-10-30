/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mechanicalwork.model;

/**
 *
 * @author Aleandro Fuel
 */
public class MechanicalWork {

    // Método para calcular el trabajo mecánico básico: W = Fuerza * Distancia
    public float calculateWork(float force, float distance) {
        float work;
        work = force * distance;
        return work;
    }

    
}