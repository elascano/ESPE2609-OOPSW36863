import { Mammal } from './Mammal';
import { MedicineRecord } from './MedicineRecord';
import { Food } from './Food';

export class Pig extends Mammal {
    private isMarketReady: boolean;

    constructor(isMarketReady: boolean, pregnant: boolean, breed: string, bornOnDate: Date, weightInKg: number, sex: string, medicinesRecord: MedicineRecord[], isMeat: boolean, id?: number) {
        super(pregnant, breed, bornOnDate, weightInKg, sex, medicinesRecord, isMeat, id);
        this.isMarketReady = isMarketReady;
    }

    public getIsMarketReady(): boolean { return this.isMarketReady; }
    public setIsMarketReady(isMarketReady: boolean): void { this.isMarketReady = isMarketReady; }

    public computeCarcassYieldPercentage(weightCarcassYield: number): number {
        const yieldPerc = (weightCarcassYield / this.getWeightInKg()) * 100;
        return Number(yieldPerc.toFixed(2));
    }

    public feed(food: Food, amountOfFood: number): void {
        console.log(`Pig [ID: ${this.getId()}] is eating ${food.getName()}, ${amountOfFood} kg.`);
    }

    public checkIfReadyToEat(): boolean {
        const isReady = this.getWeightInKg() >= 100.0 || this.isMarketReady;
        console.log(`Pig [ID: ${this.getId()}] - Weight: ${this.getWeightInKg()} kg | Ready to eat: ${isReady}`);
        return isReady;
    }

    public computeNextMedicineDate(lastMedicine: Date): Date {
        const days = this.getPregnant() ? 30 : 45;
        const nextDate = new Date(lastMedicine);
        nextDate.setDate(nextDate.getDate() + days);
        return nextDate;
    }

    public toString(): string {
        const bornStr = this.getBornOnDate().toISOString().split('T')[0];
        return `Pig [ID: ${this.getId()}, Breed: ${this.getBreed()}, Born on: ${bornStr}, Weight: ${this.getWeightInKg()} kg, Sex: ${this.getSex()}, Pregnant: ${this.getPregnant()}, Medicines Record: ${this.getMedicinesRecord().length} entries, Is Meat: ${this.getIsMeat()}, Market Ready: ${this.isMarketReady}]`;
    }
}