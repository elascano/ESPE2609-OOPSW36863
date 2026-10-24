class ChickenCoop:
    def __init__(self, chicken_coop_id, chickens=None):
        self.chicken_coop_id = chicken_coop_id

        self.chickens = chickens if chickens is not None else []
        self.current_index = 0

    def add(self, chicken):
        self.chickens.append(chicken)

    def remove(self, chicken_id):
        for i, chicken in enumerate(self.chickens):
            if chicken is not None and chicken.id == chicken_id:
                self.chickens.pop(i)
                break
    
    def next(self):
        next_chicken = None
        if self.current_index < len(self.chickens):
            next_chicken = self.chickens[self.current_index]
            self.current_index += 1
        return next_chicken

    def reset_iteration(self):
        self.current_index = 0

    def __str__(self):
        return f"ChickenCoop{{chickenCoopId={self.chicken_coop_id}, chickens={self.chickens}, currentIndex={self.current_index}}}"