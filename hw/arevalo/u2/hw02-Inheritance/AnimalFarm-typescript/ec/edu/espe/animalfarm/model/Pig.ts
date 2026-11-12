import { FarmAnimal } from "./FarmAnimal";

export class Pig extends FarmAnimal {
    private weightInKg: number;
    private dailyFoodIntakeInKg: number;
    private castrated: boolean;

    constructor(
        weightInKg: number, dailyFoodIntakeInKg: number, isCastrated: boolean,
        id: number, breed: string, bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
        this.weightInKg = weightInKg;
        this.dailyFoodIntakeInKg = dailyFoodIntakeInKg;
        this.castrated = isCastrated;
    }

    public override toString(): string {
        return `Pig{${super.toString()}weightInKg=${this.weightInKg}, `
            + `dailyFoodIntakeInKg=${this.dailyFoodIntakeInKg}, `
            + `isCastrated=${this.castrated}}`;
    }

    public getWeightInKg(): number {
        return this.weightInKg;
    }

    public setWeightInKg(weightInKg: number): void {
        this.weightInKg = weightInKg;
    }

    public getDailyFoodIntakeInKg(): number {
        return this.dailyFoodIntakeInKg;
    }

    public setDailyFoodIntakeInKg(dailyFoodIntakeInKg: number): void {
        this.dailyFoodIntakeInKg = dailyFoodIntakeInKg;
    }

    public isCastrated(): boolean {
        return this.castrated;
    }

    public setCastrated(isCastrated: boolean): void {
        this.castrated = isCastrated;
    }
}
