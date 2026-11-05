package ec.eduespe.bascioperations.model;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Operation {
    public float add(float addend1, float addend2){
        float sum;
        sum = addend1 + addend2;
        sum = Math.round(sum*100.0F)/100.0F;
        return sum;
    }
    
    public float substract(float minuhend, float subtrahened){
        float difference;
        difference= minuhend - subtrahened;
        return difference;
    }
    
    public float multiply(float multiplicand, float multiplier){
        float product;
        product = multiplicand * multiplier;
        return product;
    }
    
    public float divide(float dividend, float divisor){
        float quotient;
        quotient = dividend / divisor;
        return quotient;
    }
}
