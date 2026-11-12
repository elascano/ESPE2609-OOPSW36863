import json
import os
from model.picture import Picture


class PictureModel:
    """Holds the list of pictures (ArrayList equivalent) and handles the JSON file."""

    def __init__(self, file_path="pictures.json"):
        self.file_path = file_path
        self.pictures = []        # the "ArrayList"
        self.load()

    def exists(self, picture_id):
        return any(p.id == picture_id for p in self.pictures)

    def add(self, picture):
        """Adds a picture to the list and saves. Returns False if id is duplicated."""
        if self.exists(picture.id):
            return False
        self.pictures.append(picture)
        self.save()
        return True

    def get_all(self):
        return list(self.pictures)

    def save(self):
        with open(self.file_path, "w", encoding="utf-8") as f:
            json.dump([p.to_dict() for p in self.pictures], f, indent=4)

    def load(self):
        """Reads the JSON file into the list."""
        self.pictures = []
        if not os.path.exists(self.file_path):
            return
        try:
            with open(self.file_path, "r", encoding="utf-8") as f:
                self.pictures = [Picture.from_dict(d) for d in json.load(f)]
        except (json.JSONDecodeError, KeyError):
            self.pictures = []
