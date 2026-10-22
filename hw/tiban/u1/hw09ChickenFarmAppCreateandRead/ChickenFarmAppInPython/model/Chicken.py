from datetime import date


from model.Egg import Egg
from model.Poop import Poop

class Chicken:
    def __init__(self, id, name, color, born_on_date, molting):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date  
        self.molting = molting
        self.age_in_years = 0  

    def compute_age_in_years(self):
        today = date.today()
        age = today.year - self.born_on_date.year
        
        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            age -= 1
            
        return age

    
    def set_age_in_years(self):
        self.age_in_years = self.compute_age_in_years()

    def do_stuff(self):
        self._cluck()
        self._wander()
        self._drink(1.3)
        print(f"poop --> {self._poop()}")
        print(f"egg --> {self._lay_an_egg()}")

    
    def _cluck(self):
        print(f"The chicken {self.name} is clucking...")

    def _wander(self):
        print(f"The chicken {self.name} is wandering...")

    def _eat(self):
        print(f"The chicken {self.name} is eating....")

    def _drink(self, amount_of_water):
        print(f"The chicken is drinking {amount_of_water}ml of water...")

    def _poop(self):
       
        return Poop(2, "Green", 'M')

    def _lay_an_egg(self):
        
        return Egg(2, 'S')

    def __str__(self):
        return f"Chicken{{id={self.id}, name={self.name}, color={self.color}, bornOnDate={self.born_on_date}, ageInYears={self.age_in_years}, molting={self.molting}}}"