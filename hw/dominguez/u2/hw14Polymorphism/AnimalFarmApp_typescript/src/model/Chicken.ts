import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Chicken extends FarmAnimal {
  constructor(
    private _isMolting: boolean,
    private _numberOfLaidEggsInAMonth: number,
    private _isMeat: boolean,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  feed(food: Food, amountOfFood: number): void {
    console.log(`feeding a chicken with ${amountOfFood} of ${food}`);
  }

  layAnEgg(): void {
    console.log("chicken is laying an egg ()");
  }

  get isMolting(): boolean {
    return this._isMolting;
  }

  set isMolting(value: boolean) {
    this._isMolting = value;
  }

  get numberOfLaidEggsInAMonth(): number {
    return this._numberOfLaidEggsInAMonth;
  }

  set numberOfLaidEggsInAMonth(value: number) {
    this._numberOfLaidEggsInAMonth = value;
  }

  get isMeat(): boolean {
    return this._isMeat;
  }

  set isMeat(value: boolean) {
    this._isMeat = value;
  }

  toString(): string {
    return (
      `Chicken{${super.toString()}isMolting=${this._isMolting}, ` +
      `numberOfLaidEggsInAMonth=${this._numberOfLaidEggsInAMonth}, ` +
      `isMeat=${this._isMeat}}`
    );
  }
}
