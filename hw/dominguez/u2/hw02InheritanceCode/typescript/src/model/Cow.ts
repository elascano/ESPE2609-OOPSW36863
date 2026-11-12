import { FarmAnimal } from "./FarmAnimal";

export class Cow extends FarmAnimal {
  constructor(
    private _isProductingMilk: boolean,
    private _literOfMilkPerWeek: number,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
  }

  milk(): void {
    console.log("milkin the cow");
  }

  toString(): string {
    return (
      `Cow{${super.toString()}isProductingMilk=${this._isProductingMilk}, ` +
      `literOfMilkPerWeek=${this._literOfMilkPerWeek}}`
    );
  }

  get isProductingMilk(): boolean {
    return this._isProductingMilk;
  }
  set isProductingMilk(value: boolean) {
    this._isProductingMilk = value;
  }

  get literOfMilkPerWeek(): number {
    return this._literOfMilkPerWeek;
  }
  set literOfMilkPerWeek(value: number) {
    this._literOfMilkPerWeek = value;
  }
}
