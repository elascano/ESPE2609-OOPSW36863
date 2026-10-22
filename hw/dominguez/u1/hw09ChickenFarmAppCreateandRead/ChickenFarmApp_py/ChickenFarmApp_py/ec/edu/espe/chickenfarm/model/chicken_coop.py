class ChickenCoop:
    def __init__(self, chicken_coop_id, chickens):
        self.chicken_coop_id = chicken_coop_id
        self.chickens = chickens 
        self.current_index = 0

    def add(self, chicken):
        if self.current_index < len(self.chickens):
            self.chickens[self.current_index] = chicken
            self.current_index += 1
            print(f"{self.chickens[self.current_index - 1]} Added correctly")
        else:
            print("Dont have more space")

    def remove(self, chicken_id):
        for i in range(len(self.chickens)):
            if self.chickens[i] is not None and self.chickens[i].id == chicken_id:
                for j in range(i, len(self.chickens) - 1):
                    self.chickens[j] = self.chickens[j + 1]
                self.chickens[len(self.chickens) - 1] = None
                self.current_index -= 1
                return

    def reset_iteration(self):
        self.current_index = 0

    def next(self):
        if self.current_index < len(self.chickens) and self.chickens[self.current_index] is not None:
            chicken = self.chickens[self.current_index]
            self.current_index += 1
            return chicken
        return None

    def __repr__(self):
        return (f"ChickenCoop{{chickenCoopId={self.chicken_coop_id}, "
                f"chickens={self.chickens}, currentIndex={self.current_index}}}")
