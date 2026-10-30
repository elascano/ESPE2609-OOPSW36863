
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFileManager {

    private static final Path DATA_DIRECTORY = Paths.get("data");

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private JsonFileManager() {
        // Utility class: prevent object creation.
    }

    public static void save(Object data, String fileName)
            throws IOException {

        if (data == null) {
            throw new IllegalArgumentException(
                    "Data to save cannot be null.");
        }

        Path filePath = getFilePath(fileName);

        Files.createDirectories(DATA_DIRECTORY);

        String json = GSON.toJson(data);

        Files.writeString(
                filePath,
                json,
                StandardCharsets.UTF_8
        );
    }

    public static <T> T load(String fileName, Type typeOfT)
            throws IOException {

        if (typeOfT == null) {
            throw new IllegalArgumentException(
                    "The data type cannot be null.");
        }

        Path filePath = getFilePath(fileName);

        if (!Files.exists(filePath)) {
            return null;
        }

        String json = Files.readString(
                filePath,
                StandardCharsets.UTF_8
        );

        try {
            return GSON.fromJson(json, typeOfT);
        } catch (JsonSyntaxException e) {
            throw new IOException(
                    "The JSON file is invalid: " + fileName, e);
        }
    }

    private static Path getFilePath(String fileName) {
        if (fileName == null
                || !fileName.matches("[a-zA-Z0-9_-]+\\.json")) {
            throw new IllegalArgumentException(
                    "Invalid JSON file name.");
        }

        return DATA_DIRECTORY.resolve(fileName);
    }
}
