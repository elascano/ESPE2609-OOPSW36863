import { describe, it } from "node:test";
import assert from "node:assert";

import { Operation } from "../src/model/Operation";

/**
 * @author Julian Olalla, 404 Founders, @ESPE
 */
describe("OperationTest", () => {

    it("testAdd", () => {
        console.log("add");
        const addend1 = 1.2;
        const addend2 = 3.4;
        const instance = new Operation();
        const expResult = 4.6;
        const result = instance.add(addend1, addend2);
        assert.strictEqual(result, expResult);
    });

    it("testSubstract", () => {
        console.log("substract");
        const minuhend = 2.0;
        const subtrahened = 4.0;
        const instance = new Operation();
        const expResult = -2.0;
        const result = instance.substract(minuhend, subtrahened);
        assert.strictEqual(result, expResult);
    });

    it("testMultiply", () => {
        console.log("multiply");
        const multiplicand = 3.0;
        const multiplier = 2.0;
        const instance = new Operation();
        const expResult = 6.0;
        const result = instance.multiply(multiplicand, multiplier);
        assert.strictEqual(result, expResult);
    });

    it("testDivide", () => {
        console.log("divide");
        const dividend = 6.0;
        const divisor = 2.0;
        const instance = new Operation();
        const expResult = 3.0;
        const result = instance.divide(dividend, divisor);
        assert.strictEqual(result, expResult);
    });

    // ---- pruebas extra: división entre cero (en Java no lanza error) ----

    it("testDivideZeroByZeroIsNaN", () => {
        assert.ok(Number.isNaN(new Operation().divide(0, 0)));
    });

    it("testDivideByZeroIsInfinity", () => {
        assert.strictEqual(new Operation().divide(5, 0), Infinity);
        assert.strictEqual(new Operation().divide(-5, 0), -Infinity);
    });
});
