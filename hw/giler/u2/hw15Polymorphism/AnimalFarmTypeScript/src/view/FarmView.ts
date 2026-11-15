export class FarmView {
    printTitle(): void { console.log("Hello this is Ariel's Animal Farm - Abstraction Exercise"); }
    printSeparator(title: string): void { console.log(`\n--- ${title} ---`); }
    printMessage(msg: string): void { console.log(msg); }
    printAnimalType(varName: string, className: string): void { console.log(`${varName} is a --> ${className}`); }
}
