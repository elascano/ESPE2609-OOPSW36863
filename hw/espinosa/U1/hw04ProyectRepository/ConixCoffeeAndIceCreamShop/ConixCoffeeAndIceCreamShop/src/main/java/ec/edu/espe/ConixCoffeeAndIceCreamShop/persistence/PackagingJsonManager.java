
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Packaging;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PackagingJsonManager {

    private final Path filePath;
    private final Gson gson;

    public PackagingJsonManager() {
        filePath = Paths.get("data", "packaging.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void savePackaging(Packaging packaging)
            throws IOException {

        if (packaging == null) {
            throw new IllegalArgumentException(
                    "Packaging cannot be null.");
        }

        PackagingData data = new PackagingData();
        data.packagingType = packaging.getPackagingType();
        data.unitCost = packaging.getUnitCost();
        data.quantity = packaging.getQuantity();

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(data),
                StandardCharsets.UTF_8
        );
    }

    public Packaging loadPackaging() throws IOException {

        if (!Files.exists(filePath)) {
            return null;
        }

        String json = Files.readString(
                filePath, StandardCharsets.UTF_8);

        try {
            PackagingData data =
                    gson.fromJson(json, PackagingData.class);

            if (data == null) {
                throw new IllegalArgumentException(
                        "Packaging data is empty.");
            }

            return new Packaging(
                    data.packagingType,
                    data.unitCost,
                    data.quantity
            );

        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read packaging.json.", e);
        }
    }

    private class PackagingData {
        private String packagingType;
        private double unitCost;
        private int quantity;
    }
}
