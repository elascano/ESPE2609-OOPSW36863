class Location:
    """Lugar de la granja (por ejemplo, un potrero)."""

    def __init__(self, id: int, description: str):
        self.id = id
        self.description = description

    def __str__(self) -> str:
        return f"Location{{id={self.id}, description={self.description}}}"
