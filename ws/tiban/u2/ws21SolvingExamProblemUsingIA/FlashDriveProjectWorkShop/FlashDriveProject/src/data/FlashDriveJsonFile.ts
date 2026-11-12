import * as fs from "fs";
import { FlashDrive } from "../model/FlashDrive";
import { FlashDriveRecord } from "../model/FlashDriveRecord";

const FILE_ENCODING = "utf-8";
const JSON_INDENTATION_SPACES = 4;

/**
 * Data class: saves and reads the list of flash drives in/from a JSON file.
 * Uses only the "fs" module that comes with Node.js (no external libraries).
 */
export class FlashDriveJsonFile {
    private readonly filePath: string;

    constructor(filePath: string) {
        this.filePath = filePath;
    }

    public getFilePath(): string {
        return this.filePath;
    }

    /** Writes the whole list of flash drives into the JSON file. */
    public save(flashDrives: FlashDrive[]): void {
        const records: FlashDriveRecord[] = flashDrives.map((flashDrive) => flashDrive.toRecord());
        const jsonText: string = JSON.stringify(records, null, JSON_INDENTATION_SPACES);
        fs.writeFileSync(this.filePath, jsonText, FILE_ENCODING);
    }

    /** Reads the JSON file and returns the list of flash drives (empty if there is no data). */
    public read(): FlashDrive[] {
        const jsonText: string = this.readFileText();
        if (jsonText.trim() === "") {
            return [];
        }

        const records: FlashDriveRecord[] = JSON.parse(jsonText);
        return records.map((record) => FlashDrive.fromRecord(record));
    }

    /** Returns the text of the file, or an empty text if the file does not exist yet. */
    private readFileText(): string {
        if (!fs.existsSync(this.filePath)) {
            return "";
        }
        return fs.readFileSync(this.filePath, FILE_ENCODING);
    }
}
