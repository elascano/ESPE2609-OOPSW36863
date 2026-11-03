class Poop:
    counter_id = 0

    def __init__(self, color, consistency):
        Poop.counter_id += 1
        self.id = Poop.counter_id
        self.color = color
        self.consistency = consistency

    def to_dict(self):
        return {
            "id": self.id,
            "color": self.color,
            "consistency": self.consistency
        }
    @classmethod
    def from_dict(cls, data):
        poop = cls(data["color"], data["consistency"])
        poop.id = data["id"]
        if poop.id > cls.counter_id:
            cls.counter_id = poop.id
        return poop

    def __str__(self):
        return f"Poop [ID: {self.id}, Color: {self.color}, Consistency: {self.consistency}]"