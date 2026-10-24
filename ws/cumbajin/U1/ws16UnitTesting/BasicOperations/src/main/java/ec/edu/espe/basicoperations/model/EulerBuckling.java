/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class EulerBuckling {
    
    public double calculateCriticalLoad(double elasticModulus, double momentOfInertia, double lengthFactor, double columnLength) {

        double criticalLoad;

        criticalLoad = (Math.PI * Math.PI * elasticModulus * momentOfInertia) / ((lengthFactor * columnLength) * (lengthFactor * columnLength));

        return criticalLoad;
    }
    
}
