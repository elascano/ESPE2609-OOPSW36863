import test from "node:test";
import assert from "node:assert/strict";
import { spawnSync } from "node:child_process";
import { resolve } from "node:path";
import { FarmAnimal } from "../model/FarmAnimal";
import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

function date(year: number, month: number, day: number): Date {
    return new Date(Date.UTC(year, month - 1, day));
}

test("all animals inherit FarmAnimal and preserve Java output", () => {
    const chicken = new Chicken(1, "Leghorn", date(2024, 3, 15), false, 25, false);
    const cow = new Cow(true, 150.2, 2, "Holstein", date(2021, 6, 10));
    const pig = new Pig(4, "Yorkshire", date(2024, 8, 12));
    const sheep = new Sheep(date(2026, 9, 5), 3, "Merino", date(2023, 4, 20));

    for (const animal of [chicken, cow, pig, sheep]) {
        assert.ok(animal instanceof FarmAnimal);
    }
    assert.equal(chicken.toString(), "Chicken{FarmAnimal{id=1, bread=Leghorn, bornOnDate=2024}, isMolting=false, numberOffLatIsMonth=25, isMeat=false}");
    assert.equal(cow.toString(), "Cow{FarmAnimal{id=2, bread=Holstein, bornOnDate=2021}, isProducingMilk=true, litersOfMilkPerWeek=150.2}");
    assert.equal(pig.toString(), "Pig{FarmAnimal{id=4, bread=Yorkshire, bornOnDate=2024}}");
    assert.equal(sheep.toString(), "Sheep{FarmAnimal{id=3, bread=Merino, bornOnDate=2023}, lastSheering=2026}");
    assert.equal(chicken.getAgeInMonths(), 0);
});

test("menu creates the four animals (including comma decimals)", () => {
    const input = [
        "1", "1", "Leghorn", "15", "3", "2024", "false", "25", "false",
        "2", "2", "Holstein", "10", "6", "2021", "true", "150,2",
        "3", "4", "Yorkshire", "12", "8", "2024",
        "4", "3", "Merino", "20", "4", "2023", "5", "9", "2026",
        "5", "",
    ].join("\n");
    const app = resolve(__dirname, "..", "AnimalApp.js");
    const result = spawnSync(process.execPath, [app], { input, encoding: "utf8", timeout: 5000 });
    assert.equal(result.status, 0, result.stderr);
    for (const expected of ["Chicken -> Chicken{", "Cow -> Cow{", "Pig -> Pig{", "Sheep -> Sheep{", "litersOfMilkPerWeek=150.2", "Milking the cow", "Exiting program..."]) {
        assert.ok(result.stdout.includes(expected), `Missing: ${expected}\n${result.stdout}`);
    }
});
