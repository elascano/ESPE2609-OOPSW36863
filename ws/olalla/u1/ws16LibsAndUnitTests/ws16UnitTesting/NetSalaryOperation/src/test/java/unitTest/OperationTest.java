package unitTest;

import ec.eduespe.bascioperations.model.Operation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class OperationTest {
    
    public OperationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of netSalary method, of class Operation.
     */
    @Test
    public void testNetSalary0() {
        System.out.println("netSalary");
        float grossPay = 0.0F;
        float taxes = 0.0F;
        float contributionIESS = 0.0F; //9.45% from grossPay
        float voluntaryDeductions = 0.0F;
        Operation instance = new Operation();
        float expResult = 0.0F;
        float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
        assertEquals(expResult, result, 0);        
    }
    
    @Test
    public void testNetSalary() {
        System.out.println("netSalary");
        float grossPay = 4000.0F;
        float taxes = 600.0F;
        float contributionIESS = 378.0F; //9.45% from grossPay
        float voluntaryDeductions = 160.0F;
        Operation instance = new Operation();
        float expResult = 2862.0F;
        float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
        assertEquals(expResult, result, 0);        
    }
    
    @Test
    public void testNetSalaryDecimals() {
        System.out.println("netSalary");
        float grossPay = 2500.65F;
        float taxes = 345.8F;
        float contributionIESS = 236.31F; //9.45% from grossPay
        float voluntaryDeductions = 160.5F;
        Operation instance = new Operation();
        float expResult = 1758.04F;
        float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
        assertEquals(expResult, result, 0); 
    }
    
    @Test
    public void testNetSalaryNegativeGrossPay() {
        System.out.println("netSalary");
        float grossPay = -2500.65F;
        float taxes = 345.8F;
        float contributionIESS = 236.31F; //9.45% from grossPay
        float voluntaryDeductions = 160.5F;
        Operation instance = new Operation();
        float expResult = 1758.04F;
        float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
        assertEquals(expResult, result, -1); 
    }
    
    @Test
    public void testNetSalaryNegativeResult() {
        System.out.println("netSalary");
        float grossPay = 2500.0F;
        float taxes = 1000.0F;
        float contributionIESS = 600.0F; //9.45% from grossPay
        float voluntaryDeductions = 500.0F;
        Operation instance = new Operation();
        float expResult = 0.0F;
        float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
        assertEquals(expResult, result, -1); 
    }
        
@Test
public void testNetSalaryNoDeductions() {
    System.out.println("netSalary");
    float grossPay = 3000.0F;
    float taxes = 0.0F;
    float contributionIESS = 0.0F;
    float voluntaryDeductions = 0.0F;
    Operation instance = new Operation();
    float expResult = 3000.0F;
    float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
    assertEquals(expResult, result, 0.01F);
}

@Test
public void testNetSalaryDeductionsEqualGrossPay() {
    System.out.println("netSalary");
    float grossPay = 1000.0F;
    float taxes = 400.0F;
    float contributionIESS = 300.0F;
    float voluntaryDeductions = 300.0F;
    Operation instance = new Operation();
    float expResult = 0.0F;
    float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
    assertEquals(expResult, result, 0.01F);
}

@Test
public void testNetSalaryHighSalary() {
    System.out.println("netSalary");
    float grossPay = 1000000.0F;
    float taxes = 250000.0F;
    float contributionIESS = 94500.0F; //9.45% from grossPay
    float voluntaryDeductions = 5500.0F;
    Operation instance = new Operation();
    float expResult = 650000.0F;
    float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
    assertEquals(expResult, result, 0.01F);
}

@Test
public void testNetSalaryNegativeTaxes() {
    System.out.println("netSalary");
    float grossPay = 3000.0F;
    float taxes = -100.0F;
    float contributionIESS = 283.5F; //9.45% from grossPay
    float voluntaryDeductions = 100.0F;
    Operation instance = new Operation();
    assertThrows(IllegalArgumentException.class,
            () -> instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions));
}

@Test
public void testNetSalaryWrongIessContribution() {
    System.out.println("netSalary");
    float grossPay = 4000.0F;
    float taxes = 600.0F;
    float contributionIESS = 37.8F; //should be 378.0 (9.45% from grossPay)
    float voluntaryDeductions = 160.0F;
    Operation instance = new Operation();
    float expResult = 2862.0F;
    float result = instance.netSalary(grossPay, taxes, contributionIESS, voluntaryDeductions);
    assertEquals(expResult, result, 0.01F);
}
}
