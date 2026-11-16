import { MedicineRecord } from './MedicineRecord';
import { Food } from './Food';

export abstract class FarmAnimal {
    private static idCounter = 1;
    private id: number;
    private breed: string;
    private bornOnDate: Date;
    private weightInKg: number;
    private sex: string;
    private medicinesRecord: MedicineRecord[];
    private isMeat: boolean;

    constructor(breed: string, bornOnDate: Date, weightInKg: number, sex: string, medicinesRecord: MedicineRecord[], isMeat: boolean, id?: number) {
        this.id = id !== undefined ? id : FarmAnimal.idCounter++;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
        this.weightInKg = weightInKg;
        this.sex = sex;
        this.medicinesRecord = medicinesRecord;
        this.isMeat = isMeat;
        if (this.id >= FarmAnimal.idCounter) {
            FarmAnimal.idCounter = this.id + 1;
        }
    }

    public getId(): number { return this.id; }
    public getBreed(): string { return this.breed; }
    public setBreed(breed: string): void { this.breed = breed; }
    public getBornOnDate(): Date { return this.bornOnDate; }
    public setBornOnDate(bornOnDate: Date): void { this.bornOnDate = bornOnDate; }
    public getWeightInKg(): number { return this.weightInKg; }
    public setWeightInKg(weightInKg: number): void { this.weightInKg = weightInKg; }
    public getSex(): string { return this.sex; }
    public setSex(sex: string): void { this.sex = sex; }
    public getMedicinesRecord(): MedicineRecord[] { return this.medicinesRecord; }
    public setMedicinesRecord(medicinesRecord: MedicineRecord[]): void { this.medicinesRecord = medicinesRecord; }
    public getIsMeat(): boolean { return this.isMeat; }
    public setIsMeat(isMeat: boolean): void { this.isMeat = isMeat; }

    public getAgeInMonths(): number {
        const today = new Date();
        return (today.getFullYear() - this.bornOnDate.getFullYear()) * 12 + (today.getMonth() - this.bornOnDate.getMonth());
    }

    public abstract feed(food: Food, amountOfFood: number): void;
    public abstract computeNextMedicineDate(lastMedicine: Date): Date;
    public abstract checkIfReadyToEat(): boolean;
    public abstract toString(): string;
}