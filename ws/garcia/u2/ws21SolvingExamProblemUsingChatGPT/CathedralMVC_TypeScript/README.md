# Cathedral MVC - TypeScript

A small console application to register Ecuadorian cathedrals, store them in one JSON file, and read the saved records.

## 1. Requirements

- Node.js (LTS)
- Apache NetBeans
- TypeScript dependencies installed with npm

## 2. Open in NetBeans

1. Extract the ZIP file.
2. Open Apache NetBeans.
3. Select **File > Open Project** (or **Open Folder**, depending on your NetBeans version).
4. Select the extracted `CathedralMVC_TypeScript` folder.
5. Open the NetBeans terminal (or a terminal in this folder).

This is a Node.js/TypeScript project, not a Java/Maven project. NetBeans versions differ in their Node.js support. If your NetBeans installation does not offer Node.js project actions, open the project folder and use its integrated terminal to run the npm commands below.

## 3. Install and run

```bash
npm install
npm run dev
```

To compile and run the JavaScript output:

```bash
npm run build
npm start
```

## 4. Application options

1. Register a cathedral: asks for ID, name, city, province and architectural style, then saves it.
2. Show saved cathedrals: reads the JSON file and displays all records.
3. Exit.

The file used by the application is `data/cathedrals.json`. It already contains three example records from Ecuador. New records are appended to the array and saved back to the same file.

## 5. MVC structure

```text
CathedralMVC_TypeScript/
├── data/
│   └── cathedrals.json
├── src/
│   ├── controllers/
│   │   └── CathedralController.ts
│   ├── models/
│   │   └── Cathedral.ts
│   ├── views/
│   │   └── CathedralView.ts
│   └── main.ts
├── UML/
│   └── Cathedral-Class-Diagram.puml
├── package.json
└── tsconfig.json
```

- **Model:** `Cathedral` defines the data and the two file operations: `readFromJson()` and `saveToJson()`.
- **View:** `CathedralView` displays the menu and collects input from the user.
- **Controller:** `CathedralController` coordinates the view, model and JSON file.

## 6. Attributes and methods

The `Cathedral` class has the mandatory `id` plus four additional attributes:

- `name`
- `city`
- `province`
- `architecturalStyle`

Its two file methods are:

- `readFromJson(filePath)`: reads the JSON file and returns an array of `Cathedral` objects.
- `saveToJson(filePath, cathedrals)`: saves the array of objects into the JSON file.

**ArrayList note:** TypeScript does not have Java's `ArrayList` class. The equivalent collection is an array (`Cathedral[]`), which supports operations such as `push()`, `some()` and `forEach()`.

## 7. Class diagram in Visual Paradigm

The UML reference is in `UML/Cathedral-Class-Diagram.puml`. Use it as the exact blueprint to draw the editable diagram in Visual Paradigm:

1. Open Visual Paradigm and choose **Diagram > New > Class Diagram**.
2. Name it `Cathedral MVC Class Diagram`.
3. Create the classes `Cathedral`, `CathedralView` and `CathedralController`, plus the `cathedrals.json` artifact.
4. Copy the attributes, operations and relationships from the `.puml` file.
5. Save the Visual Paradigm project as a `.vpp` file.

The `.puml` file is a textual UML reference; it is not a native `.vpp` project file.

## 8. Clean Code decisions

- English identifiers using `camelCase` for attributes and methods.
- Spanish names are preserved for Ecuadorian cathedrals.
- One class per file and separated MVC responsibilities.
- Explicit types and `async/await` for file operations.
- Validation for empty fields and duplicate IDs.
- Consistent indentation and descriptive names.
