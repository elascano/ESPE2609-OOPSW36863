from datetime import datetime
from model.farm_animal import FarmAnimal
from model.medicine_record import MedicineRecord

class Mammal(FarmAnimal):
    def __init__(self, pregnant: bool, breed: str, born_on_date: datetime, weight_in_kg: float, sex: str,
                 medicines_record: list[MedicineRecord], is_meat: bool):
        super().__init__(breed, born_on_date, weight_in_kg, sex, medicines_record, is_meat)
        self.__pregnant = pregnant
        self.__is_meat = is_meat
    
    def set_pregnant(self, pregnant: bool):
        self.__pregnant = pregnant
        
    def get_pregnant(self) -> bool:
        return self.__pregnant
    
    def set_is_meat(self, is_meat: bool):
        self.__is_meat = is_meat
        
    def get_is_meat(self) -> bool:
        return self.__is_meat