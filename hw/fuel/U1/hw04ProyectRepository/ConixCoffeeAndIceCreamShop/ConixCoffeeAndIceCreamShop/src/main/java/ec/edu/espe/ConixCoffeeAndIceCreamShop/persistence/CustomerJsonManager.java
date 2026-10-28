
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Customer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerJsonManager {

    private final Path filePath;
    private final Gson gson;
    private final Type customerListType;

    public CustomerJsonManager() {
        filePath = Paths.get("data", "customers.json");

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        customerListType =
                new TypeToken<ArrayList<Customer>>() {}.getType();
    }

    public void saveCustomers(List<Customer> customers)
            throws IOException {

        if (customers == null) {
            throw new IllegalArgumentException(
                    "Customers list cannot be null.");
        }

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(customers),
                StandardCharsets.UTF_8
        );
    }

    public List<Customer> loadCustomers() throws IOException {

        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }

        String json = Files.readString(
                filePath,
                StandardCharsets.UTF_8
        );

        try {
            List<Customer> customers =
                    gson.fromJson(json, customerListType);

            return customers == null
                    ? new ArrayList<>()
                    : customers;

        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read customers.json.", e);
        }
    }
}
