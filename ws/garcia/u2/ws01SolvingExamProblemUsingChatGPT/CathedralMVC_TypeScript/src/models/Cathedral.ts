import { promises as fs } from "node:fs";

export class Cathedral {
    constructor(
        public id: string,
        public name: string,
        public city: string,
        public province: string,
        public architecturalStyle: string
    ) {}

    public static async readFromJson(filePath: string): Promise<Cathedral[]> {
        try {
            const fileContent = await fs.readFile(filePath, "utf-8");
            const parsedData: unknown = JSON.parse(fileContent);

            if (!Array.isArray(parsedData)) {
                throw new Error("The JSON file must contain an array of cathedrals.");
            }

            return parsedData.map((item: Record<string, unknown>) => {
                return new Cathedral(
                    String(item.id),
                    String(item.name),
                    String(item.city),
                    String(item.province),
                    String(item.architecturalStyle)
                );
            });
        } catch (error) {
            if (isNodeError(error) && error.code === "ENOENT") {
                return [];
            }
            throw error;
        }
    }

    public static async saveToJson(
        filePath: string,
        cathedrals: Cathedral[]
    ): Promise<void> {
        const jsonContent = JSON.stringify(cathedrals, null, 4);
        await fs.writeFile(filePath, jsonContent, "utf-8");
    }
}

function isNodeError(error: unknown): error is NodeJS.ErrnoException {
    return error instanceof Error && "code" in error;
}