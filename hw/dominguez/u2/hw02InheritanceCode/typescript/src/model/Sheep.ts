import { FarmAnimal } from "./FarmAnimal";

export class Sheep extends FarmAnimal {
  constructor(
    private _lastSheering: Date,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  toString(): string {
    return `Sheep{${super.toString()}lastSheering=${this._lastSheering.toISOString()}}`;
  }

  get lastSheering(): Date {
    return this._lastSheering;
  }
  set lastSheering(value: Date) {
    this._lastSheering = value;
  }
}
