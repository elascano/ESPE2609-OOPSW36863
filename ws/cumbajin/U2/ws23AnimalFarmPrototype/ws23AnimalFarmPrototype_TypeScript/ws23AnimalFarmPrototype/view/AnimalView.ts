/** The view handles menus, prompts, and reusable keyboard input. */
import * as readline from "node:readline";

export class AnimalView {
    private readonly input: readline.Interface;
    private readonly lines: string[] = [];
    private readonly waiting: Array<(line: string | null) => void> = [];
    private ended = false;

    constructor() {
        this.input = readline.createInterface({ input: process.stdin, crlfDelay: Infinity });
        this.input.on("line", (line) => {
            const waiter = this.waiting.shift();
            if (waiter) waiter(line);
            else this.lines.push(line);
        });
        this.input.on("close", () => {
            this.ended = true;
            while (this.waiting.length > 0) {
                this.waiting.shift()?.(null);
            }
        });
    }

    close(): void {
        this.input.close();
    }

    private async ask(message: string): Promise<string> {
        process.stdout.write(message);
        if (this.lines.length > 0) return this.lines.shift()!;
        if (this.ended) throw new Error("Input ended before finishing the menu.");
        const response = await new Promise<string | null>((resolve) => {
            this.waiting.push(resolve);
        });
        if (response === null) throw new Error("Input ended before finishing the menu.");
        return response;
    }

    async showMenu(): Promise<number> {
        console.log("========== FARM ANIMAL MENU ==========");
        console.log("1. Create Chicken");
        console.log("2. Create Cow");
        console.log("3. Create Pig");
        console.log("4. Create Sheep");
        console.log("5. Exit");
        return this.readInt("Choose an option: ");
    }

    async readInt(message: string): Promise<number> {
        while (true) {
            const raw = (await this.ask(message)).trim();
            const number = Number(raw);
            if (/^[+-]?\d+$/.test(raw) && Number.isSafeInteger(number)) return number;
            console.log("Invalid integer. Please try again.");
        }
    }

    async readFloat(message: string): Promise<number> {
        while (true) {
            const raw = (await this.ask(message)).trim().replace(",", ".");
            const number = Number(raw);
            if (raw !== "" && Number.isFinite(number)) return number;
            console.log("Invalid number. Please try again.");
        }
    }

    async readBool(message: string): Promise<boolean> {
        while (true) {
            const value = (await this.ask(message)).trim().toLowerCase();
            if (value === "true") return true;
            if (value === "false") return false;
            console.log("Please enter true or false.");
        }
    }

    async readId(): Promise<number> {
        return this.readInt("Enter id: ");
    }

    async readBread(): Promise<string> {
        // Keep the word "bread" as written in the original Java project.
        return (await this.ask("Enter bread: ")).trim();
    }

    async readDate(label: string): Promise<Date> {
        while (true) {
            console.log(`Enter ${label}:`);
            const day = await this.readInt("Day: ");
            const month = await this.readInt("Month: ");
            const year = await this.readInt("Year: ");
            // Use UTC so calendar dates do not change with the computer time zone.
            const date = new Date(0);
            date.setUTCHours(0, 0, 0, 0);
            date.setUTCFullYear(year, month - 1, day);
            if (year >= 1 && date.getUTCFullYear() === year &&
                    date.getUTCMonth() === month - 1 && date.getUTCDate() === day) {
                return date;
            }
            console.log("Invalid date. Please enter a real calendar date.");
        }
    }
}
