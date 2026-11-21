export class Location {
    private id: number;
    private description: string;

    constructor(id: number, description: string) {
        this.id = id;
        this.description = description;
    }

    toString(): string {
        return "{id= " + this.id + ", description= " + this.description + "}";
    }
}