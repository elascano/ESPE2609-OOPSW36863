export class Mask {
    private _id: number;
    private _name: string;
    private _size: CharacterData;
    private _isWearing: boolean;

    constructor(id: number, name: string, size: CharacterData, isWearing: boolean) {
        this._id = id;
        this._name = name;
        this._size = size;
        this._isWearing = isWearing;
    }
    

    get id(): number {
        return this._id;
    }

    get name(): string {
        return this._name;
    }

    get size(): CharacterData {
        return this._size;
    }

    get isWearing(): boolean {
        return this._isWearing;
    }

    public generateJsonFile () {
        
    }
}