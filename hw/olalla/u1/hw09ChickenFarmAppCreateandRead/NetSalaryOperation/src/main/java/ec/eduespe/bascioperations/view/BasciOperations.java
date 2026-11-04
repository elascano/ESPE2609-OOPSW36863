package ec.eduespe.bascioperations.view;

import ec.eduespe.bascioperations.model.Operation;
/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class BasciOperations {

    public static void main(String[] args) {
        System.out.println("Net salary operations");

        //declare and instialiate an object
        //declare and analize parameters
        //call the method

        Operation operation;
        operation = new Operation();
        System.out.println("The net salary is -->" + operation.netSalary(4000, 600, 240, 160));        
    }
}
