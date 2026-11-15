from datetime import date
from abc import ABC, abstractmethod


class FarmAnimal(ABC):
    def __init__(self, id, breed, bornOnDate):
        self.id= id
        self.breed= breed
        self.bornOnDate= bornOnDate

    @abstractmethod
    def feed(self):
        pass

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id= id

    def get_breed(self):
        return self.breed

    def set_breed(self, breed):
        self.breed= breed

    def get_bornOnDate(self):
        return self.bornOnDate

    def set_bornOnDate(self, bornOnDate):
        self.bornOnDate = bornOnDate

    def __str__(self):
        return f"id={self.id}, breed={self.breed}, bornOnDate={self.bornOnDate}"

    def get_age_in_months(self):
        today = date.today()

        months = (today.year - self.bornOnDate.year) * 12
        months += today.month - self.bornOnDate.month

        if today.day < self.bornOnDate.day:
            months -= 1

        return months