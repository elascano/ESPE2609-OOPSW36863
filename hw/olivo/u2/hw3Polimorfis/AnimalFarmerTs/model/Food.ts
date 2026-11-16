export class Food {
    private static idCounter = 1;
    private id: number;
    private name: string;

    constructor(name: string, id?: number) {
        this.id = id !== undefined ? id : Food.idCounter++;
        this.name = name;
        if (this.id >= Food.idCounter) {
            Food.idCounter = this.id + 1;
        }
    }

    public getId(): number { return this.id; }
    public getName(): string { return this.name; }
    public setName(name: string): void { this.name = name; }

    public toString(): string {
        return `Food [id=${this.id}, name=${this.name}]`;
    }
}