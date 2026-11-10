export class Cellphone {
    private id: number;
    private brand: string;
    private model: string;
    private price: number;

    constructor(id: number, brand: string, model: string, price: number) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public getId(): number {
        return this.id;
    }

    public setId(id: number): void {
        this.id = id;
    }

    public getBrand(): string {
        return this.brand;
    }

    public setBrand(brand: string): void {
        this.brand = brand;
    }

    public getModel(): string {
        return this.model;
    }

    public setModel(model: string): void {
        this.model = model;
    }

    public getPrice(): number {
        return this.price;
    }

    public setPrice(price: number): void {
        this.price = price;
    }

    public toString(): string {
        return `Cellphone{id=${this.id}, brand=${this.brand}, model=${this.model}, price=${this.price}}`;
    }
}