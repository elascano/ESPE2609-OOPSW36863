export class Food {
    private Description: string;

    constructor(Description: string) { this.Description = Description; }
    toString(): string { return this.Description; }
    getDescription(): string { return this.Description; }
    setDescription(Description: string): void { this.Description = Description; }
}
