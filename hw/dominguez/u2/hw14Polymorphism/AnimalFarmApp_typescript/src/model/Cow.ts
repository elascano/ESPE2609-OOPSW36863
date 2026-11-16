import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Cow extends FarmAnimal {
  constructor(
    private _isProducingMilk: boolean,
    private _literOfMilkPerWeek: number,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  feed(food: Food, amountOfFood: number): void {
    console.log(`feeding a cow in the stable with ${amountOfFood} of ${food}`);
  }

  // Sobrecargas equivalentes a las de Java
  milk(): void;
  milk(amountOfLiters: number): void;
  milk(amountOfLiters: number, hour: Date): void;
  milk(amountOfLiters?: number, hour?: Date): void {
    if (amountOfLiters === undefined) {
      console.log("milking the cow as I need");
      return;
    }
    this._literOfMilkPerWeek =
      Math.round((this._literOfMilkPerWeek + amountOfLiters) * 100) / 100;
    if (hour === undefined) {
      console.log(`milking the cow for ${amountOfLiters} liters`);
    } else {
      console.log(
        `milking the cow for ${amountOfLiters} liters, at ${hour.getHours()}:${hour.getMinutes()}`
      );
    }
  }

  get isProducingMilk(): boolean {
    return this._isProducingMilk;
  }

  set isProducingMilk(value: boolean) {
    this._isProducingMilk = value;
  }

  get literOfMilkPerWeek(): number {
    return this._literOfMilkPerWeek;
  }

  set literOfMilkPerWeek(value: number) {
    this._literOfMilkPerWeek = value;
  }

  toString(): string {
    return (
      `Cow{${super.toString()}isProductingMilk=${this._isProducingMilk}, ` +
      `literOfMilkPerWeek=${this._literOfMilkPerWeek}}`
    );
  }
}
