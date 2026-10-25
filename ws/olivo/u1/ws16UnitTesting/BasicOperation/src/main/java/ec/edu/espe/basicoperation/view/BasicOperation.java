
package ec.edu.espe.basicoperation.view;

import ec.edu.espe.basicoperation.model.Operation;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class BasicOperation {
    public static void main(String[] args) {
        System.out.println("Operations By Nestor Olivo");
        
        Operation operation = new Operation();
        System.out.println("the adition is : " + operation.add(1.2F,2.4F));
        
        //enter data from de keyboard
        System.out.println("Divide ---" + operation.divide(0, 0));
        System.out.println("Divide ---" + operation.divide(1, 0));
    }
}
