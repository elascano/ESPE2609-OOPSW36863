export declare class Chicken {
    private id;
    private name;
    private color;
    private bornOnDate;
    private ageInYears;
    private molting;
    constructor(id: number, name: string, color: string, bornOnDate: Date, molting: boolean);
    computeAgeInYears(): number;
    doStuff(): void;
    private cluck;
    private wander;
    private eat;
    private drink;
    private poop;
    private layAnEgg;
    getId(): number;
    setId(id: number): void;
    getName(): string;
    setName(name: string): void;
    getColor(): string;
    setColor(color: string): void;
    getBornOnDate(): Date;
    setBornOnDate(bornOnDate: Date): void;
    getAgeInYears(): number;
    setAgeInYears(): void;
    isMolting(): boolean;
    setMolting(molting: boolean): void;
    toString(): string;
}
//# sourceMappingURL=Chicken.d.ts.map