
import json
import csv
from datetime import datetime
from model.Chicken import Chicken

"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

class ChickenFileManager:

    
    @staticmethod
    def saveJSON(chickens):
        data = []

        for chicken in chickens:
            if chicken is not None:
                data += [{
                    "id": chicken.getId(),
                    "name": chicken.getName(),
                    "color": chicken.getColor(),
                    "bornOnDate": chicken.getBornOnDate().isoformat(),
                    "ageInYears": chicken.getAgeInYears(),
                    "molting": chicken.isMolting()
                }]

        file = open("chickens.json", "w")
        json.dump(data, file, indent=4)
        file.close()

        print("Chickens saved in JSON successfully!")

    @staticmethod
    def readJSON():
        file = open("chickens.json", "r")
        data = json.load(file)
        file.close()

        chickens = [None] * len(data)

        for i in range(len(data)):
            item = data[i]

            bornOnDate = datetime.fromisoformat(item["bornOnDate"])

            chickens[i] = Chicken(
                item["id"],
                item["name"],
                item["color"],
                bornOnDate,
                item["molting"]
            )

            chickens[i].setAgeInYears(item["ageInYears"])

        return chickens

    
    @staticmethod
    def saveCSV(chickens):
        file = open("chickens.csv", "w", newline="")

        writer = csv.writer(file)

        writer.writerow([
            "id", "name", "color",
            "bornOnDate", "ageInYears", "molting"
        ])

        for chicken in chickens:
            if chicken is not None:
                writer.writerow([
                    chicken.getId(),
                    chicken.getName(),
                    chicken.getColor(),
                    chicken.getBornOnDate().isoformat(),
                    chicken.getAgeInYears(),
                    chicken.isMolting()
                ])

        file.close()

        print("Chickens saved in CSV successfully!")

    
    @staticmethod
    def readCSV():
        chickens = [None] * 10

        file = open("chickens.csv", "r", newline="")
        reader = csv.reader(file)

        next(reader)

        i = 0

        for data in reader:
            if i < len(chickens):
                bornOnDate = datetime.fromisoformat(data[3])

                chickens[i] = Chicken(
                    int(data[0]),
                    data[1],
                    data[2],
                    bornOnDate,
                    data[5].lower() == "true"
                )

                chickens[i].setAgeInYears(int(data[4]))

                i += 1

        file.close()

        return chickens
