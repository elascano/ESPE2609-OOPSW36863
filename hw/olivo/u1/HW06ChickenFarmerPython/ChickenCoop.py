from Chicken import Chicken

class ChickenCoop:
    __id = 0

    def __init__(self, chickens=None):
        ChickenCoop.__id += 1
        self.chickens = chickens if chickens is not None else []
        self.id = ChickenCoop.__id
        self.__iterator_index = 0

    def add_chicken(self, chicken):
        self.chickens.append(chicken)
        print(f"Added {chicken}")

    def remove_chicken(self, chicken_id):
        for chicken in self.chickens:
            if chicken.id == chicken_id:
                self.chickens.remove(chicken)
                print(f"Removed {chicken}")
                return True
        print(f"Chicken with ID {chicken_id} not found")
        return False

    def get_chicken(self, chicken_id):
        for chicken in self.chickens:
            if chicken.id == chicken_id:
                return chicken
        return None

    def reset_operation(self):
        self.__iterator_index = 0

    def next(self):
        if self.__iterator_index < len(self.chickens):
            chicken = self.chickens[self.__iterator_index]
            self.__iterator_index += 1
            return chicken
        return None

    def to_dict(self):
        return {
            "id": self.id,
            "chickens": [chicken.to_dict() for chicken in self.chickens]
        }

    @classmethod
    def from_dict(cls, data):
        chickens = [Chicken.from_dict(c_data) for c_data in data["chickens"]]
        coop = cls(chickens)
        coop.id = data["id"]
        if coop.id > cls.__id:
            cls.__id = coop.id
        return coop

    def __str__(self):
        return f"ChickenCoop [ID: {self.id}, Total Chickens: {len(self.chickens)}]"