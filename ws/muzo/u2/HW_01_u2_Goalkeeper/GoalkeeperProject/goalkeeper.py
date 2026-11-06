class Goalkeeper:
    def __init__(self, goalkeeper_id, name, team, saves):
        self.id = goalkeeper_id
        self.name = name
        self.team = team
        self.saves = saves

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "team": self.team,
            "saves": self.saves
        }

    @staticmethod
    def from_dict(data):
        return Goalkeeper(
            data["id"],
            data["name"],
            data["team"],
            data["saves"]
        )

    def __str__(self):
        return (
            f"ID: {self.id} | Nombre: {self.name} | "
            f"Equipo: {self.team} | Atajadas: {self.saves}"
        )
