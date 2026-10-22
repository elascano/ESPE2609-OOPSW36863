package ec.edu.espe.chickenfarmapp.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.Strictness;
import ec.edu.espe.chickenfarmapp.model.Chicken;
import ec.edu.espe.chickenfarmapp.model.ChickenCoop;
import ec.edu.espe.chickenfarmapp.model.Egg;
import ec.edu.espe.chickenfarmapp.model.Poop;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


/**
 *
 * @author Anthony Arevalo, MosQ, @ESPE
 */
public class ChickenFarmApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ChickenCoop coop = new ChickenCoop(1);
        Path jsonFile = Paths.get("chickens.json").toAbsolutePath();
        Path csvFile = Paths.get("chickens.csv").toAbsolutePath();
        Path sourceFile = Files.exists(jsonFile) ? jsonFile : csvFile;
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setStrictness(Strictness.STRICT)
            .create();

        if (Files.exists(sourceFile)) {
            try {
                JsonArray savedChickens;
                if (sourceFile.equals(jsonFile)) {
                    savedChickens = gson.fromJson(
                        Files.readString(jsonFile, StandardCharsets.UTF_8), JsonArray.class
                    );
                } else {
                    String csvText = Files.readString(csvFile, StandardCharsets.UTF_8);
                    if (csvText.startsWith("\uFEFF")) {
                        csvText = csvText.substring(1);
                    }
                    List<List<String>> rows = new ArrayList<>();
                    List<String> row = new ArrayList<>();
                    StringBuilder field = new StringBuilder();
                    boolean insideQuotes = false;
                    boolean closedQuotes = false;

                    for (int i = 0; i < csvText.length(); i++) {
                        char character = csvText.charAt(i);
                        if (insideQuotes) {
                            if (character == '"') {
                                if (i + 1 < csvText.length() && csvText.charAt(i + 1) == '"') {
                                    field.append('"');
                                    i++;
                                } else {
                                    insideQuotes = false;
                                    closedQuotes = true;
                                }
                            } else {
                                field.append(character);
                            }
                        } else if (character == ',' || character == '\n' || character == '\r') {
                            row.add(field.toString());
                            field.setLength(0);
                            closedQuotes = false;
                            if (character != ',') {
                                rows.add(row);
                                row = new ArrayList<>();
                                if (character == '\r' && i + 1 < csvText.length()
                                        && csvText.charAt(i + 1) == '\n') {
                                    i++;
                                }
                            }
                        } else if (closedQuotes) {
                            throw new IllegalArgumentException("Unexpected text after CSV quotes.");
                        } else if (character == '"') {
                            if (field.length() != 0) {
                                throw new IllegalArgumentException("Invalid quote in CSV field.");
                            }
                            insideQuotes = true;
                        } else {
                            field.append(character);
                        }
                    }
                    if (insideQuotes) {
                        throw new IllegalArgumentException("Unclosed quotes in CSV.");
                    }
                    if (closedQuotes || field.length() > 0 || !row.isEmpty()) {
                        row.add(field.toString());
                        rows.add(row);
                    }
                    if (rows.isEmpty() || !rows.get(0).equals(
                            List.of("id", "name", "color", "bornOnDate", "molting"))) {
                        throw new IllegalArgumentException("Invalid CSV header.");
                    }
                    savedChickens = new JsonArray();
                    for (int i = 1; i < rows.size(); i++) {
                        List<String> values = rows.get(i);
                        if (values.size() != 5) {
                            throw new IllegalArgumentException("CSV record must have 5 fields: " + (i + 1));
                        }
                        String molting = values.get(4);
                        if (!molting.equals("true") && !molting.equals("false")) {
                            throw new IllegalArgumentException("CSV molting must be true or false.");
                        }
                        JsonObject data = new JsonObject();
                        data.addProperty("id", Integer.parseInt(values.get(0)));
                        data.addProperty("name", values.get(1));
                        data.addProperty("color", values.get(2));
                        data.addProperty("bornOnDate", values.get(3));
                        data.addProperty("molting", Boolean.parseBoolean(molting));
                        savedChickens.add(data);
                    }
                }
                if (savedChickens == null) {
                    throw new IllegalArgumentException("Expected a JSON array.");
                }

                for (JsonElement element : savedChickens) {
                    JsonObject data = element.getAsJsonObject();
                    String[] fields = {"id", "name", "color", "bornOnDate", "molting"};
                    for (String field : fields) {
                        if (!data.has(field) || !data.get(field).isJsonPrimitive()) {
                            throw new IllegalArgumentException("Invalid field: " + field);
                        }
                    }
                    if (!data.getAsJsonPrimitive("id").isNumber()
                            || !data.getAsJsonPrimitive("name").isString()
                            || !data.getAsJsonPrimitive("color").isString()
                            || !data.getAsJsonPrimitive("bornOnDate").isString()
                            || !data.getAsJsonPrimitive("molting").isBoolean()) {
                        throw new IllegalArgumentException("Invalid chicken field types.");
                    }

                    int id = Integer.parseInt(data.get("id").getAsString());
                    String name = data.get("name").getAsString();
                    String color = data.get("color").getAsString();
                    LocalDate birthDate = LocalDate.parse(data.get("bornOnDate").getAsString());
                    if (id <= 0 || name.trim().isEmpty() || color.trim().isEmpty()
                            || birthDate.isAfter(LocalDate.now())) {
                        throw new IllegalArgumentException("Invalid chicken data.");
                    }

                    Chicken chicken = new Chicken(
                        id, name, color, toDate(birthDate), data.get("molting").getAsBoolean()
                    );
                    chicken.setAgeInYears();
                    coop.add(chicken);
                }
                showMessage("Chickens loaded: " + savedChickens.size());
                showMessage("Loaded from: " + sourceFile);
            } catch (IOException | JsonParseException | IllegalArgumentException
                    | IllegalStateException | DateTimeParseException e) {
                showMessage("Could not load " + sourceFile + ": " + e.getMessage());
                showMessage("Program stopped to protect the saved data.");
                return;
            }
        }
        showMessage("Data file: " + jsonFile);
        showMessage("CSV file: " + csvFile);
        boolean isRunning = true;
        boolean synchronizeOnStartup = true;

        while (isRunning) {
            Chicken[] previousChickens = coop.getChickens().clone();
            boolean chickensChanged = synchronizeOnStartup;
            synchronizeOnStartup = false;
            int option = 0;

            if (!chickensChanged) {
                showMenu();
                option = readInteger("Choose an option: ", 1, 7);
                switch (option) {
                case 1:
                    chickensChanged = addChicken(coop);
                    break;

                case 2:
                    chickensChanged = removeChicken(coop);
                    break;

                case 3:
                    coop.resetIteration();
                    showMessage("Chicken iteration reset.");
                    break;

                case 4:
                    coop.next();
                    break;

                case 5:
                    showChickenCountAndList(coop);
                    break;

                case 6:
                    saveToCSV(coop);
                    break;

                case 7:
                    showMessage("Program ended.");
                    isRunning = false;
                    break;

                default:
                    showMessage("Invalid option.");
                }
            }

            if (chickensChanged) {
                Path temporaryFile = null;
                Path temporaryCsvFile = null;
                boolean jsonSaved = false;
                try {
                    JsonArray savedChickens = new JsonArray();
                    StringBuilder csv = new StringBuilder("id,name,color,bornOnDate,molting\r\n");
                    for (Chicken chicken : coop.getChickens()) {
                        if (chicken != null) {
                            String birthDate = chicken.getBornOnDate().toInstant()
                                .atZone(ZoneId.systemDefault()).toLocalDate().toString();
                            JsonObject data = new JsonObject();
                            data.addProperty("id", chicken.getId());
                            data.addProperty("name", chicken.getName());
                            data.addProperty("color", chicken.getColor());
                            data.addProperty("bornOnDate", birthDate);
                            data.addProperty("molting", chicken.isMolting());
                            savedChickens.add(data);

                            String[] values = {String.valueOf(chicken.getId()), chicken.getName(),
                                chicken.getColor(), birthDate, String.valueOf(chicken.isMolting())};
                            for (int i = 0; i < values.length; i++) {
                                if (i > 0) {
                                    csv.append(',');
                                }
                                csv.append('"').append(values[i].replace("\"", "\"\"")).append('"');
                            }
                            csv.append("\r\n");
                        }
                    }

                    temporaryFile = Files.createTempFile(jsonFile.getParent(), "chickens-", ".tmp");
                    temporaryCsvFile = Files.createTempFile(csvFile.getParent(), "chickens-csv-", ".tmp");
                    Files.writeString(temporaryFile, gson.toJson(savedChickens), StandardCharsets.UTF_8);
                    Files.writeString(temporaryCsvFile, csv, StandardCharsets.UTF_8);
                    try {
                        Files.move(temporaryFile, jsonFile,
                            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
                    } catch (AtomicMoveNotSupportedException e) {
                        Files.move(temporaryFile, jsonFile, StandardCopyOption.REPLACE_EXISTING);
                    }
                    jsonSaved = true;
                    try {
                        Files.move(temporaryCsvFile, csvFile,
                            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
                    } catch (AtomicMoveNotSupportedException e) {
                        Files.move(temporaryCsvFile, csvFile, StandardCopyOption.REPLACE_EXISTING);
                    }
                    if (option == 1) {
                        showMessage("Chicken added and saved.");
                    } else if (option == 2) {
                        showMessage("Chicken removed and saved.");
                    }
                    showMessage("Data saved in JSON and CSV.");
                } catch (IOException e) {
                    if (jsonSaved) {
                        showMessage("Data saved in JSON, but CSV could not be updated: " + e.getMessage());
                    } else {
                        coop.setChickens(previousChickens);
                        coop.resetIteration();
                        showMessage("Change cancelled. Could not save chickens: " + e.getMessage());
                        if (option == 0) {
                            return;
                        }
                    }
                } finally {
                    for (Path temporary : new Path[] {temporaryFile, temporaryCsvFile}) {
                        if (temporary != null) {
                            try {
                                Files.deleteIfExists(temporary);
                            } catch (IOException e) {
                                showMessage("Could not remove temporary file: " + temporary);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Anthony Arevalo's Chicken Farm App ---");
        System.out.println("1. Add chicken");
        System.out.println("2. Remove chicken");
        System.out.println("3. Reset chicken iteration");
        System.out.println("4. Next chicken");
        System.out.println("5. Show chicken count and list");
        System.out.println("6. Save to CSV manually");
        System.out.println("7. Exit");
    }

    private static boolean addChicken(ChickenCoop coop) {
        try {
            int chickenId = readInteger(
                "Chicken ID: ", 1, Integer.MAX_VALUE
            );
            String name = readNonEmptyText("Name: ");
            String color = readNonEmptyText("Color: ");
            LocalDate birthDate = readBirthDate();
            boolean molting = readBoolean(
                "Is the chicken molting? (y/n): "
            );

            Chicken chicken = new Chicken(
                chickenId,
                name,
                color,
                toDate(birthDate),
                molting
            );

            chicken.setAgeInYears();
            coop.add(chicken);
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            showMessage("Error: " + e.getMessage());
            return false;
        }
    }

    private static boolean removeChicken(ChickenCoop coop) {
        int chickenId = readInteger(
            "Chicken ID to remove: ", 1, Integer.MAX_VALUE
        );

        try {
            coop.remove(chickenId);
            return true;
        } catch (IllegalArgumentException e) {
            showMessage("Error: " + e.getMessage());
            return false;
        }
    }

    private static void showChickenCountAndList(ChickenCoop coop) {
        Chicken[] chickens = coop.getChickens();
        int chickenCount = 0;

        for (Chicken chicken : chickens) {
            if (chicken != null) {
                chickenCount++;
            }
        }

        showMessage("Number of chickens in the coop: " + chickenCount);

        if (chickenCount == 0) {
            showMessage("The coop is empty.");
            return;
        }

        coop.resetIteration();

        for (int i = 0; i < chickenCount; i++) {
            coop.next();
        }
    }

    private static int readInteger(
            String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int number = Integer.parseInt(input);

                if (number >= minimum && number <= maximum) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }

            showMessage(
                "Enter a number between " + minimum + " and " + maximum + "."
            );
        }
    }

    private static String readNonEmptyText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            showMessage("This field cannot be empty.");
        }
    }

    private static LocalDate readBirthDate() {
        while (true) {
            String input = readNonEmptyText(
                "Date of birth (YYYY-MM-DD): "
            );

            try {
                LocalDate birthDate = LocalDate.parse(input);

                if (!birthDate.isAfter(LocalDate.now())) {
                    return birthDate;
                }

                showMessage("The date cannot be in the future.");
            } catch (DateTimeParseException e) {
                showMessage(
                    "Use YYYY-MM-DD format, for example 2020-03-15."
                );
            }
        }
    }

    private static boolean readBoolean(String prompt) {
        while (true) {
            String input = readNonEmptyText(prompt)
                .toLowerCase(Locale.ROOT);

            if (input.equals("y") || input.equals("yes")) {
                return true;
            }

            if (input.equals("n") || input.equals("no")) {
                return false;
            }

            showMessage("Enter y or n.");
        }
    }

    private static Date toDate(LocalDate date) {
        return Date.from(
            date.atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
    }

    private static void showMessage(String message) {
        System.out.println(message);
    }

    public static void saveToCSV(ChickenCoop coop) {
        Path csvFile = Paths.get("chickens.csv").toAbsolutePath();
        try {
            StringBuilder csv = new StringBuilder("id,name,color,bornOnDate,molting\r\n");
            
            for (Chicken chicken : coop.getChickens()) {
                if (chicken != null) {
                    String birthDate = chicken.getBornOnDate().toInstant()
                        .atZone(ZoneId.systemDefault()).toLocalDate().toString();
                    
                    csv.append(chicken.getId()).append(",")
                       .append(chicken.getName()).append(",")
                       .append(chicken.getColor()).append(",")
                       .append(birthDate).append(",")
                       .append(chicken.isMolting()).append("\r\n");
                }
            }
            
            Files.writeString(csvFile, csv, StandardCharsets.UTF_8);
            showMessage("Tabla CSV exportada y guardada correctamente.");
            
        } catch (IOException e) {
            showMessage("Error al exportar el archivo CSV: " + e.getMessage());
        }
    }
}