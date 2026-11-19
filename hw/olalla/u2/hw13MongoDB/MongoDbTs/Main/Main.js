const readline = require("readline/promises");
const { MongoClient, ServerApiVersion } = require("mongodb");

const uri = "mongodb+srv://jaolalla_db_user:5JXQQU4u3FdPiU0i@cluster0.qzrdwnw.mongodb.net/";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Lets the menu stop cleanly if the input is closed (Ctrl+C / Ctrl+D)
let closed = false;
const controller = new AbortController();
rl.on("close", () => {
  closed = true;
  controller.abort();
});

function ask(prompt) {
  return rl.question(prompt, { signal: controller.signal });
}

async function askInt(prompt) {
  // Keep asking until the user types a valid whole number
  while (true) {
    const value = (await ask(prompt)).trim();

    if (/^-?\d+$/.test(value)) {
      return Number(value);
    }
    console.log("Please enter a valid number.");
  }
}

async function askText(prompt) {
  // Keep asking until the user types something that is not empty
  while (true) {
    const value = (await ask(prompt)).trim();

    if (value) {
      return value;
    }
    console.log("This field cannot be empty.");
  }
}

function formatProfessor(professor) {
  return `Professor ID: ${professor.professor_id}, Name: ${professor.name}, Age: ${professor.age}, Department: ${professor.department}`;
}

async function createProfessor(collection) {
  const professorId = await askInt("Professor ID: ");

  if (await collection.findOne({ professor_id: professorId })) {
    console.log("A professor with that ID already exists.");
    return;
  }

  const name = await askText("Name: ");
  const age = await askInt("Age: ");
  const department = await askText("Department: ");

  await collection.insertOne({
    professor_id: professorId,
    name: name,
    age: age,
    department: department
  });
  console.log("Professor successfully registered!");
}

async function readAllProfessors(collection) {
  const professors = await collection.find({}, { projection: { _id: 0 } }).toArray();

  if (professors.length === 0) {
    console.log("There are no professors yet.");
  }
  for (const professor of professors) {
    console.log(formatProfessor(professor));
  }
}

async function readOneProfessor(collection) {
  const professorId = await askInt("Professor ID: ");
  const professor = await collection.findOne(
    { professor_id: professorId },
    { projection: { _id: 0 } }
  );

  if (professor) {
    console.log("Professor found:");
    console.log(formatProfessor(professor));
  } else {
    console.log("Professor not found.");
  }
}

async function updateProfessor(collection) {
  const professorId = await askInt("Professor ID: ");

  if (!(await collection.findOne({ professor_id: professorId }))) {
    console.log("Professor not found.");
    return;
  }

  // Press Enter to keep the current value of a field
  const changes = {};
  const name = (await ask("New name (Enter to skip): ")).trim();
  const age = (await ask("New age (Enter to skip): ")).trim();
  const department = (await ask("New department (Enter to skip): ")).trim();

  if (name) {
    changes.name = name;
  }
  if (age) {
    if (!/^-?\d+$/.test(age)) {
      console.log("Invalid age, update cancelled.");
      return;
    }
    changes.age = Number(age);
  }
  if (department) {
    changes.department = department;
  }

  if (Object.keys(changes).length === 0) {
    console.log("No changes were made.");
    return;
  }

  const result = await collection.updateOne(
    { professor_id: professorId },
    { $set: changes }
  );

  if (result.matchedCount > 0) {
    console.log("Professor successfully updated!");
  } else {
    console.log("Professor not found.");
  }
}

async function deleteProfessor(collection) {
  const professorId = await askInt("Professor ID: ");
  const result = await collection.deleteOne({ professor_id: professorId });

  if (result.deletedCount > 0) {
    console.log("Professor successfully deleted!");
  } else {
    console.log("Professor not found.");
  }
}

const actions = new Map([
  ["1", createProfessor],
  ["2", readAllProfessors],
  ["3", readOneProfessor],
  ["4", updateProfessor],
  ["5", deleteProfessor]
]);

const menu = `
--- Professors CRUD ---
1. Create professor
2. List all professors
3. Find professor by ID
4. Update professor
5. Delete professor
0. Exit
`;

async function main() {
  const client = new MongoClient(uri, {
    serverApi: ServerApiVersion.v1
  });

  try {
    await client.connect();
    await client.db("admin").command({ ping: 1 });
    console.log("Successfully connected to MongoDB!");

    const collection = client.db("University").collection("Professors");

    while (!closed) {
      // An error in one operation should not close the menu
      try {
        console.log(menu);
        const option = (await ask("Choose an option: ")).trim();

        if (option === "0") {
          break;
        }

        const action = actions.get(option);
        if (!action) {
          console.log("Invalid option.");
          continue;
        }

        await action(collection);
      } catch (error) {
        if (closed) {
          break;
        }
        console.log("Operation failed:", error.message);
      }
    }
  } catch (error) {
    console.log("Connection error:", error.message);
  } finally {
    rl.close();
    await client.close();
    console.log("MongoDB connection closed.");
  }
}

main();
