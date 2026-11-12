from datetime import date


class FarmAnimal:
    def __init__(self, id: int, breed: str, born_on_date: date):
        self._id = id
        self._breed = breed
        self._born_on_date = born_on_date

    def get_age_in_months(self) -> int:
        # Placeholder preserved from the Java exercise.
        return 0

    def __str__(self) -> str:
        return (
            f"id={self._id}, breed={self._breed}, "
            f"born_on_date={self._born_on_date.day}/"
            f"{self._born_on_date.month}/{self._born_on_date.year}, "
        )

    def get_id(self) -> int:
        return self._id

    def set_id(self, id: int):
        self._id = id

    def get_breed(self) -> str:
        return self._breed

    def set_breed(self, breed: str):
        self._breed = breed

    def get_born_on_date(self) -> date:
        return self._born_on_date

    def set_born_on_date(self, born_on_date: date):
        self._born_on_date = born_on_date
