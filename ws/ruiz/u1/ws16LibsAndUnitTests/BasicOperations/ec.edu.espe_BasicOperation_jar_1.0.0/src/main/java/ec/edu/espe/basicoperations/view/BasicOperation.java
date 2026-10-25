package ec.edu.espe.basicoperations.view;

import ec.edu.espe.basicoperations.model.Operation;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class BasicOperation {

    public static void main(String[] args) {
        System.out.println("Operations");
        
        Operation operation;
        operation = new Operation();
        System.out.println("the addition of 2 and 3 is -->" + operation.add(1.2F,2.4F));
        System.out.println("the addition of 2 and 3 is -->" + operation.add(1.2F,2.4F));
        System.out.println("the addition of 2 and 3 is -->" + operation.add(1.2F,2.4F));
        
        System.out.println("divide -->" + operation.divide(0,0));
        System.out.println("Area of the rectangle is -->" + operation.computeArea(3.0F, 5.0F));
        
        
    }
}
