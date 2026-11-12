from datetime import date


class FarmAnimal:
    def __init__(self, id: int, breed: str, born_on_date: date):
        self._id = id
        self._breed = breed
        self._born_on_date = born_on_date

    def get_age_in_months(self) -> int:
        today = date.today()
        months = (today.year - self._born_on_date.year) * 12 \
            + (today.month - self._born_on_date.month)
        if today.day < self._born_on_date.day:
            months -= 1
        return max(months, 0)

    def __str__(self) -> str:
        d = self._born_on_date
        return (f"id={self._id}, breed={self._breed}, "
                f"bornOnDate={d.day}/{d.month}/{d.year}, ")

    @property
    def id(self) -> int:
        return self._id

    @id.setter
    def id(self, value: int) -> None:
        self._id = value

    @property
    def breed(self) -> str:
        return self._breed

    @breed.setter
    def breed(self, value: str) -> None:
        self._breed = value

    @property
    def born_on_date(self) -> date:
        return self._born_on_date

    @born_on_date.setter
    def born_on_date(self, value: date) -> None:
        self._born_on_date = value
