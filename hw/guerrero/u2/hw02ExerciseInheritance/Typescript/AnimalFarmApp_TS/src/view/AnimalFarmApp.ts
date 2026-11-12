import { Cow } from '../model/Cow';
import { Chicken } from '../model/Chicken';

class AnimalFarmApp {
    public static main(): void {
        console.log("=== WELCOME TO ANIMAL FARM APP (TYPESCRIPT) ===");

        const cow = new Cow("Lola", 4, 15.5);
        const chicken = new Chicken("Pepa", 1, 7);

        console.log(cow.toString());
        console.log(chicken.toString());
    }
}

AnimalFarmApp.main();