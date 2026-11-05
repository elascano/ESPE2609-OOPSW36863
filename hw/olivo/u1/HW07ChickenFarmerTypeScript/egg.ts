export class Egg {
    private static idCounter: number = 0;
    public id: number;
    public size: string;

    constructor(size: string, id?: number) {
        if (id !== undefined) {
            this.id = id;
            if (id > Egg.idCounter) {
                Egg.idCounter = id;
            }
        } else {
            Egg.idCounter++;
            this.id = Egg.idCounter;
        }
        this.size = size;
    }

    public toDict(): any {
        return {
            id: this.id,
            size: this.size
        };
    }

    public static fromDict(data: any): Egg {
        return new Egg(data.size, data.id);
    }

    public toString(): string {
        return `Egg [ID: ${this.id}, Size: ${this.size}]`;
    }
}