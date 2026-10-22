package ec.edu.espe.chickenfarm.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.chickenfarm.model.Chicken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class JsonManager {
    
    private static final String FILE_PATH = "chickens.json";
    
    public static void saveChickens(Chicken[] chickens) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(chickens, writer);
            System.out.println("\n[OK] Data successfully saved in: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("\n[ERROR] The file could not be saved: " + e.getMessage());
        }
    }

  
    public static Chicken[] loadChickens() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Chicken[].class);
        } catch (IOException e) {
            System.out.println("\n[AVISO] No previous file was found, or an error occurred: " + e.getMessage());
            return new Chicken[10]; 
        }
    }
    
    
}
