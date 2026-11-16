import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Pig extends FarmAnimal {
  constructor(
    private _isMeat: boolean,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  rooting(): void {
    console.log("The pig is rooting");
  }

  wallowing(): void {
    console.log("The pig is wallowing");
  }

  feed(food: Food, amountOfFood: number): void {
    console.log(`feeding a pigs in the stable with ${amountOfFood} of ${food}`);
  }

  get isMeat(): boolean {
    return this._isMeat;
  }

  set isMeat(value: boolean) {
    this._isMeat = value;
  }

  toString(): string {
    return `Pig{${super.toString()}isMeat=${this._isMeat}}`;
  }
}
