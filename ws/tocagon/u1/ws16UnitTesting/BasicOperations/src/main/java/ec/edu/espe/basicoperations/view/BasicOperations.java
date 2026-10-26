package ec.edu.espe.basicoperations.view;

import ec.edu.espe.basicoperations.model.Operation;

/**
 *
 * @author Nohemi Tocagon Uni-Helper @ESPE
 */
public class BasicOperations {

    public static void main(String[] args) {
        System.out.println("Operations");
        
        //declare and instantiate an object
        //declare an inicialize parameters
        //call the method
        
        Operation operation;
        operation= new Operation();
        System.out.println("the adition of 1.2 and 2.4 is -->" + operation.add(1.2F, 2.4F));
        
        System.out.println("divide -->" + operation.divide(4, 0));
        //enter data from keybord
        //call the method
        //observ the result
        
    }
}
