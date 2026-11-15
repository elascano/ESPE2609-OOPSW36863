import { Chicken } from '../model/Chicken';
import { Cow } from '../model/Cow';
import { FarmAnimal } from '../model/FarmAnimal';
import { ConsoleView } from '../view/ConsoleView';

export class FarmController {
    private animals: FarmAnimal[] = [];
    private view: ConsoleView = new ConsoleView();

    public addChicken(
        id: number, 
        breed: string, 
        bornOnDate: string, 
        isMolting: boolean, 
        numberOfLaidEggInMonth: number, 
        isMeat: boolean
    ): void {
        this.animals.push(new Chicken(id, breed, bornOnDate, isMolting, numberOfLaidEggInMonth, isMeat));
    }

    public addCow(
        id: number, 
        breed: string, 
        bornOnDate: string, 
        isProducingMilk: boolean, 
        litersOfMilkForWeek: number
    ): void {
        this.animals.push(new Cow(id, breed, bornOnDate, isProducingMilk, litersOfMilkForWeek));
    }

    public displayAndProcessAnimals(): void {
        this.view.showMessage(`\n--- Processing Animals ---`);
        for (const animal of this.animals) {
            animal.feed();
            if (animal instanceof Chicken) {
                animal.layAnEgg();
            } else if (animal instanceof Cow) {
                animal.milking();
            }
        }
    }
}