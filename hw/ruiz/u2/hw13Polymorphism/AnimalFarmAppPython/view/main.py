from model.farm_animal import FarmAnimal
from model.chicken import Chicken
from model.cow import Cow
from model.pig import Pig
from model.sheep import Sheep
from datetime import date
from model.food import Food
from model.location import Location

print("Hello This is Veronica's Animal Farm!")
farm_animal = Chicken(True, 10, False, 1, "holstein", date.today())
print("my farm animal is a ---> " + type(farm_animal). __name__)
print("my farm animal ---> ", farm_animal)

chicken = Chicken(True, 10, True, 2, "Paleesh", date.today())
print("chicken ---> ", chicken)
food1 = Food("corn")

chicken.lay_an_egg()

cow = Cow(True, 100.5, 3, "holstein", date(2020, 10, 20))
print("cow ---> ", cow)
cow.milk()


print("cow is a ---> ", type(cow). __name__)
print("cow is a ---> ", type(chicken). __name__)

pig = Pig(True, 120.0, False, 4, "Yorkshire", date.today())
print("pig ---> ", pig)
pig.select()
sheep = Sheep(date(2025, 11, 11), True, 4.0, 5, "Merino", date(2021, 10, 28))
print("sheep ---> ", sheep)
sheep.shear()

food2 = Food("hay")
food3 = Food("vegetables and fruits")

chicken.feed(food1, 1)
cow.feed(food2, 2)
pig.feed(food3, 3)
sheep.feed(food2, 1)



