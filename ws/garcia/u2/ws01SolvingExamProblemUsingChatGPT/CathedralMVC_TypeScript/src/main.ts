import { CathedralController } from "./controllers/CathedralController";
import { CathedralView } from "./views/CathedralView";

async function main(): Promise<void> {
    const view = new CathedralView();
    const controller = new CathedralController(view);
    await controller.start();
}

main().catch((error: unknown) => {
    console.error("Application error:", error);
    process.exitCode = 1;
});