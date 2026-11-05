import csv
import json


class ChickenFileManager:

    @staticmethod
    def save_as_csv(chickens):

        with open(
                "chickens.csv",
                "w",
                newline="",
                encoding="utf-8"
        ) as file:

            writer = csv.writer(file)

            writer.writerow(
                ["ID", "Name", "Color", "Molting"]
            )

            for chicken in chickens:

                if chicken is not None:

                    writer.writerow([
                        chicken.id,
                        chicken.name,
                        chicken.color,
                        chicken.molting
                    ])

    @staticmethod
    def save_as_json(chickens):

        data = []

        for chicken in chickens:

            if chicken is not None:

                data.append({
                    "id": chicken.id,
                    "name": chicken.name,
                    "color": chicken.color,
                    "molting": chicken.molting
                })

        with open(
                "chickens.json",
                "w",
                encoding="utf-8"
        ) as file:

            json.dump(
                data,
                file,
                indent=4
            )