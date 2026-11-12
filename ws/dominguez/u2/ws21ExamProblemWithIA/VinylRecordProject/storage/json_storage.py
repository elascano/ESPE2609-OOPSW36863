import json
import os

from models.vinyl_record import VinylRecord


class JsonStorage:
    """Saves and loads a list of VinylRecord objects in a JSON file."""

    def __init__(self, file_path: str):
        self.file_path = file_path

    def save(self, records: list) -> None:
        os.makedirs(os.path.dirname(self.file_path), exist_ok=True)
        with open(self.file_path, "w", encoding="utf-8") as file:
            json.dump([r.to_dict() for r in records], file, indent=4, ensure_ascii=False)

    def load(self) -> list:
        if not os.path.exists(self.file_path):
            return []
        with open(self.file_path, "r", encoding="utf-8") as file:
            data = json.load(file)
        return [VinylRecord.from_dict(item) for item in data]
    