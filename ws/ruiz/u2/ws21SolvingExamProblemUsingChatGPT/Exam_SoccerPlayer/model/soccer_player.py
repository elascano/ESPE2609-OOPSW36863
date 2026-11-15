class SoccerPlayer:

    def __init__(self, id: int, name: str, position: str, shirt_number: int):
        self.id = id
        self.name = name
        self.position = position
        self.shirt_number = shirt_number

    def to_dict(self) -> dict:
        return {
            "id": self.id,
            "name": self.name,
            "position": self.position,
            "shirt_number": self.shirt_number,
        }

    @classmethod
    def from_dict(cls, data: dict) -> "SoccerPlayer":
        return cls(data["id"], data["name"], data["position"], data["shirt_number"])

    def __str__(self) -> str:
        return f"ID: {self.id} | {self.name} | {self.position} | #{self.shirt_number}"