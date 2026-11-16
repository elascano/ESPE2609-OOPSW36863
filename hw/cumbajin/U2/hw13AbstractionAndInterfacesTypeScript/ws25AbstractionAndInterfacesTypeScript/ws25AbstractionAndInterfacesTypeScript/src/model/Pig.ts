import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export class Pig extends FarmAnimal {
  public override feed(food: Food, amountOfFood: number): void {
    console.log(`Feeding a pig with --> ${amountOfFood} of ${food.toString()}`);
  }

  public override toString(): string {
    return `Pig{${super.toString()}}`;
  }
}
