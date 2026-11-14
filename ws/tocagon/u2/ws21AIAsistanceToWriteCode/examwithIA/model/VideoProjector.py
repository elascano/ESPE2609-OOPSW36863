import json

class VideoProjector:
    def __init__(self, brand, model, brightness, is_on):
        self.brand = brand
        self.model = model
        self.brightness = brightness
        self.is_on = is_on

    def save(self):
        data = {
            "brand": self.brand,
            "model": self.model,
            "brightness": self.brightness,
            "is_on": self.is_on
        }

        with open("videoprojector.json", "w") as file:
            json.dump(data, file, indent=4)

    def load(self):
        with open("videoprojector.json", "r") as file:
            data = json.load(file)

        self.brand = data["brand"]
        self.model = data["model"]
        self.brightness = data["brightness"]
        self.is_on = data["is_on"]