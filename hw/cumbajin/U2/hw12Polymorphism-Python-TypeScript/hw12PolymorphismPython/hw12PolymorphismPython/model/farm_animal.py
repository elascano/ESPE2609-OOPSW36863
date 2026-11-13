from abc import ABC, abstractmethod
from datetime import date


class FarmAnimal(ABC):
    """Abstract parent class for every animal in the farm."""

    def __init__(self, animal_id: int, breed: str, born_on_date: date) -> None:
        self.__id = animal_id
        self.__breed = breed
        self.__born_on_date = born_on_date

    @property
    def id(self) -> int:
        return self.__id

    @id.setter
    def id(self, animal_id: int) -> None:
        self.__id = animal_id

    @property
    def breed(self) -> str:
        return self.__breed

    @breed.setter
    def breed(self, breed: str) -> None:
        self.__breed = breed

    @property
    def born_on_date(self) -> date:
        return self.__born_on_date

    @born_on_date.setter
    def born_on_date(self, born_on_date: date) -> None:
        self.__born_on_date = born_on_date

    def get_age_in_months(self) -> int:
        return 0

    def _farm_animal_data(self) -> str:
        return (
            f"FarmAnimal{{id={self.id}, breed={self.breed}, "
            f"bornOnDate={self.born_on_date.year}}}"
        )

    @abstractmethod
    def __str__(self) -> str:
        return self._farm_animal_data()
