import ec.edu.ec.basicoperations.model.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    private Operation operation;
    private final float DELTA = 0.0001f;

    @BeforeEach
    void setUp() {
        operation = new Operation();
    }

    @Test
    void add() {
        float result = operation.add(5.5f, 4.5f);
        assertEquals(10.0f, result, DELTA, "La suma de 5.5 + 4.5 debería ser 10.0");
    }

    @Test
    void subtract() {
        float result = operation.subtract(10.0f, 4.0f);
        assertEquals(6.0f, result, DELTA, "La resta de 10.0 - 4.0 debería ser 6.0");
    }

    @Test
    void multiply() {
        float result = operation.multiply(3.0f, 2.5f);
        assertEquals(7.5f, result, DELTA, "La multiplicación de 3.0 * 2.5 debería ser 7.5");
    }

    @Test
    void divide() {
        float result = operation.divide(10.0f, 4.0f);
        assertEquals(2.5f, result, DELTA, "La división de 10.0 / 4.0 debería ser 2.5");
    }
}
