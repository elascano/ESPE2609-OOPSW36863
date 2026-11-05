
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

public class Customer {

    private String name;
    private String phone;
    private String email;
    private Order order;

    public Customer(String name, String phone, String email) {
        setName(name);
        setPhone(phone);
        setEmail(email);
        this.order = null;
    }

    public void placeOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException(
                    "El pedido no puede ser nulo."
            );
        }

        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del cliente no puede estar vacío."
            );
        }

        this.name = name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("[0-9+() -]{7,20}")) {
            throw new IllegalArgumentException(
                    "El número de teléfono no tiene un formato válido."
            );
        }

        this.phone = phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null
                || !email.trim().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException(
                    "El correo electrónico no tiene un formato válido."
            );
        }

        this.email = email.trim();
    }

    public Order getOrder() {
        return order;
    }
}
