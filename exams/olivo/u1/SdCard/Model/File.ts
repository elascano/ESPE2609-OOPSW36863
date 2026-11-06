export class File {
    private static idCounter = 0;
    private id: number;
    private name: string;
    constructor( name: string, id? : number) {
        if (id !== undefined) {
            this.id = id;
            if (id > File.idCounter) {
                File.idCounter = id;
            }
        } else {
            File.idCounter++;
            this.id = File.idCounter;
        }
        this.name = name;
    }
     toDict(): any {
        return {
            id: this.id,
            name: this.name
        };
    }

}