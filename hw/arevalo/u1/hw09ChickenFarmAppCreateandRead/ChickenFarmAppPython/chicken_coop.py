from chicken import Chicken


class ChickenCoop:
    MAX_CHICKENS = 10

    def __init__(self, id: int = 1):
        self.id = id
        self.chickens: list[Chicken] = []
        self.currentIndex = 0

    def add(self, chicken: Chicken) -> bool:
        if len(self.chickens) >= self.MAX_CHICKENS:
            print(f"Error: The chicken coop is full (limit of {self.MAX_CHICKENS} chickens).")
            return False
        if self.findById(chicken.id) is not None:
            print(f"Error: A chicken with id {chicken.id} already exists.")
            return False
        self.chickens.append(chicken)
        return True

    def remove(self, chickenId: int) -> bool:
        for i, chicken in enumerate(self.chickens):
            if chicken.id == chickenId:
                del self.chickens[i]
                if self.currentIndex >= len(self.chickens):
                    self.currentIndex = 0
                return True
        return False

    def findById(self, chickenId: int):
        for chicken in self.chickens:
            if chicken.id == chickenId:
                return chicken
        return None

    def resetIteration(self) -> None:
        self.currentIndex = 0

    def next(self):
        if not self.chickens:
            return None
        if self.currentIndex >= len(self.chickens):
            self.currentIndex = 0
        chicken = self.chickens[self.currentIndex]
        self.currentIndex += 1
        return chicken