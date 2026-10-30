
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Tax;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaxJsonManager {

    private final Path filePath;
    private final Gson gson;

    public TaxJsonManager() {
        filePath = Paths.get("data", "tax.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveTax(Tax tax) throws IOException {

        if (tax == null) {
            throw new IllegalArgumentException(
                    "Tax cannot be null.");
        }

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(tax.getTaxRate()),
                StandardCharsets.UTF_8
        );
    }

    public Tax loadTax() throws IOException {

        if (!Files.exists(filePath)) {
            return null;
        }

        String json = Files.readString(
                filePath, StandardCharsets.UTF_8);

        try {
            double taxRate = gson.fromJson(json, Double.class);

            if (!Double.isFinite(taxRate)
                    || taxRate < 0
                    || taxRate > 100) {
                throw new IllegalArgumentException(
                        "Invalid tax rate.");
            }

            return new Tax(taxRate);

        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read tax.json.", e);
        }
    }
}
