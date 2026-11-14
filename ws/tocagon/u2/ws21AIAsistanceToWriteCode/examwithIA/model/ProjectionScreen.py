import json

class ProjectionScreen:
    def __init__(self, width, height, material):
        self.width = width
        self.height = height
        self.material = material

    def save(self):
        data = {
            "width": self.width,
            "height": self.height,
            "material": self.material
        }

        with open("screen.json", "w") as file:
            json.dump(data, file, indent=4)

    def load(self):
        with open("screen.json", "r") as file:
            data = json.load(file)

        self.width = data["width"]
        self.height = data["height"]
        self.material = data["material"]
