package ec.edu.espe.chickenfarm.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */

public class ChickenFarmJsonController {
 
    public void saveToJson(ChickenFarmer chickenFarmer, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(chickenFarmer);
        System.out.println("JSON -->\n" + json);
 
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
            System.out.println("Archivo " + fileName + " guardado correctamente");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }
 
    public ChickenFarmer loadFromJson(String fileName) {
        Gson gson = new Gson();
        ChickenFarmer chickenFarmer = null;
 
        try (FileReader reader = new FileReader(fileName)) {
            chickenFarmer = gson.fromJson(reader, ChickenFarmer.class);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
 
        return chickenFarmer;
    }
}