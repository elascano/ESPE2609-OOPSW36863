package ec.edu.espe.chickenfarm.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVManager {

    private static final String FILE_NAME = "chickens.csv";

    // Guardar una gallina en formato CSV (añade al final del archivo)
    public static void saveChickenToCSV(Chicken chicken) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            // Formato de línea CSV: id,name,color,age,molting
            writer.append(String.valueOf(chicken.getId()))
                  .append(",")
                  .append(chicken.getName())
                  .append(",")
                  .append(chicken.getColor())
                  .append(",")
                  .append(String.valueOf(chicken.getAge()))
                  .append(",")
                  .append(String.valueOf(chicken.isMolting()))
                  .append("\n");
            
            System.out.println("--> Gallina guardada en el archivo CSV exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo CSV: " + e.getMessage());
        }
    }

    // Leer y mostrar los datos del archivo CSV
    public static void readChickenCSV() {
        System.out.println("\n--- CONTENIDO DEL ARCHIVO CSV ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean hasContent = false;
            while ((line = reader.readLine()) != null) {
                hasContent = true;
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    System.out.println("ID: " + parts[0] + 
                                       " | Nombre: " + parts[1] + 
                                       " | Color: " + parts[2] + 
                                       " | Edad: " + parts[3] + 
                                       " | Molting: " + parts[4]);
                }
            }
            if (!hasContent) {
                System.out.println("El archivo CSV está vacío.");
            }
        } catch (IOException e) {
            System.out.println("No se encontró el archivo CSV o aún no hay datos guardados.");
        }
        System.out.println("----------------------------------");
    }
}