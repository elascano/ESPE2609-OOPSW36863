package ec.edu.espe.chickenfarm.controller;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public class ChickenFileReader {

    // 1. Leer JSON con Java nativo (sin dependencias como Gson)
    public static List<Chicken> readFromJson(String filePath) {
        List<Chicken> chickens = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line.trim());
            }

            String content = jsonBuilder.toString();
            if (content.startsWith("[") && content.endsWith("]")) {
                content = content.substring(1, content.length() - 1);
            }

            String[] objects = content.split("\\},\\s*\\{");

            for (String obj : objects) {
                obj = obj.replace("{", "").replace("}", "").replaceAll("\"", "");
                String[] keyValues = obj.split(",");

                int id = 0;
                String name = "";
                String color = "";
                Date bornOnDate = new Date();
                boolean molting = false;

                for (String kv : keyValues) {
                    String[] pair = kv.split(":");
                    if (pair.length < 2) continue;

                    String key = pair[0].trim();
                    String value = pair[1].trim();

                    switch (key) {
                        case "id":
                            id = Integer.parseInt(value);
                            break;
                        case "name":
                            name = value;
                            break;
                        case "color":
                            color = value;
                            break;
                        case "bornOnDate":
                            bornOnDate = dateFormat.parse(value);
                            break;
                        case "molting":
                            molting = Boolean.parseBoolean(value);
                            break;
                    }
                }
                chickens.add(new Chicken(id, name, color, bornOnDate, molting));
            }
            System.out.println("JSON cargado exitosamente (" + chickens.size() + " gallinas)");
        } catch (Exception e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return chickens;
    }

    // 2. Leer CSV con Java nativo
    public static List<Chicken> readFromCsv(String filePath) {
        List<Chicken> chickens = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 6) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String color = data[2].trim();
                    Date bornOnDate = dateFormat.parse(data[3].trim());
                    boolean molting = Boolean.parseBoolean(data[5].trim());

                    chickens.add(new Chicken(id, name, color, bornOnDate, molting));
                }
            }
            System.out.println("CSV cargado exitosamente (" + chickens.size() + " gallinas)");
        } catch (Exception e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return chickens;
    }
}
