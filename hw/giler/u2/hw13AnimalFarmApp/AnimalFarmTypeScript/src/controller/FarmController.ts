import { Chicken } from '../model/Chicken';
import { Cow } from '../model/Cow';
import { FarmAnimal } from '../model/FarmAnimal';
import { ConsoleView } from '../view/ConsoleView';

export class FarmController {
    private animals: FarmAnimal[] = [];
    private view: ConsoleView;

    constructor() {
        this.view = new ConsoleView();
    }

    public addChicken(id: number, breed: string, bornOn: Date, isMolting: boolean): void {
        const chicken = new Chicken(id, breed, bornOn, isMolting);
        this.animals.push(chicken);
        this.view.showMessage(`Gallina ${id} agregada a la granja.`);
    }

    public addCow(id: number, breed: string, bornOn: Date, isProducingMilk: boolean): void {
        const cow = new Cow(id, breed, bornOn, isProducingMilk);
        this.animals.push(cow);
        this.view.showMessage(`Vaca ${id} agregada a la granja.`);
    }

    public displayAllAnimals(): void {
        this.view.showMessage(`\nMostrando todos los animales en la granja:`);
        for (const animal of this.animals) {
            this.view.showAnimalDetails(animal);
            animal.feed();
        }
    }
}
