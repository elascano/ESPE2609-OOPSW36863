export class Location {

    constructor(
        public id: number,
        public description: string
    ) {}

    toString(): string {
        return `Location{id=${this.id}, description=${this.description}}`;
    }
}