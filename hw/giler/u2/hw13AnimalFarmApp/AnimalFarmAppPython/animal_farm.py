from model.chicken import Chicken
from model.cow import Cow
from view.farm_view import FarmView
from controller.farm_controller import FarmController

def main():

    view = FarmView()
    controller = FarmController(view)

    chicken = Chicken(1, "Plymouth Rock", True)
    cow = Cow(2, "Holstein", True)

    controller.add_animal(chicken)
    controller.add_animal(cow)

    controller.update_view()

if __name__ == "__main__":
    main()