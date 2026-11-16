from datetime import datetime
from model.medicine import Medicine

class MedicineRecord:
    __id = 0
    def __init__(self, medicine: list[Medicine], date: datetime):
        self.__id = MedicineRecord.__id
        MedicineRecord.__id += 1
        self.medicine = medicine
        self.date = date
    
    def get_id(self):
        return self.__id
    
    def get_medicine(self):
        return self.medicine
    
    def get_date(self):
        return self.date
    
    def set_medicine(self, medicine: list[Medicine]):
        self.medicine = medicine
        
    def set_date(self, date: datetime):
        self.date = date
        
    def __str__(self):
        return f"Medicine Record(id={self.__id}, medicine={self.medicine}, date={self.date})"
    
    def add_medicine(self, medicine: Medicine):
        self.medicine.append(medicine)
    
    def administer_medicine(self, medicine_name: str):
        for medicine in self.medicine:
            if medicine.get_name() == medicine_name:
                medicine.administer()
                return True
        return False