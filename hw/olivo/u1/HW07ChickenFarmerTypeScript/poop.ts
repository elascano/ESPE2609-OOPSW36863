export class Poop {
    private static counterId: number = 0;
    public id: number;
    public color: string;
    public consistency: string;

    constructor(color: string, consistency: string, id?: number) {
        if (id !== undefined) {
            this.id = id;
            if (id > Poop.counterId) {
                Poop.counterId = id;
            }
        } else {
            Poop.counterId++;
            this.id = Poop.counterId;
        }
        this.color = color;
        this.consistency = consistency;
    }

    public toDict(): any {
        return {
            id: this.id,
            color: this.color,
            consistency: this.consistency
        };
    }

    public static fromDict(data: any): Poop {
        return new Poop(data.color, data.consistency, data.id);
    }

    public toString(): string {
        return `Poop [ID: ${this.id}, Color: ${this.color}, Consistency: ${this.consistency}]`;
    }
}