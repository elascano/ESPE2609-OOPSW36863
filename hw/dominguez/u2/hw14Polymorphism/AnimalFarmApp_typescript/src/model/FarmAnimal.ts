import { Food } from "./Food";

export abstract class FarmAnimal {
  constructor(
    private _id: number,
    private _breed: string,
    private _bornOnDate: Date
  ) {}

  /** Feed the animals with their own food */
  abstract feed(food: Food, amountOfFood: number): void;

  getAgeInMonths(): number {
    const today = new Date();
    const born = this._bornOnDate;
    let months =
      (today.getFullYear() - born.getFullYear()) * 12 +
      (today.getMonth() - born.getMonth());
    if (today.getDate() < born.getDate()) {
      months--;
    }
    return Math.max(months, 0);
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get breed(): string {
    return this._breed;
  }

  set breed(value: string) {
    this._breed = value;
  }

  get bornOnDate(): Date {
    return this._bornOnDate;
  }

  set bornOnDate(value: Date) {
    this._bornOnDate = value;
  }

  toString(): string {
    const b = this._bornOnDate;
    return (
      `id=${this._id}, breed=${this._breed}, ` +
      `bornOnDate=${b.getDate()}/${b.getMonth() + 1}/${b.getFullYear()}, `
    );
  }
}
