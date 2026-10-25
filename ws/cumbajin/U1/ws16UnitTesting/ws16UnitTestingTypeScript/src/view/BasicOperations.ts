
/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */

import { Operation } from "../model/Operation";

class BasicOperations {

    static main(): void {
        console.log("Operations!");

        // declare and instantiate an object
        // declare and initialize parameters
        // call the method

        let operation: Operation;
        operation = new Operation();

        console.log("the addition of 1.2 and 2.4 is --> " + operation.add(1.2, 2.4));
        console.log("the addition of 1.2 and 2.4 is --> " + operation.add(1.2, 2.4));
        console.log("the addition of 1.2 and 2.4 is --> " + operation.add(1.2, 2.4));

        console.log("divide --> " + operation.divide(1, 0));

        // enter data from keyboard
        // call the method
        // observe the results
    }
}

BasicOperations.main();
