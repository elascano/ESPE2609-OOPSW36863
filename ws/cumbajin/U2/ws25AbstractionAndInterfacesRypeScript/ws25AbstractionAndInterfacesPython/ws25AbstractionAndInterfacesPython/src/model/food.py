"""Food model."""


class Food:
    """Represents food provided to a farm animal."""

    def __init__(self, description: str) -> None:
        self.description = description

    def __str__(self) -> str:
        return self.description
