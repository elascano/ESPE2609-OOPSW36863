package ec.edu.espe.chickenfarm.controller;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class ChickenFarmCsvController{
 
    private static final String SEPARATOR = ";";
    private static final String HEADER =
            "farmerId;farmerName;coopId;chickenId;name;color;bornOnDate;molting";
 
    public void saveToCsv(ChickenFarmer chickenFarmer, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(HEADER);
 
            for (ChickenCoop coop : chickenFarmer.getCoops()) {
                if (coop == null) {
                    continue;
                }
                for (Chicken chicken : coop.getChickens()) {
                    if (chicken == null) {
                        continue;
                    }
                    writer.println(chickenFarmer.getChickenFarmerId() + SEPARATOR
                            + chickenFarmer.getName() + SEPARATOR
                            + coop.getChickenCoopId() + SEPARATOR
                            + chicken.getId() + SEPARATOR
                            + chicken.getName() + SEPARATOR
                            + chicken.getColor() + SEPARATOR
                            + chicken.getBornOnDate().getTime() + SEPARATOR
                            + chicken.isMolting());
                }
            }
            System.out.println("Archivo " + fileName + " guardado correctamente");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }
 
    public ChickenFarmer loadFromCsv(String fileName) {
        ChickenFarmer chickenFarmer = null;
 
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
 
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(SEPARATOR);
 
                int farmerId = Integer.parseInt(data[0]);
                String farmerName = data[1];
                int coopId = Integer.parseInt(data[2]);
                int chickenId = Integer.parseInt(data[3]);
                String name = data[4];
                String color = data[5];
                Date bornOnDate = new Date(Long.parseLong(data[6]));
                boolean molting = Boolean.parseBoolean(data[7]);
 
                if (chickenFarmer == null) {
                    chickenFarmer = new ChickenFarmer(farmerId, farmerName, new ChickenCoop[10]);
                }
 
                ChickenCoop coop = null;
                for (ChickenCoop existingCoop : chickenFarmer.getCoops()) {
                    if (existingCoop != null && existingCoop.getChickenCoopId() == coopId) {
                        coop = existingCoop;
                        break;
                    }
                }
                if (coop == null) {
                    coop = new ChickenCoop(coopId, new Chicken[10]);
                    chickenFarmer.add(coop);
                }
 
                coop.add(new Chicken(chickenId, name, color, bornOnDate, molting));
            }
 
            if (chickenFarmer != null) {
                chickenFarmer.resetIteration();
                for (ChickenCoop coop : chickenFarmer.getCoops()) {
                    if (coop != null) {
                        coop.resetIteration();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("El archivo CSV tiene un formato incorrecto: " + e.getMessage());
        }
 
        return chickenFarmer;
    }
}
