
from model.farm_animal import FarmAnimal
from datetime import datetime, timedelta
from model.food import Food
from model.medicine_record import MedicineRecord

class Chicken(FarmAnimal):
    def __init__(self, is_molting:bool, number_of_laid_eggs:int, type_chicken:str, 
                 breed: str, born_on_date: datetime, weight_in_kg: float,
                 sex:str, medicines_record: list[MedicineRecord], is_meat: bool):
        super().__init__(breed, born_on_date, weight_in_kg, sex, medicines_record, is_meat)
        self.__is_molting = is_molting
        self.__number_of_laid_eggs = number_of_laid_eggs
        self.__type_chicken = type_chicken
    
    def get_is_molting(self):
        return self.__is_molting
    def set_is_molting(self, is_molting: bool):
        self.__is_molting = is_molting
    
    def get_number_of_laid_eggs(self):
        return self.__number_of_laid_eggs

    def get_type_chicken(self):
        return self.__type_chicken
    
    def set_type_chicken(self, type_chicken: str):
        self.__type_chicken = type_chicken
        

    def lay_an_egg(self):
        if self.__is_molting:
            print(f"Chicken [ID: {self.get_id()}] is molting and cannot lay eggs.")
            return
        self.__number_of_laid_eggs += 1
        print(f"Chicken [ID: {self.get_id()}] has laid an egg. Total eggs laid: {self.__number_of_laid_eggs}")

    #defining the abstract methods from FarmAnimal
    
    def feed(self, food: Food, amount_of_food: float):
            print(f"Chicken [ID: {self.get_id()}] is eating {food.get_name()}, {amount_of_food} kg.")

    def check_if_ready_to_eat(self):
        age = self.get_age_in_months()
        type_chicken = self.get_type_chicken()
        if type_chicken == "broiler" and age >= 2:
            print(f"Chicken [ID: {self.get_id()}] is a broiler and is ready to eat.")
        else:
            print(f"Chicken [ID: {self.get_id()}] is not ready to eat yet.")
    
    def compute_next_medicine_date(self, last_medicine: datetime) -> datetime:
        if self.get_is_molting():
            next_medicine_date = last_medicine + timedelta(days=15)
        else:
            next_medicine_date = last_medicine + timedelta(days=30)
        return next_medicine_date
    
    def __str__(self):
        return (
            f"Chicken [ID: {self.get_id()}, Breed: {self.get_breed()}, "
            f"Born on: {self.get_born_on_date().strftime('%d-%m-%Y')}, "
            f"Weight: {self.get_weight_in_kg()} kg, Sex: {self.get_sex()}, "
            f"Medicines Record: {len(self.get_medicines_record())} entries, "
            f"Is Meat: {self.get_is_meat()}, Is Molting: {self.get_is_molting()}, "
            f"Number of Laid Eggs: {self.get_number_of_laid_eggs()}, "
            f"Type: {self.get_type_chicken()}]"
        )
        