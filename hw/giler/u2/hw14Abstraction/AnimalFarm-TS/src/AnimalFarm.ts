import { Chicken } from './model/Chicken';
import { Cow } from './model/Cow';

function main() {
    console.log("Hello This is Ariel's Animal Farm");
    console.log("my farm animal --->class ec.edu.espe.animalfarm.model.Chicken");
    
    const chicken1 = new Chicken(0, "Palish", "10/11/3920", true, 1, true);
    console.log("my farm animal -->" + chicken1.toString());
    
    const chicken2 = new Chicken(2, "Paleesh", "12/11/2026", true, 10, true);
    console.log("chicken --->" + chicken2.toString());
    
    chicken2.layAnEgg();
    
    const cow = new Cow(3, "holstein", "10/11/3920", true, 100.5);
    console.log("cow --> " + cow.toString());
    
    console.log("farmAnimalForFeeding is a -->Chicken");
    console.log("cow is a -->FarmAnimal");
    console.log("cow is a -->Chicken");
    
    cow.milking();
}

main();