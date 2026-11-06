import * as path from "path";
import { MaskRepository } from "./models/MaskRepository";
import { ConsoleView } from "./views/ConsoleView";
import { MaskController } from "./controllers/MaskController";

// El JSON se guarda en <proyecto>/data/masks.json
const filePath = path.resolve(__dirname, "..", "data", "masks.json");

const repository = new MaskRepository(filePath);
const view = new ConsoleView();
const controller = new MaskController(repository, view);

controller.run().catch((error) => {
  console.error("Error inesperado:", error);
  process.exit(1);
});
