from model.cow import Cow
from model.chicken import Chicken

class AnimalFarmApp:
    @staticmethod
    def main():
        print("=== ANIMAL FARM APP (PYTHON) ===")

        # Instantiating objects
        cow = Cow("Lola", 4, 15.5)
        chicken = Chicken("Pepa", 1, 7)

        print(cow)
        print(chicken)

if __name__ == "__main__":
    AnimalFarmApp.main()
    