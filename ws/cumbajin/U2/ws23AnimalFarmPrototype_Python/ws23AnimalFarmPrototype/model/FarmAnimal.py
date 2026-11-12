"""Base class for all farm animals (Java FarmAnimal equivalent)."""

from datetime import date


class FarmAnimal:
    def __init__(self, id: int, bread: str, born_on_date: date):
        self._id = id
        self._bread = bread
        self._born_on_date = born_on_date

    @property
    def id(self) -> int:
        return self._id

    @id.setter
    def id(self, value: int) -> None:
        self._id = value

    @property
    def bread(self) -> str:
        # Keep "bread" to match the original Java workshop.
        return self._bread

    @bread.setter
    def bread(self, value: str) -> None:
        self._bread = value

    @property
    def born_on_date(self) -> date:
        return self._born_on_date

    @born_on_date.setter
    def born_on_date(self, value: date) -> None:
        self._born_on_date = value

    def get_age_in_months(self) -> int:
        # The original Java method returns 0; keep its behavior.
        return 0

    def __str__(self) -> str:
        return (
            f"FarmAnimal{{id={self.id}, bread={self.bread}, "
            f"bornOnDate={self.born_on_date.year}}}"
        )
