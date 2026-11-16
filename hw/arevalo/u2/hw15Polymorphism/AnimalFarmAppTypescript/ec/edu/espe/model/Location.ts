export class Location {
    private id: number;
    private description: string;

    constructor(id: number, description: string) {
        this.id = id;
        this.description = description;
    }

    toString(): string { return `Location{id=${this.id}, description=${this.description}}`; }
    getId(): number { return this.id; }
    setId(id: number): void { this.id = id; }
    getDescription(): string { return this.description; }
    setDescription(description: string): void { this.description = description; }
}
