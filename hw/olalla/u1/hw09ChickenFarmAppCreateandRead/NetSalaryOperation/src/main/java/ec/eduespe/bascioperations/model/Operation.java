package ec.eduespe.bascioperations.model;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Operation {
    public float netSalary(float grossPay, float taxes, float contributionIESS,float voluntaryDeductions){
        float salary;
        salary = grossPay - taxes - contributionIESS - voluntaryDeductions;        
        return salary;
    }        
}
