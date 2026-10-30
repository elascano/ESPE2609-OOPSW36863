class ChickenFarmer:
    def __init__(self, chicken_farmer_id, name, coops):
        self.chicken_farmer_id = chicken_farmer_id
        self.name = name
        self.coops = coops  
        self.current_index = 0

    def add(self, coop):
        if self.current_index < len(self.coops):
            self.coops[self.current_index] = coop
            self.current_index += 1
            print(f"{self.coops[self.current_index - 1]} Added correctly")
        else:
            print("Dont have more space")

    def remove(self, chicken_coop_id):
        for i in range(len(self.coops)):
            if self.coops[i] is not None and self.coops[i].chicken_coop_id == chicken_coop_id:
                for j in range(i, len(self.coops) - 1):
                    self.coops[j] = self.coops[j + 1]
                self.coops[len(self.coops) - 1] = None
                self.current_index -= 1
                return

    def reset_iteration(self):
        self.current_index = 0

    def next(self):
        if self.current_index < len(self.coops) and self.coops[self.current_index] is not None:
            coop = self.coops[self.current_index]
            self.current_index += 1
            return coop
        return None

    def __repr__(self):
        return (f"ChickenFarmer{{chickenFarmerId={self.chicken_farmer_id}, name={self.name}, "
                f"coops={self.coops}, currentIndex={self.current_index}}}")
