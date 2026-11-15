import { FarmController } from './controller/FarmController';

function main() {
    const controller = new FarmController();

    console.log("=== Bienvenido a AnimalFarm TypeScript (MVC) ===\n");

    controller.addChicken(1, "Leghorn", new Date("2023-01-15"), false);
    controller.addCow(2, "Holstein", new Date("2022-05-10"), true);
    controller.addChicken(3, "Plymouth Rock", new Date("2023-06-20"), true);

    controller.displayAllAnimals();
}

main();
