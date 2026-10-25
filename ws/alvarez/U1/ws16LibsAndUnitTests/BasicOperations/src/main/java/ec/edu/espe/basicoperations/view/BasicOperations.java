package ec.edu.espe.basicoperations.view;

import ec.edu.espe.basicoperations.model.Operation;

/**
 *
 * @author Juan Alvarez, MosQ, @ESPE
 */
public class BasicOperations {

    public static void main(String[] args) {
        System.out.println("Operations!");
        
        Operation operation;
        operation = new Operation();
        System.out.println("the addition of  and 3 -->" + operation.add(2,3));
        System.out.println("the addition of  and 3 -->" + operation.add(2,3));
        System.out.println("the addition of  and 3 -->" + operation.add(2,3));
        
        System.out.println("divide -->" + operation.divide(0,0));
    }
}
