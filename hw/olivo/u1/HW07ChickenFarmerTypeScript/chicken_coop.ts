import { Chicken } from './chicken';

export class ChickenCoop {
    private static idCounter: number = 0;
    public id: number;
    public chickens: Chicken[];
    private iteratorIndex: number = 0;

    constructor(chickens?: Chicken[], id?: number) {
        if (id !== undefined) {
            this.id = id;
            if (id > ChickenCoop.idCounter) {
                ChickenCoop.idCounter = id;
            }
        } else {
            ChickenCoop.idCounter++;
            this.id = ChickenCoop.idCounter;
        }
        this.chickens = chickens !== undefined ? chickens : [];
    }

    public addChicken(chicken: Chicken): void {
        this.chickens.push(chicken);
        console.log(`Added ${chicken.toString()}`);
    }

    public removeChicken(chickenId: number): boolean {
        const index = this.chickens.findIndex(c => c.id === chickenId);
        if (index !== -1) {
            const removed = this.chickens.splice(index, 1)[0];
            console.log(`Removed ${removed.toString()}`);
            return true;
        }
        console.log(`Chicken with ID ${chickenId} not found`);
        return false;
    }

    public getChicken(chickenId: number): Chicken | null {
        return this.chickens.find(c => c.id === chickenId) || null;
    }

    public resetOperation(): void {
        this.iteratorIndex = 0;
    }

    public next(): Chicken | null {
        if (this.iteratorIndex < this.chickens.length) {
            const chicken = this.chickens[this.iteratorIndex];
            this.iteratorIndex++;
            return chicken;
        }
        return null;
    }

    public toDict(): any {
        return {
            id: this.id,
            chickens: this.chickens.map(c => c.toDict())
        };
    }

    public static fromDict(data: any): ChickenCoop {
        const chickens = data.chickens.map((cData: any) => Chicken.fromDict(cData));
        return new ChickenCoop(chickens, data.id);
    }

    public toString(): string {
        return `ChickenCoop [ID: ${this.id}, Total Chickens: ${this.chickens.length}]`;
    }
}