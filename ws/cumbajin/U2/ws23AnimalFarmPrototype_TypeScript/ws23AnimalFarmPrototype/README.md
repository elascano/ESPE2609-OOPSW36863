# ws23AnimalFarmPrototype — TypeScript

Workshop 23: **Animal Farm Prototype** in TypeScript, based on the original Java/NetBeans project.

**Author:** Dylan Cumbajin, MosQ, @ESPE.

## Structure

```text
ws23AnimalFarmPrototype/
├── AnimalApp.ts              # Main file: Animal App
├── controller/
│   └── AnimalController.ts   # Create and display each animal
├── model/
│   ├── FarmAnimal.ts         # Parent class
│   ├── Chicken.ts            # Child class
│   ├── Cow.ts                # Child class
│   ├── Pig.ts                # Child class
│   └── Sheep.ts              # Child class
├── view/
│   └── AnimalView.ts         # Menu and input helpers
├── tests/
│   └── animals.test.ts       # Automated tests
├── dist/                     # Precompiled JavaScript
├── package.json
├── tsconfig.json
└── .vscode/launch.json        # "Animal App" debug configuration
```

## Requirements

- Node.js 18+ (preferably 22)
- npm (included with Node.js)

## Run in VS Code

1. Extract the ZIP and open **ws23AnimalFarmPrototype** as your folder in VS Code.
2. Open a terminal in this folder (where `package.json` is located).
3. Run the following commands:

```powershell
npm install
npm run build
npm start
```

**Shortcut:** Since `dist/` is included, you can also start immediately if Node.js is installed:

```powershell
node dist/AnimalApp.js
```

For code changes, rebuild first with `npm run build`, then run `npm start` again.
You may use **Run and Debug → Animal App** inside VS Code after `npm install`.

## Menu

```text
========== FARM ANIMAL MENU ==========
1. Create Chicken
2. Create Cow
3. Create Pig
4. Create Sheep
5. Exit
Choose an option:
```

Enter your own `id`, `bread`, and animal-specific information. Booleans use `true` / `false`.
Cow milk accepts both `150.2` and `150,2`. Dates are entered as **day, month, year**.

## OOP concepts

- **Inheritance:** Each animal extends `FarmAnimal`.
- **Encapsulation:** private attributes and getters/setters.
- **Constructors:** `constructor` + `super(...)`.
- **Polymorphism:** Child classes override `toString()`.
- **Modularity:** separate model, view, and controller folders.

The spelling `bread`, `numberOffLatIsMonth`, `lastSheering` matches the original Java workshop. `getAgeInMonths()` returns `0` as it did in the provided Java source.

## Tests

```powershell
npm test
```

The ZIP excludes `node_modules` to keep it small. Do not run `npm` from the parent folder; the commands belong in the `ws23AnimalFarmPrototype` folder.
