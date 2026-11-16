import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Sheep extends FarmAnimal {
  constructor(
    private _lastShearing: Date,
    private _weightWool: number,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  feed(food: Food, amountOfFood: number): void {
    console.log(`feeding a sheep with ${amountOfFood} of ${food}`);
  }

  shearing(newWool: number): void {
    this._weightWool = Math.round((this._weightWool + newWool) * 100) / 100;
    console.log(`The sheep produce ${this._weightWool}kg of  wool`);
    this._lastShearing = new Date();
  }

  get lastShearing(): Date {
    return this._lastShearing;
  }

  set lastShearing(value: Date) {
    this._lastShearing = value;
  }

  get weightWool(): number {
    return this._weightWool;
  }

  set weightWool(value: number) {
    this._weightWool = value;
  }

  toString(): string {
    return `Sheep{lastSheering=${this._lastShearing.toISOString()}, weightWool=${this._weightWool}}`;
  }
}
