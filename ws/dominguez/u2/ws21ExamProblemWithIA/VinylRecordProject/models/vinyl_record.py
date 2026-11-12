class VinylRecord:
    """Represents a vinyl record."""

    def __init__(self, id: int, title: str, artist: str, year: int):
        self._id = id
        self._title = title
        self._artist = artist
        self._year = year

    # Getters
    def get_id(self) -> int:
        return self._id

    def get_title(self) -> str:
        return self._title

    def get_artist(self) -> str:
        return self._artist

    def get_year(self) -> int:
        return self._year

    # Setters
    def set_title(self, title: str) -> None:
        self._title = title

    def set_artist(self, artist: str) -> None:
        self._artist = artist

    def set_year(self, year: int) -> None:
        self._year = year

    def to_dict(self) -> dict:
        return {
            "id": self._id,
            "title": self._title,
            "artist": self._artist,
            "year": self._year,
        }

    @staticmethod
    def from_dict(data: dict) -> "VinylRecord":
        return VinylRecord(data["id"], data["title"], data["artist"], data["year"])

    def __str__(self) -> str:
        return f"[{self._id}] {self._title} - {self._artist} ({self._year})"
    