package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */

public class Operation {

    public float add(float addend1, float addend2) {
        float sum;
        sum = addend1 + addend2;
        sum= Math.round(sum*100.0F)/100f;
        return sum;
    }

    public float subtract(float minuend, float subtrahend) {
        float difference;
        difference = minuend - subtrahend;
        return difference;
    }

    public float multiply(float multiplicand, float multiplier) {
        float product;
        product = multiplicand * multiplier;
        return product;
    }

    public float divide(float dividend, float divisor) {
        float quotient;
        quotient = dividend / divisor;
        return quotient;
    }
}

    

    

