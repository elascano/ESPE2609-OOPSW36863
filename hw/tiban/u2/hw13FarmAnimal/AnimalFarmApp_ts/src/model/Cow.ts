import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { GrazeAnimal } from "./GrazeAnimal";
import { Location } from "./Location";

/** Las vacas. */
export class Cow extends FarmAnimal implements GrazeAnimal {
  constructor(
    public isProducingMilk: boolean,
    public litersOfMilkPerWeek: number,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  graze(location: Location): void {
    console.log(`sending the cow to eat grass at -->${location}`);
  }

  feed(food: Food, _amountOfFood: number): void {
    console.log(`feeding a cow with -->${food}`);
  }

  // Sobrecargas, como en el original Java
  milk(): void;
  milk(amountOfLiters: number): void;
  milk(amountOfLiters: number, hour: Date): void;
  milk(amountOfLiters?: number, hour?: Date): void {
    if (amountOfLiters === undefined) {
      console.log("milking the cow as I need.");
    } else if (hour !== undefined) {
      // Igual que el original: registra litros y hora, sin acumular
      console.log(
        `milking the cow for${amountOfLiters} liters, at ${hour.getHours()}:${hour.getMinutes()}`
      );
    } else {
      this.litersOfMilkPerWeek += amountOfLiters;
      console.log(`milking the cow for ${amountOfLiters} liters.`);
    }
  }

  toString(): string {
    return (
      `Cow{${super.toString()}isProducingMilk=${this.isProducingMilk}, ` +
      `litersOfMilkPerWeek=${this.litersOfMilkPerWeek}}`
    );
  }
}
