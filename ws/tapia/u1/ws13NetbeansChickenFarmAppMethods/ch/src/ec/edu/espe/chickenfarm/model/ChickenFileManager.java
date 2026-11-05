package ec.edu.espe.chickenfarm.model;

import java.io.FileWriter;
import java.io.IOException;

public class ChickenFileManager {

    public static void saveAsCSV(Chicken[] chickens) {

        try (FileWriter writer = new FileWriter("chickens.csv")) {

            writer.write("ID,Name,Color,Molting\n");

            for (Chicken chicken : chickens) {

                if (chicken != null) {

                    writer.write(
                            chicken.getId() + ","
                                    + chicken.getName() + ","
                                    + chicken.getColor() + ","
                                    + chicken.isMolting()
                                    + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error writing CSV file");
        }
    }

    public static void saveAsJSON(Chicken[] chickens) {

        try (FileWriter writer = new FileWriter("chickens.json")) {

            writer.write("[\n");

            boolean first = true;

            for (Chicken chicken : chickens) {

                if (chicken != null) {

                    if (!first) {
                        writer.write(",\n");
                    }

                    writer.write(
                            "  {\n"
                                    + "    \"id\": " + chicken.getId() + ",\n"
                                    + "    \"name\": \"" + chicken.getName() + "\",\n"
                                    + "    \"color\": \"" + chicken.getColor() + "\",\n"
                                    + "    \"molting\": " + chicken.isMolting() + "\n"
                                    + "  }"
                    );

                    first = false;
                }
            }

            writer.write("\n]");

        } catch (IOException e) {
            System.out.println("Error writing JSON file");
        }
    }
}