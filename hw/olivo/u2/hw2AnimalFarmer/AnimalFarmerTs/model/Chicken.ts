import { FarmAnimal } from './FarmAnimal';
import { MedicineRecord } from './MedicineRecord';
import { Food } from './Food';

export class Chicken extends FarmAnimal {
    private isMolting: boolean;
    private numberOfLaidEggs: number;
    private typeChicken: string;

    constructor(isMolting: boolean, numberOfLaidEggs: number, typeChicken: string, breed: string, bornOnDate: Date, weightInKg: number, sex: string, medicinesRecord: MedicineRecord[], isMeat: boolean, id?: number) {
        super(breed, bornOnDate, weightInKg, sex, medicinesRecord, isMeat, id);
        this.isMolting = isMolting;
        this.numberOfLaidEggs = numberOfLaidEggs;
        this.typeChicken = typeChicken;
    }

    public getIsMolting(): boolean { return this.isMolting; }
    public setIsMolting(isMolting: boolean): void { this.isMolting = isMolting; }
    public getNumberOfLaidEggs(): number { return this.numberOfLaidEggs; }
    public getTypeChicken(): string { return this.typeChicken; }
    public setTypeChicken(typeChicken: string): void { this.typeChicken = typeChicken; }

    public layAnEgg(): void {
        if (this.isMolting) {
            console.log(`Chicken [ID: ${this.getId()}] is molting and cannot lay eggs.`);
            return;
        }
        this.numberOfLaidEggs++;
        console.log(`Chicken [ID: ${this.getId()}] has laid an egg. Total eggs laid: ${this.numberOfLaidEggs}`);
    }

    public feed(food: Food, amountOfFood: number): void {
        console.log(`Chicken [ID: ${this.getId()}] is eating ${food.getName()}, ${amountOfFood} kg.`);
    }

    public checkIfReadyToEat(): boolean {
        return this.typeChicken === "broiler" && this.getAgeInMonths() >= 2;
    }

    public computeNextMedicineDate(lastMedicine: Date): Date {
        const days = this.isMolting ? 15 : 30;
        const nextDate = new Date(lastMedicine);
        nextDate.setDate(nextDate.getDate() + days);
        return nextDate;
    }

    public toString(): string {
        const bornStr = this.getBornOnDate().toISOString().split('T')[0];
        return `Chicken [ID: ${this.getId()}, Breed: ${this.getBreed()}, Born on: ${bornStr}, Weight: ${this.getWeightInKg()} kg, Sex: ${this.getSex()}, Medicines Record: ${this.getMedicinesRecord().length} entries, Is Meat: ${this.getIsMeat()}, Is Molting: ${this.isMolting}, Number of Laid Eggs: ${this.numberOfLaidEggs}, Type: ${this.typeChicken}]`;
    }
}