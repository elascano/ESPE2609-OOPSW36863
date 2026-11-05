
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Customer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerReportManager {

    private final Path filePath;

    public CustomerReportManager() {
        filePath = Paths.get("reports", "customers_report.csv");
    }

    public void generateReport(List<Customer> customers)
            throws IOException {

        Files.createDirectories(filePath.getParent());

        List<String> lines = new ArrayList<>();

        lines.add("Name;Phone;Email");

        for (Customer customer : customers) {
            lines.add(
                    clean(customer.getName()) + ";"
                    + clean(customer.getPhone()) + ";"
                    + clean(customer.getEmail())
            );
        }

        Files.write(
                filePath,
                lines,
                StandardCharsets.UTF_8
        );

        System.out.println(
                "Customers report generated: "
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
