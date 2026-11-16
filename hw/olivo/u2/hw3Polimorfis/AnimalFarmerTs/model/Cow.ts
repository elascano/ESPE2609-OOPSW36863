import { Mammal } from './Mammal';
import { MedicineRecord } from './MedicineRecord';
import { Food } from './Food';

export class Cow extends Mammal {
    private isProducingMilk: boolean;
    private litersOfMilkPerWeek: number;

    constructor(isProducingMilk: boolean, litersOfMilkPerWeek: number, pregnant: boolean, breed: string, bornOnDate: Date, weightInKg: number, sex: string, medicinesRecord: MedicineRecord[], isMeat: boolean, id?: number) {
        super(pregnant, breed, bornOnDate, weightInKg, sex, medicinesRecord, isMeat, id);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    public getIsProducingMilk(): boolean { return this.isProducingMilk; }
    public setIsProducingMilk(isProducingMilk: boolean): void { this.isProducingMilk = isProducingMilk; }
    public getLitersOfMilkPerWeek(): number { return this.litersOfMilkPerWeek; }
    public setLitersOfMilkPerWeek(litersOfMilkPerWeek: number): void { this.litersOfMilkPerWeek = litersOfMilkPerWeek; }

    public milk(amountOfLiters: number): void {
        if (this.isProducingMilk) {
            this.litersOfMilkPerWeek += amountOfLiters;
            console.log(`Cow [ID: ${this.getId()}] is producing milk. Amount of milk: ${amountOfLiters} liters.`);
        } else {
            console.log(`Cow [ID: ${this.getId()}] is not producing milk.`);
        }
    }

    public feed(food: Food, amountOfFood: number): void {
        this.setWeightInKg(this.getWeightInKg() + amountOfFood * 0.1);
        console.log(`Cow [ID: ${this.getId()}] is eating ${food.getName()}, ${amountOfFood} kg.`);
    }

    public checkIfReadyToEat(): boolean {
        const isReady = this.getWeightInKg() >= 480.0;
        console.log(`Cow [ID: ${this.getId()}] - Weight: ${this.getWeightInKg()} kg | Ready to eat: ${isReady}`);
        return isReady;
    }

    public computeNextMedicineDate(lastMedicine: Date): Date {
        const days = this.getPregnant() ? 30 : 60;
        const nextDate = new Date(lastMedicine);
        nextDate.setDate(nextDate.getDate() + days);
        return nextDate;
    }

    public toString(): string {
        const bornStr = this.getBornOnDate().toISOString().split('T')[0];
        return `Cow [ID: ${this.getId()}, Breed: ${this.getBreed()}, Born on: ${bornStr}, Weight: ${this.getWeightInKg()} kg, Sex: ${this.getSex()}, Pregnant: ${this.getPregnant()}, Medicines Record: ${this.getMedicinesRecord().length} entries, Is Meat: ${this.getIsMeat()}, Producing Milk: ${this.isProducingMilk}, Liters of Milk/Week: ${this.litersOfMilkPerWeek} L]`;
    }
}