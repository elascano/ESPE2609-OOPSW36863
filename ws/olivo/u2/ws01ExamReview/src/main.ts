
import { SDCardRepository } from "./model/SDCardRepository";
import { SDCardView } from "./view/SDCardView";
import { SDCardController } from "./controller/SDCardController";

function main(): void {

    const repository = new SDCardRepository();

    const view = new SDCardView();

    const controller = new SDCardController(
        repository,
        view
    );

    controller.start();
}

main();
