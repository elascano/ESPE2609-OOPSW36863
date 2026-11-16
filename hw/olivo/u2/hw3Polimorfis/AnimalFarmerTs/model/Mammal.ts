import { FarmAnimal } from './FarmAnimal';
import { MedicineRecord } from './MedicineRecord';

export abstract class Mammal extends FarmAnimal {
    private pregnant: boolean;

    constructor(pregnant: boolean, breed: string, bornOnDate: Date, weightInKg: number, sex: string, medicinesRecord: MedicineRecord[], isMeat: boolean, id?: number) {
        super(breed, bornOnDate, weightInKg, sex, medicinesRecord, isMeat, id);
        this.pregnant = pregnant;
    }

    public setPregnant(pregnant: boolean): void { this.pregnant = pregnant; }
    public getPregnant(): boolean { return this.pregnant; }
}