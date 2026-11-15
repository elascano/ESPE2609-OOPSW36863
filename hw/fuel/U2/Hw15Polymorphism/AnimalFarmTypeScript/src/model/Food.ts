export class Food {

    constructor(
        public description: string
    ) {}

    toString(): string {
        return this.description;
    }
}