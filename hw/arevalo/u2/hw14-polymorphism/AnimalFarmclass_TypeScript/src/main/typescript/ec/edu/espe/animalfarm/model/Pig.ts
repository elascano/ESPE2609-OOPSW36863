import { FarmAnimal } from "./FarmAnimal";

// @author Anthony Arevalo, MosQ, ESPE
export class Pig extends FarmAnimal {
    #weightInKg: number;
    #dailyFoodIntakeInKg: number;
    #isCastrated: boolean;

    public constructor(weightInKg: number, dailyFoodIntakeInKg: number, isCastrated: boolean, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.#weightInKg = weightInKg;
        this.#dailyFoodIntakeInKg = dailyFoodIntakeInKg;
        this.#isCastrated = isCastrated;
    }

    public override toString(): string {
        return "Pig{" + super.toString()
            + "weightInKg=" + this.#weightInKg
            + ", dailyFoodIntakeInKg=" + this.#dailyFoodIntakeInKg
            + ", isCastrated=" + this.#isCastrated + "}";
    }

    public getWeightInKg(): number {
        return this.#weightInKg;
    }

    public setWeightInKg(weightInKg: number): void {
        this.#weightInKg = weightInKg;
    }

    public getDailyFoodIntakeInKg(): number {
        return this.#dailyFoodIntakeInKg;
    }

    public setDailyFoodIntakeInKg(dailyFoodIntakeInKg: number): void {
        this.#dailyFoodIntakeInKg = dailyFoodIntakeInKg;
    }

    public isCastrated(): boolean {
        return this.#isCastrated;
    }

    public setCastrated(isCastrated: boolean): void {
        this.#isCastrated = isCastrated;
    }
}
