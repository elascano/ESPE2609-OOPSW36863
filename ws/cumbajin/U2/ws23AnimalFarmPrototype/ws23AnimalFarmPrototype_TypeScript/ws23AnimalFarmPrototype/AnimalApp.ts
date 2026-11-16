/**
 * Workshop 23 - Animal Farm Prototype (TypeScript)
 * Author: Dylan Cumbajin, MosQ, @ESPE
 * Main entry point: Animal App
 */
import { AnimalController } from "./controller/AnimalController";
import { AnimalView } from "./view/AnimalView";

async function main(): Promise<void> {
    const view = new AnimalView();
    const controller = new AnimalController(view);
    try {
        await controller.run();
    } finally {
        view.close();
    }
}

if (require.main === module) {
    main().catch((error: unknown) => {
        console.error(error instanceof Error ? error.message : String(error));
        process.exitCode = 1;
    });
}

export { main };
