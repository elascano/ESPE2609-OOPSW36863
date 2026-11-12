import * as path from "path";
import { FlashDriveJsonFile } from "./data/FlashDriveJsonFile";
import { ConsoleInput } from "./view/ConsoleInput";
import { ConsoleMenu } from "./view/ConsoleMenu";

const DATA_FILE_PATH: string = path.join(__dirname, "..", "data", "flashDrives.json");

function main(): void {
    const jsonFile = new FlashDriveJsonFile(DATA_FILE_PATH);
    const consoleInput = new ConsoleInput();
    const menu = new ConsoleMenu(jsonFile, consoleInput);

    menu.start();
}

main();
