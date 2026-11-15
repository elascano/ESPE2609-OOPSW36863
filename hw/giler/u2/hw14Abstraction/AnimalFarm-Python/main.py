from src.model.chicken import Chicken
from src.model.cow import Cow

if __name__ == '__main__':
    print("Hello This is Ariel's Animal Farm")
    print("my farm animal --->class ec.edu.espe.animalfarm.model.Chicken")
    
    chicken1 = Chicken(0, "Palish", "10/11/3920", True, 1, True)
    print("my farm animal -->" + str(chicken1))
    
    chicken2 = Chicken(2, "Paleesh", "12/11/2026", True, 10, True)
    print("chicken --->" + str(chicken2))
    
    chicken2.lay_an_egg()
    
    cow = Cow(3, "holstein", "10/11/3920", True, 100.5)
    print("cow --> " + str(cow))
    
    print("farmAnimalForFeeding is a -->Chicken")
    print("cow is a -->FarmAnimal")
    print("cow is a -->Chicken")
    
    cow.milking()