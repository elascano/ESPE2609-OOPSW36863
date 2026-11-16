export class Food {
  constructor(private _description: string) {}

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  toString(): string {
    return this._description;
  }
}
