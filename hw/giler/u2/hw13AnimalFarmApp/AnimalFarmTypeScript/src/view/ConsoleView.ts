import { FarmAnimal } from '../model/FarmAnimal';

export class ConsoleView {
    public showAnimalDetails(animal: FarmAnimal): void {
        console.log(`--- Animal Details ---`);
        console.log(`ID: ${animal.id}`);
        console.log(`Breed: ${animal.breed}`);
        console.log(`Born On Date: ${animal.bornOn.toDateString()}`);
        console.log(`Produce: ${animal.produce()}`);
    }

    public showMessage(message: string): void {
        console.log(message);
    }
}
