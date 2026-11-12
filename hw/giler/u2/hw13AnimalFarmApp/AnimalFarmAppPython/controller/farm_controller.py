class FarmController:
    def __init__(self, view):
        self.animals = []
        self.view = view

    def add_animal(self, animal):
        self.animals.append(animal)

    def update_view(self):
        for animal in self.animals:
            
            if type(animal).__name__ == "Chicken":
                self.view.print_chicken_details(animal)
            elif type(animal).__name__ == "Cow":
                self.view.print_cow_details(animal)