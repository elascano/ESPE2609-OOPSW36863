import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export class Chicken extends FarmAnimal {
  public constructor(
    id: number,
    breed: string,
    bornOnDate: Date,
    private isMolting: boolean,
    private numberOfLayingsMonth: number,
    private isMeat: boolean
  ) {
    super(id, breed, bornOnDate);
  }

  public override feed(food: Food, amountOfFood: number): void {
    console.log(
      `Feeding a chicken with --> ${amountOfFood} of ${food.toString()} in the month`
    );
  }

  public getIsMolting(): boolean {
    return this.isMolting;
  }

  public setIsMolting(isMolting: boolean): void {
    this.isMolting = isMolting;
  }

  public getNumberOfLayingsMonth(): number {
    return this.numberOfLayingsMonth;
  }

  public setNumberOfLayingsMonth(numberOfLayingsMonth: number): void {
    this.numberOfLayingsMonth = numberOfLayingsMonth;
  }

  public getIsMeat(): boolean {
    return this.isMeat;
  }

  public setIsMeat(isMeat: boolean): void {
    this.isMeat = isMeat;
  }

  public override toString(): string {
    return (
      `Chicken{${super.toString()}, isMolting=${this.isMolting}, ` +
      `numberOfLayingsMonth=${this.numberOfLayingsMonth}, isMeat=${this.isMeat}}`
    );
  }
}
