from model.farm_animal import FarmAnimal
from model.chicken import Chicken
from model.cow import Cow
from model.pig import Pig
from model.sheep import Sheep
from datetime import date

print("Hello This is Veronica's Animal Farm!")
farm_animal = FarmAnimal(1, "holstein", date.today())
print("my farm animal ---> ", farm_animal)
chicken = Chicken(True, 10, True, 2, "Paleesh", date.today())
print("chicken ---> ", chicken)
cow = Cow(True, 100.5, 3, "holstein", date(2020, 10, 20))
print("cow ---> ", cow)
pig = Pig(True, 120.0, False, 4, "Yorkshire", date.today())
print("pig ---> ", pig)
sheep = Sheep(date(2025, 11, 11), True, 4.0, 5, "Merino", date(2021, 10, 28))
print("sheep ---> ", sheep)