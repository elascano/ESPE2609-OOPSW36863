/**
 * @author Julian Olalla, 404 Founders, @ESPE
 */
export class Operation {

    add(addend1: number, addend2: number): number {
        let sum: number;
        sum = addend1 + addend2;
        sum = Math.round(sum * 100.0) / 100.0;
        return sum;
    }

    substract(minuhend: number, subtrahened: number): number {
        let difference: number;
        difference = minuhend - subtrahened;
        return difference;
    }

    multiply(multiplicand: number, multiplier: number): number {
        let product: number;
        product = multiplicand * multiplier;
        return product;
    }

    // Igual que en Java: 0 / 0 da NaN y 5 / 0 da Infinity, sin lanzar error
    divide(dividend: number, divisor: number): number {
        let quotient: number;
        quotient = dividend / divisor;
        return quotient;
    }
}
