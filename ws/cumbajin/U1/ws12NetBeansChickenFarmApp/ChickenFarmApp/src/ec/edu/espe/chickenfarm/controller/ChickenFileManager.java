
package ec.edu.espe.chickenfarm.controller;

import com.google.gson.Gson;
import ec.edu.espe.chickenfarm.model.Chicken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class ChickenFileManager {

    
    public static void saveJSON(Chicken[] chickens) throws IOException {
        Gson gson = new Gson();

        FileWriter file = new FileWriter("chickens.json");
        gson.toJson(chickens, file);
        file.close();

        System.out.println("Chickens saved in JSON successfully!");
    }

    
    public static Chicken[] readJSON() throws IOException {
        Gson gson = new Gson();

        FileReader file = new FileReader("chickens.json");
        Chicken[] chickens = gson.fromJson(file, Chicken[].class);
        file.close();

        return chickens;
    }

    
    public static void saveCSV(Chicken[] chickens) throws IOException {
        FileWriter file = new FileWriter("chickens.csv");

        file.write("id,name,color,bornOnDate,ageInYears,molting\n");

        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] != null) {
                Chicken chicken = chickens[i];

                file.write(chicken.getId() + ","
                        + chicken.getName() + ","
                        + chicken.getColor() + ","
                        + chicken.getBornOnDate().getTime() + ","
                        + chicken.getAgeInYears() + ","
                        + chicken.isMolting() + "\n");
            }
        }

        file.close();

        System.out.println("Chickens saved in CSV successfully!");
    }

    public static Chicken[] readCSV() throws IOException {
        Chicken[] chickens = new Chicken[10];

        FileReader file = new FileReader("chickens.csv");
        Scanner scanner = new Scanner(file);

        scanner.nextLine();

        int i = 0;

        while (scanner.hasNextLine() && i < chickens.length) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            String color = data[2];
            Date bornOnDate = new Date(Long.parseLong(data[3]));
            int age = Integer.parseInt(data[4]);
            boolean molting = Boolean.parseBoolean(data[5]);

            chickens[i] = new Chicken(id, name, color, bornOnDate, molting);

            chickens[i].setAgeInYears(age);

            i++;
        }

        scanner.close();

        return chickens;
    }
}
