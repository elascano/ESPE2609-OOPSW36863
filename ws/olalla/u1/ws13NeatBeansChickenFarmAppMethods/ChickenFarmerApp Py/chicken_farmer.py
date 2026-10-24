from chicken_coop import ChickenCoop
from helpers import read_int, read_yes_no

MAX_COOPS = 5


class ChickenFarmer:
    def __init__(self, id, name):
        self.id = id
        self.name = name
        self.coops = []
        self.current_index = 0

    def exists_coop_id(self, coop_id):
        for coop in self.coops:
            if coop.id == coop_id:
                return True
        return False

    def add(self, coop):
        if self.exists_coop_id(coop.id):
            print(f"The coop id {coop.id} is already registered, the coop was not added")
            return
        if len(self.coops) >= MAX_COOPS:
            print("The farmer can't have more coops")
            return
        self.coops.append(coop)
        print("Coop added -->", coop.id)

    def register_coops(self):
        # asks the data of the coops (and their chickens) with the keyboard
        keep_going = True
        while keep_going:
            if len(self.coops) >= MAX_COOPS:
                print("The farmer can't have more coops")
                return

            print("Register a new coop")
            coop_id = read_int("Enter the coop id: ")
            while self.exists_coop_id(coop_id):
                print(f"The coop id {coop_id} is already registered, try another one")
                coop_id = read_int("Enter the coop id: ")

            coop = ChickenCoop(coop_id)
            if read_yes_no("Want to register chickens for this coop? (y/n): "):
                coop.register_chickens()
            self.add(coop)

            keep_going = read_yes_no("Want to register another coop? (y/n): ")

    def remove(self, coop_id):
        for position in range(len(self.coops)):
            if self.coops[position].id == coop_id:
                self.coops.pop(position)
                if position < self.current_index:
                    self.current_index = self.current_index - 1
                print(f"Coop with id {coop_id} was removed")
                return
        print(f"There is no coop with id {coop_id}")

    def reset_iteration(self):
        self.current_index = 0

    def next(self):
        if self.current_index >= len(self.coops):
            return None
        coop = self.coops[self.current_index]
        self.current_index = self.current_index + 1
        return coop

    def get_all_chickens(self):
        # the chickens of all the coops in one list (used to save them in a file)
        all_chickens = []
        for coop in self.coops:
            for chicken in coop.chickens:
                all_chickens.append(chicken)
        return all_chickens

    def __str__(self):
        text = f"ChickenFarmer(id={self.id}, name={self.name}, coops=\n"
        for coop in self.coops:
            text = text + str(coop) + "\n"
        return text + ")"