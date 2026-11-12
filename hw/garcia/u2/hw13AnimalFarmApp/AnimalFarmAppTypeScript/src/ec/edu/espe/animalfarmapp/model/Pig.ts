import { FarmAnimal } from "./FarmAnimal";

export class Pig extends FarmAnimal {
  private weightKg: number;
  private isForBreeding: boolean;

  constructor(
    weightKg: number,
    isForBreeding: boolean,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
    this.weightKg = weightKg;
    this.isForBreeding = isForBreeding;
  }

  public override toString(): string {
    return (
      `Pig{${super.toString()}weightKg=${this.weightKg}, ` +
      `isForBreeding=${this.isForBreeding}}`
    );
  }

  public getWeightKg(): number {
    return this.weightKg;
  }

  public setWeightKg(weightKg: number): void {
    this.weightKg = weightKg;
  }

  public isIsForBreeding(): boolean {
    return this.isForBreeding;
  }

  public setIsForBreeding(isForBreeding: boolean): void {
    this.isForBreeding = isForBreeding;
  }

  public feed(): void {
    console.log("Feeding the pig...");
  }
}
