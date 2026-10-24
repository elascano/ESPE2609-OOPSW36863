package ec.edu.espe.chickenfarm.controller;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class CsvManager {
    private static final String FILE_PATH = "chickens.csv";

    public static void saveChickens(Chicken[] chickens) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            

            writer.println("id,name,color,bornOnDate,ageInYears,molting");


            if (chickens != null) {
                for (Chicken c : chickens) {
                    if (c != null) {

                        writer.println(c.getId() + "," + 
                                       c.getName() + "," + 
                                       c.getColor() + "," + 
                                       c.getBornOnDate() + "," + 
                                       c.getAgeInYears() + "," + 
                                       c.isMolting());
                    }
                }
            }
            System.out.println("[OK] Data successfully saved in: " + FILE_PATH);
            
        } catch (IOException e) {
            System.out.println(" Could not save the CSV file: " + e.getMessage());
        }
    }
}