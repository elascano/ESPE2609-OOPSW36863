import { MongoClient } from "mongodb";
import * as readline from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";

const URI = "mongodb+srv://aagilerizquierdo987_db_user:rbgAjVHPtOZsN4TV@cluster0.7yxz6us.mongodb.net/";

interface Customer {
  id: number;
  name: string;
  age: number;
  moneySpent: number;
}

const client = new MongoClient(URI);
const rl = readline.createInterface({ input, output });

async function main() {
  await client.connect();
  const db = client.db("HW");
  const collection = db.collection<Customer>("CustomersTypeScript");

  let exit = false;

  while (!exit) {
    console.log("\n=== TYPESCRIPT MENU (HW - CustomersTypeScript) ===");
    console.log("1. Add record");
    console.log("2. View records (JSON)");
    console.log("3. Update a record");
    console.log("4. Delete a record");
    console.log("5. Exit");

    const option = (await rl.question("Choose an option: ")).trim();

    switch (option) {
      case "1": {
        const id = Number(await rl.question("ID (number): "));
        const name = await rl.question("Name: ");
        const age = Number(await rl.question("Age: "));
        const moneySpent = Number(await rl.question("Money spent (moneySpent): "));

        const document: Customer = { id, name, age, moneySpent };
        await collection.insertOne(document);
        console.log("Record saved successfully.");
        break;
      }

      case "2": {
        const records = await collection.find({}, { projection: { _id: 0 } }).toArray();
        console.log("\n--- Records in CustomersTypeScript (JSON) ---");
        console.log(JSON.stringify(records, null, 2));
        break;
      }

      case "3": {
        const targetId = Number(await rl.question("Enter the ID of the record to update: "));
        console.log("Which field do you want to update? (name / age / moneySpent)");
        const field = (await rl.question("Field: ")).trim();

        const updateData: Partial<Customer> = {};

        if (field === "name") {
          updateData.name = await rl.question("New name: ");
        } else if (field === "age") {
          updateData.age = Number(await rl.question("New age: "));
        } else if (field === "moneySpent") {
          updateData.moneySpent = Number(await rl.question("New moneySpent: "));
        } else {
          console.log("Invalid field.");
          break;
        }

        const result = await collection.updateOne(
          { id: targetId },
          { $set: updateData }
        );
        console.log(result.matchedCount ? "Record updated successfully." : "No record found with that ID.");
        break;
      }

      case "4": {
        const targetId = Number(await rl.question("Enter the ID of the record to delete: "));
        const result = await collection.deleteOne({ id: targetId });
        console.log(result.deletedCount ? `Record with ID ${targetId} deleted.` : "No record found with that ID.");
        break;
      }

      case "5":
        exit = true;
        break;

      default:
        console.log("Invalid option.");
    }
  }

  rl.close();
  await client.close();
  console.log("Connection closed.");
}

main().catch(console.error);
