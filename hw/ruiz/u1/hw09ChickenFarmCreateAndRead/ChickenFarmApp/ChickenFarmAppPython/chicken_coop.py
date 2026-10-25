class ChickenCoop:
    def __init__(self, chicken_coop_id, chickens):
        self._chicken_coop_id = chicken_coop_id
        self._chickens = chickens
        self._current_index = 0

    def add(self, chicken):
        for i in range(len(self._chickens)):
            if self._chickens[i] is None:
                self._chickens[i] = chicken
                print(f"Chicken --> {chicken} added successfully")
                return
        print("The coop is full, the chicken can not be added.")

    def remove(self, chicken_id):
        for i in range(len(self._chickens)):
            if self._chickens[i] is None:
                continue
            if self._chickens[i].id == chicken_id:
                self._chickens[i] = None
                print(f"Chicken with ID {chicken_id} has been removed.")
                return
        print(f"Chicken with ID {chicken_id} not found.")

    def reset_iteration(self):
        self._current_index = 0

    def next(self):
        while self._current_index < len(self._chickens):
            chicken = self._chickens[self._current_index]
            self._current_index += 1
            if chicken is not None:
                return chicken
        return None

    def __str__(self):
        local_chickens = ""
        for chicken in self._chickens:
            local_chickens += str(chicken) + "\n\t"
        return f"ChickenCoop{{chickenCoopId={self._chicken_coop_id}, chickens={local_chickens}}}"

    @property
    def chicken_coop_id(self):
        return self._chicken_coop_id

    @chicken_coop_id.setter
    def chicken_coop_id(self, value):
        self._chicken_coop_id = value

    @property
    def chickens(self):
        return self._chickens

    @chickens.setter
    def chickens(self, value):
        self._chickens = value