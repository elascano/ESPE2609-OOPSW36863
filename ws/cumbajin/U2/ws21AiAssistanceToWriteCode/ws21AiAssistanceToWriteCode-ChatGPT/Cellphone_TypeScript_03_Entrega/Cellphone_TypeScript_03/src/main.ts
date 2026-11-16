import { CellphoneController } from './controller/CellphoneController';
import { CellphoneRepository } from './repository/CellphoneRepository';
import { CellphoneView } from './view/CellphoneView';

/** Dependency setup (main entry point). */
async function main(): Promise<void> {
  const repository = new CellphoneRepository();
  const controller = new CellphoneController(repository);
  const view = new CellphoneView(controller);
  await view.start();
}

main().catch((error: unknown) => {
  console.error('Fatal error:', error);
  process.exitCode = 1;
});
