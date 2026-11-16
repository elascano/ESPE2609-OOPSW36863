"""Location model."""


class Location:
    """Represents a place where an animal can graze."""

    def __init__(self, location_id: int, description: str) -> None:
        self.id = location_id
        self.description = description

    def __str__(self) -> str:
        return f"Location{{id={self.id}, description={self.description}}}"
