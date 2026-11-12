# Animal Farm — TypeScript

TypeScript version of the Java inheritance exercise. Each class has its own
file. Code, comments, and application messages are in English.

## Structure

```text
typescript/
├── ec/edu/espe/animalfarm/
│   ├── controller/       # Reserved for future controllers
│   ├── model/
│   │   ├── Chicken.ts
│   │   ├── Cow.ts
│   │   ├── FarmAnimal.ts
│   │   ├── Pig.ts
│   │   └── Sheep.ts
│   └── view/
│       └── AnimalFarm.ts # Main class
├── animal_farm.ts        # Starts AnimalFarm.main()
├── package.json         # Commands and local compiler dependency
├── package-lock.json    # Exact installed dependency versions
├── tsconfig.json        # Compiler settings
├── node_modules/        # Installed development tools
├── dist/                # Generated JavaScript
└── README.md
```

The folder path `ec/edu/espe/animalfarm` follows the reference Java package
`ec.edu.espe.animalfarm`. Imports connect the files in TypeScript.
`model` contains the parent class and its four subclasses. `view` creates and
prints the example animals. `controller` is reserved, as in the reference image.

## Run

With Node.js and npm installed, open a terminal in this `typescript` folder:

```powershell
npm.cmd install
npm.cmd start
```

Installation is needed on first setup or after changing dependencies.
`npm.cmd start` compiles the TypeScript files and runs the generated program.
To compile without running, use `npm.cmd run build`.

TypeScript does not use Python's `venv`. This project installs its compiler
locally in `node_modules`; npm tracks it in `package.json` and `package-lock.json`.
The application itself needs no external runtime packages.

## Java to TypeScript

| Java | TypeScript |
| --- | --- |
| `class Pig extends FarmAnimal` | `class Pig extends FarmAnimal` |
| `Pig(...)` constructor | `constructor(...)` |
| `super(id, breed, bornOnDate)` | `super(id, breed, bornOnDate)` |
| `int`, `float` | `number` |
| `String` | `string` |
| `boolean`, `Date` | `boolean`, `Date` |
| `@Override` | `override` |
| `System.out.println(...)` | `console.log(...)` |

Constructors, private fields, getters, setters, and `toString()` follow the Java
exercise. The pig's internal boolean is named `castrated` so it does not collide
with its `isCastrated()` method in TypeScript.

For fidelity to the exercise, `getAgeInMonths()` still returns `0`, and the cow's
example birth date remains September 20, 2123. This is the normalized result
of the original Java `new Date(222, 20, 20)`. Dates display using local time.
