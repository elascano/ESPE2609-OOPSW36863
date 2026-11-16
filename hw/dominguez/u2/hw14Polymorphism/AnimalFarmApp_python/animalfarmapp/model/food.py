class Food:
    def __init__(self, description: str) -> None:
        self.description = description

    def __str__(self) -> str:
        return self.description
