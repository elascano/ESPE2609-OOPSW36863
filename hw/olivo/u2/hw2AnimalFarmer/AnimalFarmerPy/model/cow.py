from datetime import datetime, timedelta
from model.food import Food
from model.mammal import Mammal
from model.medicine_record import MedicineRecord

class Cow(Mammal):
    def __init__(self, is_producing_milk: bool, liters_of_milk_per_week: float, pregnant: bool, breed: str, born_on_date: datetime, 
                 weight_in_kg: float, sex: str, medicines_record: list[MedicineRecord], is_meat: bool):
        
        super().__init__(pregnant, breed, born_on_date, weight_in_kg, sex, medicines_record, is_meat)
        self.__is_producing_milk = is_producing_milk
        self.__liters_of_milk_per_week = liters_of_milk_per_week
    
    def get_is_producing_milk(self) -> bool:
        return self.__is_producing_milk
    
    def set_is_producing_milk(self, is_producing_milk: bool):
        self.__is_producing_milk = is_producing_milk
    
    def get_liters_of_milk_per_week(self) -> float:
        return self.__liters_of_milk_per_week
    
    def set_liters_of_milk_per_week(self, liters_of_milk_per_week: float):
        self.__liters_of_milk_per_week = liters_of_milk_per_week
    
    def milk(self, amount_of_liters: float):
        if self.__is_producing_milk:
            self.__liters_of_milk_per_week += amount_of_liters
            print(f"Cow [ID: {self.get_id()}] is producing milk. Amount of milk: {amount_of_liters} liters.")
        else:
            print(f"Cow [ID: {self.get_id()}] is not producing milk.")

    # Implement abstract methods
    def feed(self, food: Food, amount_of_food: float):
        new_weight = self.get_weight_in_kg() + (amount_of_food * 0.1)
        self.set_weight_in_kg(new_weight)
        print(f"Cow [ID: {self.get_id()}] is eating {food.get_name()}, {amount_of_food} kg.")
    
    def check_if_ready_to_eat(self) -> bool:
        standard_min_weight = 480.0
        current_weight = self.get_weight_in_kg()
        is_ready = current_weight >= standard_min_weight
        print(f"Cow [ID: {self.get_id()}] - Weight: {current_weight} kg | Ready to eat: {is_ready}")
        return is_ready
    
    def compute_next_medicine_date(self, last_medicine: datetime) -> datetime:
        days_interval = 30 if self.get_pregnant() else 60
        next_medicine_date = last_medicine + timedelta(days=days_interval)
        return next_medicine_date
    
    def __str__(self):
        born_str = self.get_born_on_date().strftime('%d-%m-%Y') if self.get_born_on_date() else "N/A"
        return (
            f"Cow [ID: {self.get_id()}, Breed: {self.get_breed()}, "
            f"Born on: {born_str}, Weight: {self.get_weight_in_kg()} kg, "
            f"Sex: {self.get_sex()}, Pregnant: {self.get_pregnant()}, "
            f"Medicines Record: {len(self.get_medicines_record())} entries, "
            f"Is Meat: {self.get_is_meat()}, Producing Milk: {self.__is_producing_milk}, "
            f"Liters of Milk/Week: {self.__liters_of_milk_per_week} L]"
        )