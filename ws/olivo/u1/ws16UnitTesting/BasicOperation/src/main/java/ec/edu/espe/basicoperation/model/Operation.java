
package ec.edu.espe.basicoperation.model;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class Operation {
    public float add(float addent1 , float addent2){
        float sum;
        sum = addent1 + addent2;
        sum = Math.round(sum*100.0F)/100.0f;
        
        return sum;
    }
    public float subtract(float minuhend, float subtrahend){
        float difference;
        difference = minuhend-subtrahend;
        return difference;
    }
    public float multiply(float multiplicand, float multiplier){
        float product;
        product = multiplicand * multiplier;
        return product;
    }
    public float divide(float dividend, float divisor){
        float quotient;
        quotient = dividend/divisor;
        return quotient;
    }
}
