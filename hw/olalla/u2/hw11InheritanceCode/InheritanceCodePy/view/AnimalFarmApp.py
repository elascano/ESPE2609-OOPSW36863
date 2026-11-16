from datetime import date

from model.Chicken import Chicken
from model.Cow import Cow
from model.Cuts import Cuts
from model.Food import Food
from model.Pig import Pig
from model.Sheep import Sheep

def main():
    born_on_date = date.today()
    print("Hello this is Julian's Animal Farm!")

    food_chicken = Food("corn")
    food_cow = Food("hay")
    food_pig = Food("Corn and Soy")
    food_sheep = Food("hay")

    cuts_chicken = Cuts("wings, breast, thighs")
    cuts_cow = Cuts("sirloin, ribeye, brisket")
    cuts_pig = Cuts("ribs, ham, bacon")
    cuts_sheep = Cuts("leg, shoulder, rack")    

    chicken = Chicken(1, "Paleesh", born_on_date, 0, True, 10, True)
    print(chicken)
    chicken.feed(food_chicken, 100, "g")
    chicken.cuts(cuts_chicken)
    print("\n")

    cow = Cow(2, "Holstein", born_on_date, 0, True, 25.0)
    print(cow)
    cow.feed(food_cow, 20, "kg")
    cow.cuts(cuts_cow)
    print("\n")

    pig = Pig(3, "Duroc", born_on_date, 5, 25.0, False)
    print(pig)
    pig.feed(food_pig, 100, "Kg")
    pig.cuts(cuts_pig)
    pig.gain_weight(4.5)
    pig.produce_manure(2.5, "kg")
    pig.give_birth(8)
    print("\n")
    
    sheep = Sheep(4, "Merino", born_on_date, 3, True, date(2026, 4, 1), 5.0)    
    print(sheep)    
    sheep.feed(food_sheep, 15, "Kg")
    sheep.cuts(cuts_sheep)    
    sheep.shear()
    sheep.wool_produce_per_month(3.2, "kg")
    sheep.give_birth(2)


if __name__ == "__main__":
    main()