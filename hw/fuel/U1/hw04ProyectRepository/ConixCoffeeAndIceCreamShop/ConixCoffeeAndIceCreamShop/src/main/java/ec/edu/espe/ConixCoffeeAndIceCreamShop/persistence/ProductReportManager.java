
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Product;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductReportManager {

    private final Path filePath;

    public ProductReportManager() {
        filePath = Paths.get("reports", "products_report.csv");
    }

    public void generateReport(List<Product> products)
            throws IOException {

        Files.createDirectories(filePath.getParent());

        List<String> lines = new ArrayList<>();

        lines.add("ID;Name;SellingPrice;Cost;Profit;ProfitMargin");

        for (Product product : products) {
            String name = clean(product.getName());

            lines.add(
                    product.getId() + ";"
                    + name + ";"
                    + product.getSellingPrice() + ";"
                    + product.getCost() + ";"
                    + product.calculateProfit() + ";"
                    + product.calculateProfitMargin()
            );
        }

        Files.write(
                filePath,
                lines,
                StandardCharsets.UTF_8
        );

        System.out.println(
                "Products report generated: "
                + filePath.toAbsolutePath());
    }

    private String clean(String value) {
        if (value == null) {
            return "";
        }

        return value.replace(";", ",")
                    .replace("\n", " ")
                    .replace("\r", " ");
    }
}
