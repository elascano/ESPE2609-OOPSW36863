package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerConstructor() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro@gmail.com"
        );

        assertEquals("Alejandro", instance.getName());
    }

    @Test
    public void testCustomerConstructorWithEmptyName() {
        Customer instance = new Customer(
                "",
                "0991234567",
                "alejandro@gmail.com"
        );
    }

    @Test
    public void testCustomerConstructorWithInvalidPhone() {
        Customer instance = new Customer(
                "Alejandro",
                "123",
                "alejandro@gmail.com"
        );
    }

    @Test
    public void testCustomerConstructorWithInvalidEmail() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro.gmail.com"
        );
    }
    @Test
    public void testSetName() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro@gmail.com"
        );

        instance.setName("Carlos");

        assertEquals("Carlos", instance.getName());
    }

    @Test
    public void testSetNameWithSpaces() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro@gmail.com"
        );

        instance.setName("  Ana  ");

        assertEquals("Ana", instance.getName());
    }

    @Test
    public void testSetNameWithEmptyValue() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro@gmail.com"
        );

        instance.setName("");
    }

    @Test
    public void testSetNameWithNull() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro@gmail.com"
        );

        instance.setName(null);
    }


    // =========================
    // SET PHONE TESTS
    // =========================

    @Test
    public void testSetPhone() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro@gmail.com"
        );

        instance.setPhone("0987654321");

        assertEquals("0987654321", instance.getPhone());
    }

    @Test
    public void testSetPhoneWithInvalidValue() {
        Customer instance = new Customer(
                "Alejandro",
                "0991234567",
                "alejandro@gmail.com"
        );

        instance.setPhone("123");
    }
}