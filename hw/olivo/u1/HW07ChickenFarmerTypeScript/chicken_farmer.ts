import { ChickenCoop } from './chicken_coop';

export class ChickenFarmer {
    private static idCounter: number = 0;
    public id: number;
    public name: string;
    public coops: ChickenCoop[];
    private iteratorIndex: number = 0;

    constructor(name: string, coops?: ChickenCoop[], id?: number) {
        if (id !== undefined) {
            this.id = id;
            if (id > ChickenFarmer.idCounter) {
                ChickenFarmer.idCounter = id;
            }
        } else {
            ChickenFarmer.idCounter++;
            this.id = ChickenFarmer.idCounter;
        }
        this.name = name;
        this.coops = coops !== undefined ? coops : [];
    }

    public addCoop(coop: ChickenCoop): void {
        this.coops.push(coop);
        console.log(`Farmer ${this.name} added Coop #${coop.id}`);
    }

    public removeCoop(coopId: number): boolean {
        const index = this.coops.findIndex(c => c.id === coopId);
        if (index !== -1) {
            this.coops.splice(index, 1);
            console.log(`Farmer ${this.name} removed Coop #${coopId}`);
            return true;
        }
        console.log(`Coop with ID ${coopId} not found`);
        return false;
    }

    public resetIteration(): void {
        this.iteratorIndex = 0;
    }

    public next(): ChickenCoop | null {
        if (this.iteratorIndex < this.coops.length) {
            const coop = this.coops[this.iteratorIndex];
            this.iteratorIndex++;
            return coop;
        }
        return null;
    }

    public toDict(): any {
        return {
            id: this.id,
            name: this.name,
            coops: this.coops.map(coop => coop.toDict())
        };
    }

    public static fromDict(data: any): ChickenFarmer {
        const coops = data.coops.map((coopData: any) => ChickenCoop.fromDict(coopData));
        return new ChickenFarmer(data.name, coops, data.id);
    }

    public toString(): string {
        return `ChickenFarmer [ID: ${this.id}, Name: ${this.name}, Coops: ${this.coops.length}]`;
    }
}