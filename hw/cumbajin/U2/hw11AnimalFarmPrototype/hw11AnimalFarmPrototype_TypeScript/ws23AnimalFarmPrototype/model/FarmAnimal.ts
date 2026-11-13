/** Base class: shared animal attributes and methods. */
export class FarmAnimal {
    constructor(
        private id: number,
        private bread: string,
        private bornOnDate: Date,
    ) {}

    // The Java WS23 prototype returns 0; retain that behavior.
    getAgeInMonths(): number {
        return 0;
    }

    getId(): number { return this.id; }
    setId(id: number): void { this.id = id; }

    getBread(): string { return this.bread; }
    setBread(bread: string): void { this.bread = bread; }

    getBornOnDate(): Date { return this.bornOnDate; }
    setBornOnDate(bornOnDate: Date): void { this.bornOnDate = bornOnDate; }

    toString(): string {
        return `FarmAnimal{id=${this.id}, bread=${this.bread}, bornOnDate=${this.bornOnDate.getUTCFullYear()}}`;
    }
}
