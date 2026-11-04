import { Chicken } from "./Chicken";
export declare class ChickenCoop {
    private chickenCoopId;
    private chickens;
    private currentIndex;
    constructor(chickenCoopId: number, chickens: (Chicken | null)[]);
    add(chicken: Chicken): void;
    remove(chickenId: number): void;
    next(): Chicken | null;
    resetIteration(): void;
    getChickenCoopId(): number;
    setChickenCoopId(chickenCoopId: number): void;
    getChickens(): (Chicken | null)[];
    setChickens(chickens: (Chicken | null)[]): void;
    toString(): string;
}
//# sourceMappingURL=ChickenCoop.d.ts.map