
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Product;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.IceCream;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Beverage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {

    private final Path filePath;

    public ProductFileManager() {
        filePath = Paths.get("data", "products.csv");
    }

    public void saveProducts(List<Product> products) {
        try {
            Files.createDirectories(filePath.getParent());

            List<String> lines = new ArrayList<>();
            lines.add("type;id;name;sellingPrice;cost;portion;extrasCost;flavour;size;temperature");

            for (Product product : products) {
                String type = "PRODUCT";
                String portion = "";
                String extrasCost = "";
                String flavour = "";
                String size = "";
                String temperature = "";

                if (product instanceof IceCream) {
                    IceCream iceCream = (IceCream) product;

                    type = "ICECREAM";
                    portion = String.valueOf(iceCream.getPortion());
                    extrasCost = String.valueOf(iceCream.getExtrasCost());
                    flavour = clean(iceCream.getFlavour());

                } else if (product instanceof Beverage) {
                    Beverage beverage = (Beverage) product;

                    type = "BEVERAGE";
                    size = String.valueOf(beverage.getSize());
                    temperature = String.valueOf(beverage.isTemperature());
                }

                lines.add(String.join(";",
                        type,
                        String.valueOf(product.getId()),
                        clean(product.getName()),
                        String.valueOf(product.getSellingPrice()),
                        String.valueOf(product.getCost()),
                        portion,
                        extrasCost,
                        flavour,
                        size,
                        temperature
                ));
            }

            Files.write(
                    filePath,
                    lines,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

            System.out.println("Productos guardados correctamente.");

        } catch (IOException e) {
            System.out.println(
                    "Error al guardar productos: " + e.getMessage());
        }
    }

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return products;
        }

        try {
            List<String> lines = Files.readAllLines(
                    filePath, StandardCharsets.UTF_8);

            for (int i = 1; i < lines.size(); i++) {
                String[] data = lines.get(i).split(";", -1);

                if (data.length != 10) {
                    System.out.println(
                            "Fila inválida en products.csv: " + (i + 1));
                    continue;
                }

                try {
                    String type = data[0];
                    int id = Integer.parseInt(data[1]);
                    String name = data[2];
                    float sellingPrice = Float.parseFloat(data[3]);
                    float cost = Float.parseFloat(data[4]);

                    switch (type) {
                        case "ICECREAM":
                            products.add(new IceCream(
                                    Integer.parseInt(data[5]),
                                    Float.parseFloat(data[6]),
                                    data[7],
                                    id,
                                    name,
                                    sellingPrice,
                                    cost
                            ));
                            break;

                        case "BEVERAGE":
                            products.add(new Beverage(
                                    data[8].charAt(0),
                                    Boolean.parseBoolean(data[9]),
                                    id,
                                    name,
                                    sellingPrice,
                                    cost
                            ));
                            break;

                        case "PRODUCT":
                            Product product = new Product();
                            product.setId(id);
                            product.setName(name);
                            product.setSellingPrice(sellingPrice);
                            product.setCost(cost);
                            products.add(product);
                            break;

                        default:
                            System.out.println(
                                    "Tipo desconocido en la fila " + (i + 1));
                            break;
                    }

                } catch (RuntimeException e) {
                    System.out.println(
                            "Error en la fila " + (i + 1)
                            + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Error al leer productos: " + e.getMessage());
        }

        return products;
    }

    private String clean(String value) {
        if (value == null) {
            return "";
        }

        return value.replace(";", " ")
                    .replace("\n", " ")
                    .replace("\r", " ");
    }
}
