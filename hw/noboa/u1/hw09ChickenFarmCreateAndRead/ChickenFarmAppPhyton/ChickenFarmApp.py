import datetime
from typing import List, Optional

# --- MODEL CLASSES ---

class Egg:
    def __init__(self, id: int, size: str):
        self.id = id
        self.size = size

    def get_size(self) -> str:
        return self.size

    def __str__(self) -> str:
        return f"Egg{{id={self.id}, size='{self.size}'}}"


class Poop:
    def __init__(self, id: int, color: str, consistency: str):
        self.id = id
        self.color = color
        self.consistency = consistency

    def __str__(self) -> str:
        return f"Poop{{id={self.id}, color='{self.color}', consistency='{self.consistency}'}}"


class Chicken:
    def __init__(self, id: int, name: str, color: str, born_on_date: datetime.date, molting: bool):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date
        self.molting = molting
        self.age_in_years = self.compute_age_in_years()

    def do_stuff(self) -> None:
        self._cluck()
        self._wander()
        self._eat()
        self._drink(1.3)
        print(f"poop --> {self._poop()}")
        print(f"egg --> {self._lay_an_egg()}")

    def _cluck(self) -> None:
        print(f"The chicken {self.name} is clucking...")

    def _wander(self) -> None:
        print(f"The chicken {self.name} is wandering...")

    def _eat(self) -> None:
        print(f"The chicken {self.name} is eating...")

    def _drink(self, amount_of_water: float) -> None:
        print(f"The chicken {self.name} is drinking --> {amount_of_water} ml of water")

    def _poop(self) -> Poop:
        return Poop(2, "green", "M")

    def _lay_an_egg(self) -> Egg:
        return Egg(2, "S")

    def compute_age_in_years(self) -> int:
        today = datetime.date.today()
        age = today.year - self.born_on_date.year
        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            age -= 1
        return age

    def __str__(self) -> str:
        return (f"Chicken{{id={self.id}, name='{self.name}', color='{self.color}', "
                f"bornOnDate={self.born_on_date}, age={self.age_in_years}, molting={self.molting}}}")


class ChickenCoop:
    def __init__(self, chicken_coop_id: int, chickens: Optional[List[Optional[Chicken]]] = None):
        self.chicken_coop_id = chicken_coop_id
        self.chickens: List[Optional[Chicken]] = chickens if chickens is not None else [None] * 10
        self.current_index = 0

    def add(self, chicken: Chicken) -> None:
        for i in range(len(self.chickens)):
            if self.chickens[i] is None:
                self.chickens[i] = chicken
                print(f"Chicken with ID {chicken.id} added successfully")
                return
        print("Error: Coop is full! Couldn't add chicken.")

    def remove(self, chicken_id: int) -> None:
        for i in range(len(self.chickens)):
            if self.chickens[i] is not None and self.chickens[i].id == chicken_id:
                self.chickens[i] = None
                print(f"Chicken with ID {chicken_id} was removed from coop")
                return
        print(f"Chicken with ID {chicken_id} was not found in coop")

    def reset_iteration(self) -> None:
        self.current_index = 0
        print("Iteration reset to the start of coop")

    def next(self) -> Optional[Chicken]:
        while self.current_index < len(self.chickens):
            current = self.chickens[self.current_index]
            self.current_index += 1
            if current is not None:
                print(f"Next chicken retrieved: {current.name}")
                return current
        print("No more chickens available in the coop iteration")
        return None

    def __str__(self) -> str:
        local_chickens = "\n\t".join(str(c) for c in self.chickens if c is not None)
        return f"ChickenCoop{{chickenCoopId={self.chicken_coop_id}, chickens=[\n\t{local_chickens}\n]}}"


class ChickenFarmer:
    def __init__(self):
        self.chicken_farmer_id = 1
        self.name = ""
        chickens = [
            Chicken(0, "pepita", "black", datetime.date.today(), True),
            Chicken(0, "marujita", "black", datetime.date.today(), True)
        ]
        self.coops = [
            ChickenCoop(0, list(chickens)),
            ChickenCoop(1, list(chickens))
        ]

    def __str__(self) -> str:
        local_coops = "\n".join(str(coop) for coop in self.coops)
        return f"ChickenFarmer{{chickenFarmerId={self.chicken_farmer_id}, name='{self.name}', coops=[\n{local_coops}\n]}}"


# --- MAIN APPLICATION ---

def main():
    print("Dennis Noboa's Chicken Farm")
    print("===========================")

    chicken = Chicken(1, "Claudio", "light brown", datetime.date(1900, 12, 17), True)
    egg = Egg(1, "M")

    print(f"my chicken is --> {chicken}")
    print(f"egg --> {egg}")
    print(f"egg size --> {egg.get_size()}")

    poop = Poop(1, "brown", "S")
    print(f"poop --> {poop}")

    chicken1 = Chicken(2, "Lucy", "brown and white", datetime.date(1970, 12, 17), True)
    print(f"chicken 1 --> {chicken1}")

    local_age = chicken.compute_age_in_years()
    print(f"the age of the chicken --> {chicken.name}, is --> {local_age}")

    chicken.do_stuff()

    chickens: List[Optional[Chicken]] = [None] * 10
    chickens[0] = Chicken(3, "Pepita", "black", datetime.date(2020, 2, 2), True)
    chickens[1] = chicken

    for i in range(10):
        print(f"chickens --> {chickens[i]}")

    for i in range(len(chickens)):
        chickens[i] = Chicken(i, f"chicken {i+1}", "white", datetime.date(2020, 3, 3), True)
        chickens[i].age_in_years = i

    for i in range(10):
        print(f"chickens --> {chickens[i]}")

    coop = ChickenCoop(101, list(chickens))

    chicken_menu = 0
    while chicken_menu != 6:
        print("\n--- Dennis Noboa's Chicken Farm App Menu ---")
        print("1. Add chicken")
        print("2. Remove chicken")
        print("3. Reset iteration")
        print("4. Next chicken")
        print("5. Show chicken list")
        print("6. Exit\n")

        try:
            chicken_menu = int(input("Choose an option: "))
        except ValueError:
            print("ERROR: Please enter a valid number.")
            continue

        print()

        if chicken_menu == 1:
            print("--- ADD CHICKENS TO COOP ---")
            try:
                c_id = int(input("Insert chicken ID: "))
                c_name = input("Insert chicken Name: ")
                c_color = input("Insert chicken Color: ")
                coop.add(Chicken(c_id, c_name, c_color, datetime.date.today(), True))
            except ValueError:
                print("Invalid input.")
        elif chicken_menu == 2:
            print("--- REMOVE CHICKENS FROM COOP ---")
            try:
                c_id = int(input("Insert chicken ID to remove: "))
                coop.remove(c_id)
            except ValueError:
                print("Invalid ID.")
        elif chicken_menu == 3:
            print("--- RESET ITERATION ---")
            coop.reset_iteration()
        elif chicken_menu == 4:
            print("--- NEXT CHICKEN ---")
            coop.next()
        elif chicken_menu == 5:
            print("--- CHICKEN LIST ---")
            for i in range(len(chickens)):
                print(f"chickens --> {chickens[i]}")
        elif chicken_menu == 6:
            print("SYSTEM EXIT SUCCESSFULLY...")
        else:
            print("ERROR: Choose another option")

    print("\n\n==========")
    print("2026 10 21")
    chicken_farmer = ChickenFarmer()
    print(f"chicken farmer --> {chicken_farmer}")


if __name__ == "__main__":
    main()