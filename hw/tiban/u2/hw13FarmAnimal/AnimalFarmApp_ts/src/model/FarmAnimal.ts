import { Food } from "./Food";

/** Los animales de la granja. */
export abstract class FarmAnimal {
  constructor(
    public id: number,
    public breed: string,
    public bornOnDate: Date
  ) {}

  /** Alimenta al animal con su propia comida. */
  abstract feed(food: Food, amountOfFood: number): void;

  getAgeInMonths(today: Date = new Date()): number {
    const b = this.bornOnDate;
    let months =
      (today.getFullYear() - b.getFullYear()) * 12 +
      (today.getMonth() - b.getMonth());
    if (today.getDate() < b.getDate()) months--;
    return Math.max(months, 0);
  }

  toString(): string {
    const b = this.bornOnDate;
    return (
      `id=${this.id}, breed=${this.breed}, ` +
      `bornOnDate=${b.getDate()}/${b.getMonth() + 1}/${b.getFullYear()},`
    );
  }
}
