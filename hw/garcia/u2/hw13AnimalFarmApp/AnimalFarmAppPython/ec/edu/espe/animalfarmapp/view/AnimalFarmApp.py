from datetime import date
from ec.edu.espe.animalfarmapp.model.Chicken import Chicken
from ec.edu.espe.animalfarmapp.model.Cow import Cow
from ec.edu.espe.animalfarmapp.model.FarmAnimal import FarmAnimal
from ec.edu.espe.animalfarmapp.model.Pig import Pig
from ec.edu.espe.animalfarmapp.model.Sheep import Sheep


class AnimalFarmApp:
    @staticmethod
    def _read_bool(prompt: str) -> bool:
        value = input(prompt).strip().lower()
        return value in ("true", "1", "yes", "y")

    @staticmethod
    def main() -> None:
        print("Hello, This is Jesus Animal Farm!")
        farm_animal = FarmAnimal(1, "holstein", date.today())
        print(f"My farm animal --> {farm_animal}")

        chicken = Chicken(True, 10, True, 2, "Paleesh", date.today())
        print(f"Chicken --> {chicken}")

        cow = Cow(True, 100.5, 3, "holstein", date(2022, 8, 20))
        print(f"Cow --> {cow}")

        animals: list[FarmAnimal] = [farm_animal, chicken, cow]

        while True:
            print("\n========== ANIMAL FARM MENU ==========")
            print("1. Register Cow")
            print("2. Register Chicken")
            print("3. Register Sheep")
            print("4. Register Pig")
            print("5. Show All Animals")
            print("0. Exit")
            option = int(input("Select an option: "))

            if option == 1:
                print("\n--- Register Cow ---")
                cow_id = int(input("Enter ID: "))
                cow_breed = input("Enter breed: ")
                producing_milk = AnimalFarmApp._read_bool("Is producing milk?: ")
                liters = float(input("Liters of milk per week: "))
                new_cow = Cow(producing_milk, liters, cow_id, cow_breed, date.today())
                animals.append(new_cow)
                print("Cow registered successfully!")

            elif option == 2:
                print("\n--- Register Chicken ---")
                chicken_id = int(input("Enter ID: "))
                chicken_breed = input("Enter breed: ")
                molting = AnimalFarmApp._read_bool("Is molting?: ")
                eggs = int(input("Number of eggs per month: "))
                meat = AnimalFarmApp._read_bool("Is it for meat?: ")
                new_chicken = Chicken(molting, eggs, meat, chicken_id, chicken_breed, date.today())
                animals.append(new_chicken)
                print("Chicken registered successfully!")

            elif option == 3:
                print("\n--- Register Sheep ---")
                sheep_id = int(input("Enter ID: "))
                sheep_breed = input("Enter breed: ")
                wool = float(input("Wool production in kg: "))
                sheared = AnimalFarmApp._read_bool("Is it sheared?: ")
                new_sheep = Sheep(wool, sheared, sheep_id, sheep_breed, date.today())
                animals.append(new_sheep)
                print("Sheep registered successfully!")

            elif option == 4:
                print("\n--- Register Pig ---")
                pig_id = int(input("Enter ID: "))
                pig_breed = input("Enter breed: ")
                weight = float(input("Weight in kg: "))
                breeding = AnimalFarmApp._read_bool("Is it for breeding?: ")
                new_pig = Pig(weight, breeding, pig_id, pig_breed, date.today())
                animals.append(new_pig)
                print("Pig registered successfully!")

            elif option == 5:
                print("\n--- REGISTERED FARM ANIMALS ---")
                for animal in animals:
                    print(animal)

            elif option == 0:
                print("Exiting Animal Farm. Goodbye!")
                break

            else:
                print("Invalid option. Try again.")


if __name__ == "__main__":
    AnimalFarmApp.main()
