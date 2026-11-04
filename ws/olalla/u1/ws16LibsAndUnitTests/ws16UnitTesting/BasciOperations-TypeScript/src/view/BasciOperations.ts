import { Operation } from "../model/Operation";

/**
 * @author Julian Olalla, 404 Founders, @ESPE
 */
function main(): void {
    console.log("Operations");

    // declare and instialiate an object
    // declare and analize parameters
    // call the method

    let operation: Operation;
    operation = new Operation();
    console.log("the addition of 2 and 3 is -->" + operation.add(1.2, 2.4));
    console.log("the addition of 2 and 3 is -->" + operation.add(1.2, 2.4));
    console.log("the addition of 2 and 3 is -->" + operation.add(1.2, 2.4));

    console.log("the addition of 2 and 3 is -->" + operation.divide(0, 0));
}

main();
