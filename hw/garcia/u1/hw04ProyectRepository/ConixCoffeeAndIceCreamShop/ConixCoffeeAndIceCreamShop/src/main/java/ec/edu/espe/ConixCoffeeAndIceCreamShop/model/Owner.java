
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

public class Owner {

    private String username;
    private String password;

    public Owner(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public boolean login(String inputUser, String inputPassword) {
        if (inputUser == null || inputPassword == null) {
            return false;
        }

        return username.equals(inputUser)
                && password.equals(inputPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de usuario no puede estar vacío."
            );
        }

        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException(
                    "La contraseña no puede estar vacía."
            );
        }

        this.password = password;
    }
}
