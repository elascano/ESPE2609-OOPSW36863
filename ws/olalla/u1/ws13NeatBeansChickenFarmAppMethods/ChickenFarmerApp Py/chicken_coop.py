from chicken import Chicken
from helpers import read_int, read_yes_no, read_date

MAX_CHICKENS = 10


class ChickenCoop:
    def __init__(self, id):
        self.id = id
        self.chickens = []
        self.current_index = 0

    def exists_id(self, chicken_id):
        for chicken in self.chickens:
            if chicken.id == chicken_id:
                return True
        return False

    def add(self, chicken):
        if self.exists_id(chicken.id):
            print(f"The id {chicken.id} is already registered, the chicken was not added")
            return
        if len(self.chickens) >= MAX_CHICKENS:
            print("The coop is full, we can't add more chickens")
            return
        self.chickens.append(chicken)
        print("Chicken added -->", chicken.name)

    def register_chickens(self):
        # asks the data of the chickens with the keyboard
        keep_going = True
        while keep_going:
            if len(self.chickens) >= MAX_CHICKENS:
                print("The coop is full, we can't add more chickens")
                return

            print("Register a new chicken")
            id = read_int("Enter the id: ")
            while self.exists_id(id):
                print(f"The id {id} is already registered, try another one")
                id = read_int("Enter the id: ")

            name = input("Enter the name: ")
            color = input("Enter the color: ")
            born_on_date = read_date("Enter the birth date")
            molting = read_yes_no("Is it molting? (y/n): ")

            self.add(Chicken(id, name, color, born_on_date, molting))
            keep_going = read_yes_no("Want to add another chicken? (y/n): ")

    def remove(self, chicken_id):
        for position in range(len(self.chickens)):
            if self.chickens[position].id == chicken_id:
                self.chickens.pop(position)
                if position < self.current_index:
                    self.current_index = self.current_index - 1
                print(f"Chicken with id {chicken_id} was removed")
                return
        print(f"There is no chicken with id {chicken_id}")

    def reset_iteration(self):
        self.current_index = 0

    def next(self):
        # returns the chicken of the current position and moves forward
        if self.current_index >= len(self.chickens):
            return None
        chicken = self.chickens[self.current_index]
        self.current_index = self.current_index + 1
        return chicken

    def __str__(self):
        text = f"ChickenCoop(id={self.id}, chickens=\n"
        for chicken in self.chickens:
            text = text + "\t" + str(chicken) + "\n"
        return text + ")"