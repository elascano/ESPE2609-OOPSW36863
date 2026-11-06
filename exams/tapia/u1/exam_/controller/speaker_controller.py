import json
import csv
from model.speaker import Speaker


class SpeakerController:
    def __init__(self):
        self.speakers = []
        self.json_file = "speakers.json"
        self.csv_file = "speakers.csv"

    def add_speaker(self, id, brand, power, price):
        speaker = Speaker(id, brand, power, price)
        self.speakers.append(speaker)

        self.save_json()
        self.save_csv()

    def save_json(self):
        data = [speaker.to_dict() for speaker in self.speakers]

        with open(self.json_file, "w") as file:
            json.dump(data, file, indent=4)

    def save_csv(self):
        with open(self.csv_file, "w", newline="") as file:
            writer = csv.writer(file)

            writer.writerow(["ID", "Brand", "Power", "Price"])

            for speaker in self.speakers:
                writer.writerow([
                    speaker.id,
                    speaker.brand,
                    speaker.power,
                    speaker.price
                ])

    def list_speakers(self):
        if not self.speakers:
            print("No speakers registered.")
            return

        for speaker in self.speakers:
            print("----------------------")
            print(speaker)