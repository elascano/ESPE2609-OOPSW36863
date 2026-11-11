import * as readline from "readline";

type AnswerReceiver = (answer: string) => void;

/**
 * View helper class: reads the user's answers from the console.
 * It also validates the answers (non-empty text, positive whole numbers).
 */
export class ConsoleInput {
    private readonly lineReader: readline.Interface;
    private readonly linesNotYetRequested: string[] = [];
    private receiverOfNextAnswer: AnswerReceiver | null = null;

    constructor() {
        this.lineReader = readline.createInterface({
            input: process.stdin,
            output: process.stdout,
            terminal: false
        });
        this.lineReader.on("line", (typedLine: string) => this.handleTypedLine(typedLine));
    }

    /** Shows a question and waits for the user's answer (already trimmed). */
    public ask(question: string): Promise<string> {
        process.stdout.write(question);

        return new Promise((resolve) => {
            const alreadyTypedLine = this.linesNotYetRequested.shift();
            if (alreadyTypedLine !== undefined) {
                resolve(alreadyTypedLine.trim());
            } else {
                this.receiverOfNextAnswer = resolve;
            }
        });
    }

    /** Keeps asking until the user types some text. */
    public async askNonEmptyText(question: string): Promise<string> {
        while (true) {
            const answer: string = await this.ask(question);
            if (answer !== "") {
                return answer;
            }
            console.log("  This field cannot be empty.");
        }
    }

    /** Keeps asking until the user types a whole number greater than 0. */
    public async askPositiveInteger(question: string): Promise<number> {
        while (true) {
            const answer: string = await this.ask(question);
            if (this.isPositiveInteger(answer)) {
                return Number(answer);
            }
            console.log("  Invalid value. Enter a whole number greater than 0.");
        }
    }

    public close(): void {
        this.lineReader.close();
    }

    /**
     * Delivers the typed line to the question that is waiting for it.
     * If no question is waiting yet, the line is kept for the next question.
     */
    private handleTypedLine(typedLine: string): void {
        if (this.receiverOfNextAnswer === null) {
            this.linesNotYetRequested.push(typedLine);
            return;
        }

        const deliverAnswer: AnswerReceiver = this.receiverOfNextAnswer;
        this.receiverOfNextAnswer = null;
        deliverAnswer(typedLine.trim());
    }

    private isPositiveInteger(text: string): boolean {
        const number: number = Number(text);
        return text !== "" && Number.isInteger(number) && number > 0;
    }
}
