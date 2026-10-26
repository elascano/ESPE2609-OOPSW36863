
/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */

export class Operation {

    add(addend1: number, addend2: number): number {
        let sum: number;
        sum = addend1 + addend2;
        // complex algorithm
        sum = Math.round(sum * 100.0) / 100.0;
        return sum;
    }

    subtract(minuend: number, subtrahend: number): number {
        let difference: number;
        difference = minuend - subtrahend;
        return difference;
    }

    multiply(multiplicand: number, multiplier: number): number {
        let product: number;
        product = multiplicand * multiplier;
        return product;
    }

    divide(dividend: number, divisor: number): number {
        let quotient: number;
        quotient = dividend / divisor;
        return quotient;
    }
}
