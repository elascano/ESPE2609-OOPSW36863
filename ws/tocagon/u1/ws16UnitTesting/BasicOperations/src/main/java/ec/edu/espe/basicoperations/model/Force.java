/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Nohemi Tocagon Uni-Helper @ESPE
 */
public class Force {
    public float force(float mass, float aceleration){
         if (mass < 0) {
        throw new IllegalArgumentException("Mass cannot be negative");
        }
         
        float forceResult;
        forceResult= mass * aceleration;
        return forceResult;
    }
}
