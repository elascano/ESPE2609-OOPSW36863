from datetime import datetime
from model.medicine_record import MedicineRecord
from abc import ABC, abstractmethod

from model.food import Food

class FarmAnimal(ABC):
    __id = 0
    def __init__(self, breed: str, born_on_date: datetime, weight_in_kg: float,
                 sex:str, medicines_record: list[MedicineRecord], is_meat: bool):
        self.__id = FarmAnimal.__id
        FarmAnimal.__id += 1
        self.__breed = breed
        self.__born_on_date = born_on_date
        self.__weight_in_kg = weight_in_kg
        self.__sex = sex
        self.__medicines_record = medicines_record
        self.__is_meat = is_meat
    #setters and getters
    def get_id(self):
        return self.__id
    
    def get_breed(self):
        return self.__breed
    
    def set_breed(self, breed: str):
        self.__breed = breed
        
    def get_born_on_date(self):
        return self.__born_on_date
    
    def set_born_on_date(self, born_on_date: datetime):
        self.__born_on_date = born_on_date
    
    def get_weight_in_kg(self):
        return self.__weight_in_kg
    
    def set_weight_in_kg(self, weight_in_kg: float):
        self.__weight_in_kg = weight_in_kg
    
    def get_sex(self):
        return self.__sex
    
    def set_sex(self, sex: str):
        self.__sex = sex
    
    def get_medicines_record(self):
        return self.__medicines_record
    
    def set_medicines_record(self, medicines_record: list[MedicineRecord]):
        self.__medicines_record = medicines_record
    
    def get_is_meat(self):
        return self.__is_meat
    
    def set_is_meat(self, is_meat: bool):
        self.__is_meat = is_meat
    
    def get_age_in_months(self):
        today = datetime.now()
        age_in_months = (today.year - self.__born_on_date.year) * 12 + (today.month - self.__born_on_date.month)
        return age_in_months
    
    #abstract methods to be implemented by subclasses
    @abstractmethod
    def __str__(self):
        pass
    
    @abstractmethod
    def feed(self, food: Food, amount_of_food: float):
        pass
    
    @abstractmethod
    def compute_next_medicine_date(self, last_medicine: datetime):
        pass
    
    @abstractmethod
    def check_if_ready_to_eat(self):
        pass