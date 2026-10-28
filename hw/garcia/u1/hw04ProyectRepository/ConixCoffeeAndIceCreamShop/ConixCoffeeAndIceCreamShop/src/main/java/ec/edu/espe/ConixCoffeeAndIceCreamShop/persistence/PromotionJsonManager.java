
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Promotion;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PromotionJsonManager {

    private final Path filePath;
    private final Gson gson;
    private final Type promotionListType;

    public PromotionJsonManager() {
        filePath = Paths.get("data", "promotions.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        promotionListType =
                new TypeToken<ArrayList<PromotionData>>() {}.getType();
    }

    public void savePromotions(List<Promotion> promotions)
            throws IOException {

        if (promotions == null) {
            throw new IllegalArgumentException(
                    "Promotions list cannot be null.");
        }

        List<PromotionData> data = new ArrayList<>();

        for (Promotion promotion : promotions) {
            if (promotion == null) {
                throw new IllegalArgumentException(
                        "A promotion cannot be null.");
            }

            PromotionData item = new PromotionData();
            item.valid = promotion.isValid();
            item.discountPercentage =
                    promotion.getDiscountPercentage();

            data.add(item);
        }

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(data),
                StandardCharsets.UTF_8
        );
    }

    public List<Promotion> loadPromotions() throws IOException {

        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }

        String json = Files.readString(
                filePath, StandardCharsets.UTF_8);

        try {
            List<PromotionData> data =
                    gson.fromJson(json, promotionListType);

            List<Promotion> promotions = new ArrayList<>();

            if (data == null) {
                return promotions;
            }

            for (PromotionData item : data) {
                if (item == null) {
                    throw new IllegalArgumentException(
                            "Invalid promotion data.");
                }

                promotions.add(new Promotion(
                        item.valid,
                        item.discountPercentage
                ));
            }

            return promotions;

        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read promotions.json.", e);
        }
    }

    private class PromotionData {
        private boolean valid;
        private double discountPercentage;
    }
}
