import { Mammal } from './Mammal';
import { MedicineRecord } from './MedicineRecord';
import { Food } from './Food';

export class Sheep extends Mammal {
    private lastShearing: Date;

    constructor(lastShearing: Date, pregnant: boolean, breed: string, bornOnDate: Date, weightInKg: number, sex: string, medicinesRecord: MedicineRecord[], isMeat: boolean, id?: number) {
        super(pregnant, breed, bornOnDate, weightInKg, sex, medicinesRecord, isMeat, id);
        this.lastShearing = lastShearing;
    }

    public getLastShearing(): Date { return this.lastShearing; }
    public setLastShearing(lastShearing: Date): void { this.lastShearing = lastShearing; }

    public computeNextShearingDate(): Date {
        const nextDate = new Date(this.lastShearing);
        nextDate.setDate(nextDate.getDate() + 365);
        return nextDate;
    }

    public computeNextMedicineDate(lastMedicine: Date): Date {
        const days = this.getPregnant() ? 30 : 60;
        const nextDate = new Date(lastMedicine);
        nextDate.setDate(nextDate.getDate() + days);
        return nextDate;
    }

    public feed(food: Food, amountOfFood: number): void {
        this.setWeightInKg(this.getWeightInKg() + amountOfFood * 0.05);
        console.log(`Sheep [ID: ${this.getId()}] is eating ${food.getName()}, ${amountOfFood} kg.`);
    }

    public checkIfReadyToEat(): boolean {
        const isReady = this.getWeightInKg() >= 45.0;
        console.log(`Sheep [ID: ${this.getId()}] - Weight: ${this.getWeightInKg()} kg | Ready to eat: ${isReady}`);
        return isReady;
    }

    public toString(): string {
        const shearingStr = this.lastShearing.toISOString().split('T')[0];
        const bornStr = this.getBornOnDate().toISOString().split('T')[0];
        return `Sheep [ID: ${this.getId()}, Breed: ${this.getBreed()}, Born on: ${bornStr}, Weight: ${this.getWeightInKg()} kg, Sex: ${this.getSex()}, Pregnant: ${this.getPregnant()}, Medicines Record: ${this.getMedicinesRecord().length} entries, Is Meat: ${this.getIsMeat()}, Last Shearing: ${shearingStr}]`;
    }
}