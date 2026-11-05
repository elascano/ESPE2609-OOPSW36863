
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Beverage;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.IceCream;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Product;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductJsonManager {

    private final Path filePath;
    private final Gson gson;

    public ProductJsonManager() {
        filePath = Paths.get("data", "products.json");

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void saveProducts(List<Product> products)
            throws IOException {

        if (products == null) {
            throw new IllegalArgumentException(
                    "Products list cannot be null.");
        }

        JsonArray jsonProducts = new JsonArray();

        for (Product product : products) {

            if (product == null) {
                continue;
            }

            JsonObject jsonProduct = new JsonObject();

            if (product instanceof IceCream) {
                IceCream iceCream = (IceCream) product;

                jsonProduct.addProperty("type", "ICECREAM");
                jsonProduct.addProperty(
                        "portion", iceCream.getPortion());
                jsonProduct.addProperty(
                        "extrasCost", iceCream.getExtrasCost());
                jsonProduct.addProperty(
                        "flavour", iceCream.getFlavour());

            } else if (product instanceof Beverage) {
                Beverage beverage = (Beverage) product;

                jsonProduct.addProperty("type", "BEVERAGE");
                jsonProduct.addProperty(
                        "size", String.valueOf(beverage.getSize()));
                jsonProduct.addProperty(
                        "temperature", beverage.isTemperature());

            } else {
                jsonProduct.addProperty("type", "PRODUCT");
            }

            jsonProduct.addProperty("id", product.getId());
            jsonProduct.addProperty("name", product.getName());
            jsonProduct.addProperty(
                    "sellingPrice", product.getSellingPrice());
            jsonProduct.addProperty("cost", product.getCost());

            jsonProducts.add(jsonProduct);
        }

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(jsonProducts),
                StandardCharsets.UTF_8
        );
    }

    public List<Product> loadProducts() throws IOException {

        List<Product> products = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return products;
        }

        String json = Files.readString(
                filePath,
                StandardCharsets.UTF_8
        );

        JsonElement root;

        try {
            root = JsonParser.parseString(json);
        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read products.json: invalid JSON.", e);
        }

        if (!root.isJsonArray()) {
            throw new IOException(
                    "Invalid products.json: expected a JSON array.");
        }

        JsonArray jsonProducts = root.getAsJsonArray();

        for (JsonElement element : jsonProducts) {

            if (!element.isJsonObject()) {
                throw new IOException(
                        "Invalid product entry in products.json.");
            }

            JsonObject item = element.getAsJsonObject();

            try {
                String type = item.get("type").getAsString();
                int id = item.get("id").getAsInt();
                String name = item.get("name").getAsString();
                float sellingPrice =
                        item.get("sellingPrice").getAsFloat();
                float cost = item.get("cost").getAsFloat();

                switch (type) {

                    case "ICECREAM":
                        products.add(new IceCream(
                                item.get("portion").getAsInt(),
                                item.get("extrasCost").getAsFloat(),
                                getString(item, "flavour"),
                                id,
                                name,
                                sellingPrice,
                                cost
                        ));
                        break;

                    case "BEVERAGE":
                        String size = item.get("size").getAsString();

                        if (size.isEmpty()) {
                            throw new IllegalArgumentException(
                                    "Beverage size cannot be empty.");
                        }

                        products.add(new Beverage(
                                size.charAt(0),
                                item.get("temperature").getAsBoolean(),
                                id,
                                name,
                                sellingPrice,
                                cost
                        ));
                        break;

                    case "PRODUCT":
                        products.add(new Product(
                                id, name, sellingPrice, cost));
                        break;

                    default:
                        throw new IllegalArgumentException(
                                "Unknown product type: " + type);
                }

            } catch (RuntimeException e) {
                throw new IOException(
                        "Invalid product entry in products.json.", e);
            }
        }

        return products;
    }

    private String getString(
            JsonObject object, String property) {

        JsonElement value = object.get(property);

        if (value == null || value.isJsonNull()) {
            return null;
        }

        return value.getAsString();
    }
}
