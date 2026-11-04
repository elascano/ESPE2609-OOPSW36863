package ec.edu.espe.basicoperation.view;

import ec.edu.espe.basicoperation.model.Operation;
import ec.edu.espe.basicoperation.model.Paralleleppiped;

/**
 *
 * @author Danilo Simba, @ESPE
 */
public class BasicOperation {

    public static void main(String[] args) {
        System.out.println("Operations");
        
        //declare and instantiate an object
        //declare and unitaria parameters
        //call the method
        
        Operation operation;
        operation = new Operation();
        System.out.println("the addition of 1.2 and 2.4 is --> "+ operation.add(1.2F, 2.4F));
        
        //enter data from kyebord
        //call the method
        //observ the results
        
        System.out.println("Divide -->" + operation.divide(1, 0));
        
        Paralleleppiped paralleleppiped;
        paralleleppiped = new Paralleleppiped();
        System.out.println("The volumen is -->" + paralleleppiped.computeVolume(4.4F, 3.8F, 3.4F));
        
        
    }
}
