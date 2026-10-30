package ec.edu.espe.chickenfarm.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {

    private static final String FILE_NAME = "chickens.json";

    // Guardar una lista de gallinas en el archivo JSON
    public static void saveChickenToJson(Chicken newChicken) {
        // 1. Leemos lo que ya existe en el archivo para no sobreescribirlo
        List<Chicken> chickens = readChickenJsonList();

        // 2. Agregamos la nueva gallina a la lista
        chickens.add(newChicken);

        // 3. Convertimos la lista a formato JSON con formato legible (Pretty Printing)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(chickens);

        // 4. Guardamos el texto en el archivo
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(jsonString);
            System.out.println("--> Gallina guardada en el archivo JSON exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo JSON: " + e.getMessage());
        }
    }

    // Leer la lista completa de gallinas desde el archivo JSON
    public static List<Chicken> readChickenJsonList() {
        Gson gson = new Gson();
        List<Chicken> chickens = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            Type listType = new TypeToken<ArrayList<Chicken>>() {}.getType();
            chickens = gson.fromJson(reader, listType);
            if (chickens == null) {
                chickens = new ArrayList<>();
            }
        } catch (IOException e) {
            // Si el archivo no existe aún, retorna una lista vacía sin problemas
        }
        return chickens;
    }

    // Método para mostrar las gallinas del JSON en consola
    public static void readChickenJSON() {
        List<Chicken> chickens = readChickenJsonList();
        System.out.println("\n--- CONTENIDO DEL ARCHIVO JSON ---");
        if (chickens.isEmpty()) {
            System.out.println("El archivo JSON está vacío o no existe.");
        } else {
            for (Chicken chicken : chickens) {
                System.out.println("Gallina --> " + chicken);
            }
        }
        System.out.println("----------------------------------");
    }
}