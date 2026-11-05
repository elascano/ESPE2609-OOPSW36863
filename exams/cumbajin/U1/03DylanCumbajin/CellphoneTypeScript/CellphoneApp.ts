import { Cellphone } from "./Cellphone";
import * as fs from "node:fs";
import { createInterface } from "node:readline/promises";
import { stdin, stdout } from "node:process";

const scanner = createInterface({
    input: stdin,
    output: stdout
});

const filePath = "cellphones.json";
let cellphones: Cellphone[] = [];

function saveCellphones(): void {
    const json = JSON.stringify(cellphones, null, 2);
    fs.writeFileSync(filePath, json, "utf-8");
}

function loadCellphones(): void {
    if (!fs.existsSync(filePath)) {
        cellphones = [];
        return;
    }

    const json = fs.readFileSync(filePath, "utf-8");
    const data = JSON.parse(json);

    if (!Array.isArray(data)) {
        throw new Error("The JSON file must contain a list.");
    }

    const loaded: Cellphone[] = [];

    for (const item of data) {
        if (
            item === null ||
            typeof item !== "object" ||
            !Number.isInteger(item.id) ||
            item.id <= 0 ||
            typeof item.brand !== "string" ||
            item.brand.trim() === "" ||
            typeof item.model !== "string" ||
            item.model.trim() === "" ||
            typeof item.price !== "number" ||
            !Number.isFinite(item.price) ||
            item.price < 0 ||
            loaded.some(cellphone => cellphone.getId() === item.id)
        ) {
            throw new Error("Invalid or duplicate data in JSON.");
        }

        loaded.push(
            new Cellphone(item.id, item.brand, item.model, item.price)
        );
    }

    cellphones = loaded;
}

async function registerCellphone(): Promise<void> {
    const id = Number(await scanner.question("ID: "));

    if (!Number.isInteger(id) || id <= 0) {
        console.log("Enter a positive integer ID.");
        return;
    }

    if (cellphones.some(cellphone => cellphone.getId() === id)) {
        console.log("That ID already exists.");
        return;
    }

    const brand = (await scanner.question("Brand: ")).trim();
    const model = (await scanner.question("Model: ")).trim();
    const priceText = (await scanner.question("Price: ")).trim();
    const price = Number(priceText);

    if (
        brand === "" ||
        model === "" ||
        priceText === "" ||
        !Number.isFinite(price) ||
        price < 0
    ) {
        console.log("Invalid data. Check the brand, model and price.");
        return;
    }

    const cellphone = new Cellphone(id, brand, model, price);
    cellphones.push(cellphone);

    try {
        saveCellphones();
    } catch (error) {
        cellphones.pop();
        throw error;
    }

    console.log("Cellphone registered and saved.");
}

function viewCellphones(): void {
    if (cellphones.length === 0) {
        console.log("No cellphones registered.");
        return;
    }

    for (const cellphone of cellphones) {
        console.log(cellphone.toString());
    }
}

async function showMenu(): Promise<void> {
    let option: string;

    do {
        console.log("\nCELLPHONE MANAGEMENT");
        console.log("1. Register cellphone");
        console.log("2. Read and display cellphones from JSON");
        console.log("0. Exit");

        option = (await scanner.question("Choose an option: ")).trim();

        try {
            switch (option) {
                case "1":
                    await registerCellphone();
                    break;

                case "2":
                    loadCellphones();
                    viewCellphones();
                    break;

                case "0":
                    console.log("Goodbye!");
                    break;

                default:
                    console.log("Invalid option.");
            }
        } catch (error) {
            console.log(
                error instanceof Error ? error.message : "Operation failed."
            );
        }
    } while (option !== "0");
}

async function main(): Promise<void> {
    try {
        loadCellphones();
        await showMenu();
    } catch (error) {
        console.log(
            error instanceof Error ? error.message : "Could not start."
        );
    } finally {
        scanner.close();
    }
}

main();