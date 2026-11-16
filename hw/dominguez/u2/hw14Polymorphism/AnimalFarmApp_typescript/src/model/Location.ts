export class Location {
  constructor(private _current: number, private _description: string) {}

  get current(): number {
    return this._current;
  }

  set current(value: number) {
    this._current = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  toString(): string {
    return `Location{current=${this._current}, description=${this._description}}`;
  }
}
