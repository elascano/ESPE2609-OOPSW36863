
package ec.edu.espe.chickenfarm.controller;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ChickenCsvRepository {
        private final Path filePath = Path.of("data", "chickens.csv");

    public void save(Chicken[] chickens) throws IOException {
        Files.createDirectories(filePath.getParent());

        StringBuilder csv = new StringBuilder("\uFEFF");

        csv.append("idChicken;name;color;bornOnDate;ageInYears;molting\n");

        if (chickens != null) {
            for (Chicken chicken : chickens) {
                if (chicken == null) {
                    continue;
                }

                csv.append(chicken.getIdChicken()).append(';');
                csv.append(escapeCsv(chicken.getName())).append(';');
                csv.append(escapeCsv(chicken.getColor())).append(';');
                csv.append(chicken.getBornOnDate()).append(';');
                csv.append(chicken.getAgeInYears()).append(';');
                csv.append(chicken.isMolting()).append('\n');
            }
        }

        Files.writeString(filePath, csv.toString(),
                StandardCharsets.UTF_8);
    }

    private String escapeCsv(String value) {
        if (value == null) {
            return "";
        }

        if (value.contains(";")
                || value.contains("\"")
                || value.contains("\n")
                || value.contains("\r")) {

            return "\"" + value.replace("\"", "\"\"") + "\"";
        }

        return value;
    }
}
