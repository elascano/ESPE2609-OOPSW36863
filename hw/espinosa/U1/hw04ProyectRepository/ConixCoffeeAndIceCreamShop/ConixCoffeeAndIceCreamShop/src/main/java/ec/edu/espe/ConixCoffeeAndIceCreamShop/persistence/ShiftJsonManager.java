
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Shift;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ShiftJsonManager {

    private final Path filePath;
    private final Gson gson;
    private final Type shiftListType;

    public ShiftJsonManager() {
        filePath = Paths.get("data", "shifts.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        shiftListType =
                new TypeToken<ArrayList<ShiftData>>() {}.getType();
    }

    public void saveShifts(List<Shift> shifts)
            throws IOException {

        if (shifts == null) {
            throw new IllegalArgumentException(
                    "Shifts list cannot be null.");
        }

        List<ShiftData> data = new ArrayList<>();

        for (Shift shift : shifts) {
            if (shift == null) {
                throw new IllegalArgumentException(
                        "A shift cannot be null.");
            }

            ShiftData item = new ShiftData();
            item.startTime = shift.getStartTime().toString();
            item.endTime = shift.getEndTime().toString();

            data.add(item);
        }

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(data),
                StandardCharsets.UTF_8
        );
    }

    public List<Shift> loadShifts() throws IOException {

        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }

        String json = Files.readString(
                filePath, StandardCharsets.UTF_8);

        try {
            List<ShiftData> data =
                    gson.fromJson(json, shiftListType);

            List<Shift> shifts = new ArrayList<>();

            if (data == null) {
                return shifts;
            }

            for (ShiftData item : data) {
                if (item == null
                        || item.startTime == null
                        || item.endTime == null) {
                    throw new IllegalArgumentException(
                            "Invalid shift data.");
                }

                shifts.add(new Shift(
                        LocalTime.parse(item.startTime),
                        LocalTime.parse(item.endTime)
                ));
            }

            return shifts;

        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read shifts.json.", e);
        }
    }

    private class ShiftData {
        private String startTime;
        private String endTime;
    }
}
