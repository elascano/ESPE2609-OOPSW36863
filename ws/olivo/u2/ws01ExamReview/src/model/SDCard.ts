
export class SDCard {

    constructor(
        public id: number,
        public brand: string,
        public capacityGB: number,
        public speedClass: string
    ) {}

    public getDetails(): string {
        return `
ID: ${this.id}
Brand: ${this.brand}
Capacity: ${this.capacityGB} GB
Speed Class: ${this.speedClass}
`;
    }
}
