import { File } from "./File";
export class Folder{
    private static idCounter = 0;
    private id: number;
    private name: string;
    private files: File[];
    constructor(name: string, id?: number) {
        if (id !== undefined) {
            this.id = id;
            if (id > Folder.idCounter) {
                Folder.idCounter = id;
            }
        } else {
            Folder.idCounter++;
            this.id = Folder.idCounter;
        }
        this.name = name;
        this.files = [];

    }
    public addFile(file: File): void {
        this.files.push(file);
    }
    public toDict(): any {
        return {
            id: this.id,
            name: this.name,
            files: this.files.map(file => file.toDict())
        };
    }
}