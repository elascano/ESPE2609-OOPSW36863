export class Medicine {
    private static idCounter = 1;
    private id: number;
    private name: string;
    private description: string;
    private price: number;

    constructor(name: string, description: string, price: number, id?: number) {
        this.id = id !== undefined ? id : Medicine.idCounter++;
        this.name = name;
        this.description = description;
        this.price = price;
        if (this.id >= Medicine.idCounter) {
            Medicine.idCounter = this.id + 1;
        }
    }

    public getId(): number { return this.id; }
    public getName(): string { return this.name; }
    public setName(name: string): void { this.name = name; }
    public getDescription(): string { return this.description; }
    public setDescription(description: string): void { this.description = description; }
    public getPrice(): number { return this.price; }
    public setPrice(price: number): void { this.price = price; }

    public administer(): void {
        console.log(`Administering medicine: ${this.name}`);
    }

    public toString(): string {
        return `Medicine [id=${this.id}, name=${this.name}, description=${this.description}, price=${this.price}]`;
    }
}