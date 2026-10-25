
package ec.edu.espe.chickenfarm.controller;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ChickenJsonRepository {

    private final Path filePath = Path.of("data", "chickens.json");

    public void save(Chicken[] chickens) throws IOException {
        createDirectory();
        String json = convertToJson(chickens);
        writeFile(json);
    }
    private void createDirectory() throws IOException {
        Files.createDirectories(filePath.getParent());
    }
    private String convertToJson(Chicken[] chickens) {

        StringBuilder json = new StringBuilder();
        json.append("[\n");
        boolean first = true;
        if (chickens != null) {
            for (Chicken chicken : chickens) {
                if (chicken == null) {
                    continue;
                }
                if (!first) {
                    json.append(",\n");
                }
                json.append(convertChickenToJson(chicken));
                first = false;
            }
        }

        json.append("\n]");
        return json.toString();
    }  
    
    private String convertChickenToJson(Chicken chicken) {
        StringBuilder json = new StringBuilder();

        json.append("    {\n");
        json.append("        \"idChicken\": ").append(chicken.getIdChicken()).append(",\n");
        json.append("        \"name\": \"").append(escapeJson(chicken.getName())).append("\",\n");
        json.append("        \"color\": \"").append(escapeJson(chicken.getColor())).append("\",\n");
        json.append("        \"bornOnDate\": ").append(formatDate(chicken.getBornOnDate())).append(",\n");
        json.append("        \"ageInYears\": ").append(chicken.getAgeInYears()).append(",\n");        
        json.append("        \"molting\": ").append(chicken.isMolting()).append("\n");        
        json.append("    }");
        return json.toString();   
    }
    private String formatDate(LocalDate date) {
        if (date == null) {
            return "null";
        }

        return "\"" + date.toString() + "\"";
    }
    
    private void writeFile(String json) throws IOException {
        Files.writeString(filePath,json,StandardCharsets.UTF_8); 
    }
    private String escapeJson(String text) {

        if (text == null) {
            return "";
        }

        StringBuilder escaped = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            
            char character = text.charAt(i);
            
            switch (character) {
                
                case '"' -> escaped.append("\\\"");
                case '\\' -> escaped.append("\\\\");
                case '\n' -> escaped.append("\\n");
                case '\r' -> escaped.append("\\r");
                case '\t' -> escaped.append("\\t");
                case '\b' -> escaped.append("\\b");
                case '\f' -> escaped.append("\\f");
                
                default -> {
                    
                    if (character < 0x20) {
                        escaped.append(String.format("\\u%04x", (int) character));
                    } else {
                        escaped.append(character);
                    }
                }
            }
        }

        return escaped.toString();
    }
    public Chicken[] load() throws IOException {

        if (!Files.exists(filePath)) {
            return new Chicken[0];
        }

        String json = Files.readString(filePath, StandardCharsets.UTF_8).trim();

        if (json.isEmpty() || json.equals("[]")) {
            return new Chicken[0];
        }

        if (!json.startsWith("[") || !json.endsWith("]")) {
            throw new IOException("El archivo JSON no tiene un formato válido.");
        }

        int count = countChickens(json);
        Chicken[] chickens = new Chicken[count];
        int position = 0;
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) != '{') {
                continue;
            }

            int end = json.indexOf('}', i);

            if (end == -1) {
                throw new IOException("Registro de gallina incompleto.");
            }

            String object = json.substring(i, end + 1);

            int idChicken = Integer.parseInt(getValue(object, "idChicken")
            );

            String name = decodeValue(getValue(object, "name")
            );

            String color = decodeValue(getValue(object, "color"));

            String dateValue = getValue(object, "bornOnDate");
            LocalDate bornOnDate = null;

            if (!dateValue.equals("null")) {
                bornOnDate = LocalDate.parse(decodeValue(dateValue));
            }
            boolean molting = Boolean.parseBoolean(getValue(object, "molting")
            );

            Chicken chicken = new Chicken(name, color, bornOnDate, molting);
            chicken.setIdChicken(idChicken);
            chickens[position] = chicken;
            position++;
            i = end;
        }
        return chickens;
    }
    
    private int countChickens(String json) {
        int count = 0;
        
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) == '{') {
                count++;
            }
        }
        return count;
    }

    
    private String getValue(String object, String field) throws IOException {

        String key = "\"" + field + "\"";
        int position = object.indexOf(key);

        if (position == -1) {
            throw new IOException("Field not found: " + field);
        }


        position = object.indexOf(':', position + key.length());

        if (position == -1) {
            throw new IOException("Invalid JSON field: " + field);
        }

        position++;


        while (position < object.length()
                && Character.isWhitespace(object.charAt(position))) {
            position++;
        }

        if (position >= object.length()) {
            throw new IOException("The field value is missing: " + field);
        }

        if (object.charAt(position) == '"') {

            int end = position + 1;

            while (end < object.length()) {

                if (object.charAt(end) == '\\') {
                    end += 2;
                    continue;
                }

                if (object.charAt(end) == '"') {
                    return object.substring(position, end + 1);
                }

                end++;
            }

            throw new IOException("Incomplete string: " + field);
        }

        int end = position;

        while (end < object.length()
                && object.charAt(end) != ','
                && object.charAt(end) != '}') {
            end++;
        }

        return object.substring(position, end).trim();
    }


    private String decodeValue(String value) throws IOException {

    if (value == null || value.equals("null")) {
        return null;
    }

    if (value.length() < 2
            || value.charAt(0) != '"'
            || value.charAt(value.length() - 1) != '"') {
        throw new IOException("The value is not a valid JSON string.");
    }

    StringBuilder result = new StringBuilder();

    for (int i = 1; i < value.length() - 1; i++) {

        char character = value.charAt(i);

        if (character != '\\') {
            result.append(character);
            continue;
        }

        i++;

        if (i >= value.length() - 1) {
            throw new IOException("Incomplete escape sequence.");
        }

        char escaped = value.charAt(i);

        switch (escaped) {
            case '"' -> result.append('"');
            case '\\' -> result.append('\\');
            case '/' -> result.append('/');
            case 'n' -> result.append('\n');
            case 'r' -> result.append('\r');
            case 't' -> result.append('\t');
            case 'b' -> result.append('\b');
            case 'f' -> result.append('\f');

            case 'u' -> {
                if (i + 4 >= value.length() - 1) {
                    throw new IOException("Incomplete Unicode code.");
                }

                String hex = value.substring(i + 1, i + 5);

                try {
                    result.append((char) Integer.parseInt(hex, 16));
                } catch (NumberFormatException e) {
                    throw new IOException("Invalid Unicode code.", e);
                }
                i += 4;
            }
            default -> throw new IOException("Escape JSON desconocido.");
        }
    }

        return result.toString();
    }
}