class Location:
    def __init__(self, current: int, description: str) -> None:
        self.current = current
        self.description = description

    def __str__(self) -> str:
        return f"Location{{current={self.current}, description={self.description}}}"
