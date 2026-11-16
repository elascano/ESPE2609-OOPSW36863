import { Food } from "./Food";

/**
 * Abstract class shared by every farm animal.
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export abstract class FarmAnimal {
  public constructor(
    private id: number,
    private breed: string,
    private bornOnDate: Date
  ) {}

  public abstract feed(food: Food, amountOfFood: number): void;

  public getAgeInMonths(): number {
    const today = new Date();
    let months =
      (today.getFullYear() - this.bornOnDate.getFullYear()) * 12 +
      today.getMonth() -
      this.bornOnDate.getMonth();

    if (today.getDate() < this.bornOnDate.getDate()) {
      months--;
    }

    return Math.max(months, 0);
  }

  public getId(): number {
    return this.id;
  }

  public setId(id: number): void {
    this.id = id;
  }

  public getBreed(): string {
    return this.breed;
  }

  public setBreed(breed: string): void {
    this.breed = breed;
  }

  public getBornOnDate(): Date {
    return this.bornOnDate;
  }

  public setBornOnDate(bornOnDate: Date): void {
    this.bornOnDate = bornOnDate;
  }

  public toString(): string {
    return (
      `FarmAnimal{id=${this.id}, breed=${this.breed}, ` +
      `bornOnDate=${this.bornOnDate.toISOString().slice(0, 10)}}`
    );
  }
}
