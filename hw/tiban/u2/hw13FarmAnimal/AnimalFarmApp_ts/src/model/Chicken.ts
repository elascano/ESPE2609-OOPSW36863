import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

/** Las gallinas. */
export class Chicken extends FarmAnimal {
  constructor(
    public isMolting: boolean,
    public numberOfLaidEggsInAMonth: number,
    public isMeat: boolean,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  layAnEgg(): void {
    this.numberOfLaidEggsInAMonth++;
    console.log("chicken is laying an egg() ");
  }

  /** Alimenta a la gallina con granos. */
  feed(food: Food, amountOfFood: number): void {
    console.log(`feeding a chicken with -->${amountOfFood} of ${food}`);
  }

  toString(): string {
    return (
      `Chicken{${super.toString()}isMolting=${this.isMolting}, ` +
      `numberOfLaidEggsInAMonth=${this.numberOfLaidEggsInAMonth}, ` +
      `isMeat=${this.isMeat}}`
    );
  }
}
