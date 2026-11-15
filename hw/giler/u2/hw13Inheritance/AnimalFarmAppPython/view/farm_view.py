class FarmView:
    def print_chicken_details(self, chicken):
        print(f"Chicken [ID: {chicken.id}, Breed: {chicken.breed}, Molting: {chicken.is_molting}]")

    def print_cow_details(self, cow):
        print(f"Cow [ID: {cow.id}, Breed: {cow.breed}, Produce milk: {cow.produces_milk}]")