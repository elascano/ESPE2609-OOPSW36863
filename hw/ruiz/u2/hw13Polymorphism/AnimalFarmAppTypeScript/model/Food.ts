export class Food {
    private description: string;

    constructor(description: string) {
        this.description = description;
    }

    toString(): string {
        return this.description;
    }
}