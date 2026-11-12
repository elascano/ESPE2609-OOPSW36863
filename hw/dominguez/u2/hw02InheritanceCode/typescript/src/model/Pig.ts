import { FarmAnimal } from "./FarmAnimal";

export class Pig extends FarmAnimal {
  constructor(
    private _isMeat: boolean,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  toString(): string {
    return `Pig{${super.toString()}isMeat=${this._isMeat}}`;
  }

  get isMeat(): boolean {
    return this._isMeat;
  }
  set isMeat(value: boolean) {
    this._isMeat = value;
  }
}
