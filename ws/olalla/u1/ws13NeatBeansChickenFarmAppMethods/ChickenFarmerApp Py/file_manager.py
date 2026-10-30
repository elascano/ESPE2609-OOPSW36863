import csv
import json
from datetime import date

from chicken import Chicken

# Python already has the json and csv modules, nothing to install.
# Saved fields: id, name, color, born_on_date (yyyy-mm-dd) and molting.
# The age is not saved because it is calculated from born_on_date.


# ---------------------------- JSON ----------------------------

def save_json(chickens, file_path):
    # WRITE: list of Chicken --> .json file
    data = []
    for chicken in chickens:
        data.append({
            "id": chicken.id,
            "name": chicken.name,
            "color": chicken.color,
            "born_on_date": chicken.born_on_date.isoformat(),
            "molting": chicken.molting,
        })

    with open(file_path, "w", encoding="utf-8") as file:
        json.dump(data, file, indent=2, ensure_ascii=False)


def load_json(file_path):
    # READ: .json file --> list of Chicken
    with open(file_path, "r", encoding="utf-8") as file:
        data = json.load(file)

    chickens = []
    for item in data:
        chicken = Chicken(
            item["id"],
            item["name"],
            item["color"],
            date.fromisoformat(item["born_on_date"]),
            item["molting"],
        )
        chickens.append(chicken)
    return chickens


# ---------------------------- CSV ----------------------------

def save_csv(chickens, file_path):
    with open(file_path, "w", newline="", encoding="utf-8") as file:
        writer = csv.writer(file)
        writer.writerow(["id", "name", "color", "born_on_date", "molting"])
        for chicken in chickens:
            writer.writerow([chicken.id, chicken.name, chicken.color,
                             chicken.born_on_date.isoformat(), chicken.molting])


def load_csv(file_path):
    chickens = []
    with open(file_path, "r", newline="", encoding="utf-8") as file:
        reader = csv.DictReader(file)  # uses the first line as the column names
        for row in reader:
            chicken = Chicken(
                int(row["id"]),
                row["name"],
                row["color"],
                date.fromisoformat(row["born_on_date"]),
                row["molting"] == "True",
            )
            chickens.append(chicken)
    return chickens