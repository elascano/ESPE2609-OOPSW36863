import { Folder } from "./Folder";
export class SdCard {
    private static idCounter = 0;
    private id: number;
    private name: string;
    private folders: Folder[];
    constructor(name: string, id?: number) {
        if (id !== undefined) {
            this.id = id;
            if (id > SdCard.idCounter) {
                SdCard.idCounter = id;
            }   
        } else {    

            SdCard.idCounter++;
            this.id = SdCard.idCounter;
        }
        this.name = name;
        this.folders = [];
    }
}