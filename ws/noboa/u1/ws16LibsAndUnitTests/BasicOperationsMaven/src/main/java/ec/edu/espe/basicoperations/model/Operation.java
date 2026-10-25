package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Alejandro
 */
public class Operation {
    public float add(float addend1, float addend2) {
        float sum;
        sum = addend1 + addend2;
        sum = Math.round(sum*100.0F)/100.0F;
        return sum;
    }
    
    public float substract(float minuhend, float subtrahend) {
        float difference;
        difference = minuhend - subtrahend;
        return difference;
    }
    
    public float multiply(float multiplicand, float multiplier) {
        float multiply;
        multiply = multiplicand * multiplier;
        return multiply;
    }
    
    public float divide(float dividend, float divisor) {
        float divide;
        divide = dividend / divisor;
        return divide;
    }
}