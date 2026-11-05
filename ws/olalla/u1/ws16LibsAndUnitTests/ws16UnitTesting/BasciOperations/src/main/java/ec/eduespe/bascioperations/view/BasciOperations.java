package ec.eduespe.bascioperations.view;

import ec.eduespe.bascioperations.model.Operation;
/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class BasciOperations {

    public static void main(String[] args) {
        System.out.println("Operations");

        //declare and instialiate an object
        //declare and analize parameters
        //call the method

        Operation operation;
        operation = new Operation();
        System.out.println("the addition of 2 and 3 is -->" + operation.add(1.2F,2.4F));
        System.out.println("the addition of 2 and 3 is -->" + operation.add(1.2F,2.4F));
        System.out.println("the addition of 2 and 3 is -->" + operation.add(1.2F,2.4F));

        System.out.println("the addition of 2 and 3 is -->" + operation.divide(0, 0));
    }
}
