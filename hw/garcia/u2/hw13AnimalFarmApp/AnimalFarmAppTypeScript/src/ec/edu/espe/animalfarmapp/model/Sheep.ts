import { FarmAnimal } from "./FarmAnimal";

export class Sheep extends FarmAnimal {
  private woolProductionkg: number;
  private isSheared: boolean;

  constructor(
    woolProductionkg: number,
    isSheared: boolean,
    id: number,
    breed: string,
    bornOnDate: Date
  ) {
    super(id, breed, bornOnDate);
    this.woolProductionkg = woolProductionkg;
    this.isSheared = isSheared;
  }

  public override toString(): string {
    return (
      `Sheep{${super.toString()}woolProductionkg=${this.woolProductionkg}, ` +
      `isSheared=${this.isSheared}}`
    );
  }

  public getWoolProductionkg(): number {
    return this.woolProductionkg;
  }

  public setWoolProductionkg(woolProductionkg: number): void {
    this.woolProductionkg = woolProductionkg;
  }

  public isIsSheared(): boolean {
    return this.isSheared;
  }

  public setIsSheared(isSheared: boolean): void {
    this.isSheared = isSheared;
  }

  public shear(): void {
    this.isSheared = true;
    console.log("The sheep has been sheared");
  }
}
