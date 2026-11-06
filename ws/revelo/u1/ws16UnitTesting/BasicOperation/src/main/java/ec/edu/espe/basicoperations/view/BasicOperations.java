package ec.edu.espe.basicoperations.view;

import ec.edu.espe.basicoperations.model.DistanceBetweenPoints;
import ec.edu.espe.basicoperations.model.Operation;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class BasicOperations {
    public static void main(String[] args){
        System.out.println("Operations!");
        
        Operation operation;
        DistanceBetweenPoints distance;
        
        operation = new Operation();
        System.out.println("the addition of 1.2 and 2.4 is --> " + operation.add(1.2F, 2.4F));
        System.out.println("the addition of 1.2 and 2.4 is --> " + operation.add(1.2F, 2.4F));
        System.out.println("the addition of 1.2 and 2.4 is --> " + operation.add(1.2F, 2.4F));
        
        System.out.println("divide --> " + operation.divide(0,0));
        
        //System.out.println("the distance between poins is --> " + distance.computeDistanceBetweenPoints(4.0F,3.0F,1.0F,6.0F));
        
    }
    
}
