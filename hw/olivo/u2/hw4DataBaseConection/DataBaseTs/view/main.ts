import * as readline from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";
import type { Collection } from "mongodb";
import { connection } from "../controller/conection";
import { Student, type StudentDocument } from "../model/student";

function parseBirthDay(dateStr: string): Date {
  const match = /^(\d{4})-(\d{2})-(\d{2})$/.exec(dateStr.trim());
  if (!match) {
    throw new Error("Invalid format");
  }

  const year = Number(match[1]);
  const month = Number(match[2]);
  const day = Number(match[3]);
  const date = new Date(year, month - 1, day);

  if (
    date.getFullYear() !== year ||
    date.getMonth() !== month - 1 ||
    date.getDate() !== day
  ) {
    throw new Error("Invalid calendar date");
  }

  return date;
}

async function registerStudent(
  rl: readline.Interface,
  studentsCol: Collection<StudentDocument>
): Promise<void> {
  const name = (await rl.question("Student name: ")).trim();
  const dni = (await rl.question("DNI: ")).trim();
  const birthStr = (await rl.question("Birth date (YYYY-MM-DD): ")).trim();

  let birthDay: Date;
  try {
    birthDay = parseBirthDay(birthStr);
  } catch {
    console.log("Invalid date format. Please use YYYY-MM-DD (e.g., 2003-08-25).");
    return;
  }

  const student = new Student(name, birthDay, dni);
  const doc = student.toDocument();
  const result = await studentsCol.insertOne(doc);

  console.log(
    `Student saved with _id: ${result.insertedId} ` +
      `(Internal ID: ${student.getId()}, Age: ${student.getAgeInYears()})`
  );
}

async function listStudents(
  studentsCol: Collection<StudentDocument>
): Promise<void> {
  const students = await studentsCol.find().toArray();
  if (students.length === 0) {
    console.log("No students registered.");
    return;
  }

  console.log("\n--- Student List ---");
  for (const doc of students) {
    console.log(
      `ID: ${doc.id} | Name: ${doc.name} | DNI: ${doc.dni} | Age: ${doc.age_in_years}`
    );
  }
}

async function main(): Promise<void> {
  const client = await connection();
  if (!client) {
    console.log("Could not connect to MongoDB. Check your credentials or network.");
    return;
  }

  const db = client.db("OOP");
  const studentsCol = db.collection<StudentDocument>("student");
  const rl = readline.createInterface({ input, output });

  try {
    while (true) {
      console.log("\n=== Student Management ===");
      console.log("1. Register student");
      console.log("2. List students");
      console.log("3. Exit");

      const option = (await rl.question("Choose an option: ")).trim();

      if (option === "1") {
        await registerStudent(rl, studentsCol);
      } else if (option === "2") {
        await listStudents(studentsCol);
      } else if (option === "3") {
        console.log("Connection closed. Goodbye!");
        break;
      } else {
        console.log("Invalid option.");
      }
    }
  } finally {
    rl.close();
    await client.close();
  }
}

main();