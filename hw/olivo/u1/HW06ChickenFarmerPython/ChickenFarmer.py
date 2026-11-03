from ChickenCoop import ChickenCoop

class ChickenFarmer:
    __id = 0

    def __init__(self, name, coops=None):
        ChickenFarmer.__id += 1
        self.id = ChickenFarmer.__id
        self.name = name
        self.coops = coops if coops is not None else []
        self.__iterator_index = 0

    def add_coop(self, coop):
        self.coops.append(coop)
        print(f"Farmer {self.name} added Coop #{coop.id}")

    def remove_coop(self, coop_id):
        for coop in self.coops:
            if coop.id == coop_id:
                self.coops.remove(coop)
                print(f"Farmer {self.name} removed Coop #{coop_id}")
                return True
        print(f"Coop with ID {coop_id} not found")
        return False

    def reset_iteration(self):
        self.__iterator_index = 0

    def next(self):
        if self.__iterator_index < len(self.coops):
            coop = self.coops[self.__iterator_index]
            self.__iterator_index += 1
            return coop
        return None

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "coops": [coop.to_dict() for coop in self.coops]
        }

    @classmethod
    def from_dict(cls, data):
        coops = [ChickenCoop.from_dict(c_data) for c_data in data["coops"]]
        farmer = cls(data["name"], coops)
        farmer.id = data["id"]
        if farmer.id > cls.__id:
            cls.__id = farmer.id
        return farmer

    def __str__(self):
        return f"ChickenFarmer [ID: {self.id}, Name: {self.name}, Coops: {len(self.coops)}]"