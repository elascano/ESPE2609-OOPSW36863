export class FarmAnimal {
  constructor(
    private _id: number,
    private _breed: string,
    private _bornOnDate: Date
  ) {}

  getAgeInMonths(): number {
    const today = new Date();
    let months =
      (today.getFullYear() - this._bornOnDate.getFullYear()) * 12 +
      (today.getMonth() - this._bornOnDate.getMonth());
    if (today.getDate() < this._bornOnDate.getDate()) {
      months--;
    }
    return Math.max(months, 0);
  }

  toString(): string {
    const d = this._bornOnDate;
    return (
      `id=${this._id}, breed=${this._breed}, ` +
      `bornOnDate=${d.getDate()}/${d.getMonth() + 1}/${d.getFullYear()}, `
    );
  }

  get id(): number {
    return this._id;
  }
  set id(value: number) {
    this._id = value;
  }

  get breed(): string {
    return this._breed;
  }
  set breed(value: string) {
    this._breed = value;
  }

  get bornOnDate(): Date {
    return this._bornOnDate;
  }
  set bornOnDate(value: Date) {
    this._bornOnDate = value;
  }
}
