package ec.edu.ec.basicoperations.model;

public class Operation {
    public float add(float addend1, float addend2){
        float sum;
        sum = addend1 + addend2;
        return sum;
    }
    public float subtract(float minuend, float subtrahend) {
        float difference;
        difference = minuend - subtrahend;
        return difference;
    }

    public float multiply(float factor1, float factor2) {
        float product;
        product = factor1 * factor2;
        return product;
    }

    public float divide(float dividend, float divisor) {
        float quotient;
        quotient = dividend / divisor;
        return quotient;
    }

}

