import csv
import json
import os
from datetime import datetime
from chicken import Chicken
from chicken_coop import ChickenCoop


class JsonStorage:
    @staticmethod
    def loadChickens(coop: ChickenCoop, jsonFilePath: str, csvFilePath: str) -> None:
        if os.path.exists(jsonFilePath):
            with open(jsonFilePath, "r", encoding="utf-8") as file:
                content = file.read().strip()
                if not content:
                    raise ValueError("Empty JSON file.")
                rawChickens = json.loads(content)
                if not isinstance(rawChickens, list):
                    raise ValueError("Root JSON element must be a list.")

            for item in rawChickens:
                if not isinstance(item, dict):
                    raise ValueError("Each chicken entry must be a JSON object.")
                if not all(k in item for k in ("id", "name", "color", "bornOnDate", "molting")):
                    raise ValueError("Missing required fields in JSON object.")
                if not isinstance(item["id"], int) or isinstance(item["id"], bool):
                    raise ValueError("Invalid 'id' type.")
                if not isinstance(item["name"], str) or not item["name"].strip():
                    raise ValueError("Invalid 'name' value.")
                if not isinstance(item["color"], str) or not item["color"].strip():
                    raise ValueError("Invalid 'color' value.")
                if not isinstance(item["molting"], bool):
                    raise ValueError("Invalid 'molting' type.")

                bornOnDate = datetime.strptime(item["bornOnDate"], "%Y-%m-%d").date()
                chicken = Chicken(
                    item["id"],
                    item["name"],
                    item["color"],
                    bornOnDate,
                    item["molting"],
                )
                if not coop.add(chicken):
                    raise ValueError("Duplicate ID or coop limit exceeded in JSON file.")

        elif os.path.exists(csvFilePath):
            with open(csvFilePath, "r", encoding="utf-8", newline="") as file:
                reader = csv.DictReader(file)
                for row in reader:
                    chickenId = int(row["id"])
                    name = row["name"].strip()
                    color = row["color"].strip()
                    bornOnDate = datetime.strptime(row["bornOnDate"].strip(), "%Y-%m-%d").date()
                    moltingStr = row["molting"].strip().lower()
                    if moltingStr not in ("true", "false"):
                        raise ValueError("Invalid boolean in CSV.")
                    molting = moltingStr == "true"
                    chicken = Chicken(chickenId, name, color, bornOnDate, molting)
                    if not coop.add(chicken):
                        raise ValueError("Duplicate ID or coop limit exceeded in CSV file.")

    @staticmethod
    def saveChickens(coop: ChickenCoop, jsonFilePath: str, csvFilePath: str) -> None:
        jsonData = [
            {
                "id": c.id,
                "name": c.name,
                "color": c.color,
                "bornOnDate": c.bornOnDate.isoformat(),
                "molting": c.molting,
            }
            for c in coop.chickens
        ]
        with open(jsonFilePath, "w", encoding="utf-8") as jFile:
            json.dump(jsonData, jFile, indent=2, ensure_ascii=False)

        with open(csvFilePath, "w", encoding="utf-8", newline="") as cFile:
            writer = csv.writer(cFile, quoting=csv.QUOTE_ALL)
            cFile.write("id,name,color,bornOnDate,molting\n")
            for c in coop.chickens:
                writer.writerow([
                    str(c.id),
                    c.name,
                    c.color,
                    c.bornOnDate.isoformat(),
                    str(c.molting).lower(),
                ])