# Cellphone — Student 03 — TypeScript

## Objective
Create and read `Cellphone` objects using a dynamic `ArrayList<Cellphone>` and **one JSON file**: `data/cellphones.json`.

Each cellphone has four attributes:
- `id` (mandatory, unique)
- `brand`
- `model`
- `storageGB`

## MVC organization
- `src/model/` — Cellphone class and generic ArrayList
- `src/view/` — Console menu, inputs, and output
- `src/controller/` — Create/read logic and unique-ID check
- `src/repository/` — Read/write the JSON file
- `src/main.ts` — Application entry point

TypeScript does **not** include Java's `java.util.ArrayList`. This project implements a generic `ArrayList<T>` class backed by TypeScript's dynamic `Array<T>`.

## Requirements
Node.js and npm installed; TypeScript developer dependencies installed with `npm install`.

## Run from the project root (PowerShell, CMD, or terminal)
```shell
npm install
npm run build
npm start
```

After building once, you can also run `node dist/main.js`. Follow the interactive menu:
1. Create cellphone: enter ID, brand, model, storage (GB).
2. Read cellphones from the JSON file.
3. Exit.

The program creates `data/cellphones.json` automatically if it is missing. New cellphones are appended to the in-memory ArrayList, then all saved back to the **same JSON file**. Reading always reloads the file.

## Test
```shell
npm run build
npm test
```

## Deliverables
- Source project folder (this folder; exclude `node_modules`)
- Class diagram: `diagram/Cellphone_Class_Diagram.png` (and its editable `.dot` file)
- Execution-evidence document: `evidence/Execution_Evidence.docx`
- JSON file: `data/cellphones.json`

**Important for submission:** If the class asks for screenshots in the commander's Google document, upload/paste the relevant screenshots there too. The example screenshot document is a starting point; take your own screenshots in NetBeans or the terminal if your teacher requires your local execution.

## NetBeans project
This folder includes `nbproject/project.xml` and `build.xml`, so you can try **File > Open Project** in NetBeans as an **Ant Free-Form project**. The NetBeans **Build Project** action runs `npm run build` through Ant; run the interactive console using `npm start` in a terminal in the project folder. Install dependencies with `npm install` first.

Student 03 is assigned **TypeScript**, not Java. These folders resemble packages, but TypeScript uses modules and `import` statements instead of Java's `package` statements. TypeScript editor integration in NetBeans depends on your installation or extensions; Node.js/npm is the actual runtime.
