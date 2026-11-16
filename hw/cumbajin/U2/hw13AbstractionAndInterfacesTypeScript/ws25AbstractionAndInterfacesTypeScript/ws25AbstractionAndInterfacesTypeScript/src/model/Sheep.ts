import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { GrazeAnimal } from "./GrazeAnimal";
import { Location } from "./Location";

/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export class Sheep extends FarmAnimal implements GrazeAnimal {
  public constructor(
    private lastShearing: Date,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  public override feed(food: Food, amountOfFood: number): void {
    console.log(`Feeding a sheep with --> ${amountOfFood} of ${food.toString()}`);
  }

  public graze(location: Location): void {
    console.log(`Sending the sheep to eat grass at --> ${location.toString()}`);
  }

  public getLastShearing(): Date {
    return this.lastShearing;
  }

  public setLastShearing(lastShearing: Date): void {
    this.lastShearing = lastShearing;
  }

  public override toString(): string {
    return (
      `Sheep{${super.toString()}, ` +
      `lastShearing=${this.lastShearing.toISOString().slice(0, 10)}}`
    );
  }
}
