import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { GrazeAnimal } from "./GrazeAnimal";
import { Location } from "./Location";

/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export class Cow extends FarmAnimal implements GrazeAnimal {
  public constructor(
    private isProducingMilk: boolean,
    private litersOfMilkPerWeek: number,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  public feed(food: Food): void;
  public feed(food: Food, amountOfFood: number): void;
  public override feed(food: Food, amountOfFood?: number): void {
    if (amountOfFood === undefined) {
      console.log(`Feeding a cow in the stable with --> ${food.toString()}`);
      return;
    }

    console.log(`Feeding a cow with --> ${amountOfFood} of ${food.toString()}`);
  }

  public graze(location: Location): void {
    console.log(`Sending the cow to eat grass at --> ${location.toString()}`);
  }

  public milk(): void;
  public milk(amountOfLiters: number): void;
  public milk(amountOfLiters: number, hour: Date): void;
  public milk(amountOfLiters?: number, hour?: Date): void {
    if (amountOfLiters === undefined) {
      console.log("Milking the cow as I need");
      return;
    }

    this.litersOfMilkPerWeek += amountOfLiters;
    let message = `Milking the cow for --> ${amountOfLiters} liters`;

    if (hour !== undefined) {
      message += `, at --> ${hour.toISOString().slice(0, 10)}`;
    }

    console.log(message);
  }

  public getIsProducingMilk(): boolean {
    return this.isProducingMilk;
  }

  public setIsProducingMilk(isProducingMilk: boolean): void {
    this.isProducingMilk = isProducingMilk;
  }

  public getLitersOfMilkPerWeek(): number {
    return this.litersOfMilkPerWeek;
  }

  public setLitersOfMilkPerWeek(litersOfMilkPerWeek: number): void {
    this.litersOfMilkPerWeek = litersOfMilkPerWeek;
  }

  public override toString(): string {
    return (
      `Cow{${super.toString()}, isProducingMilk=${this.isProducingMilk}, ` +
      `litersOfMilkPerWeek=${this.litersOfMilkPerWeek}}`
    );
  }
}
