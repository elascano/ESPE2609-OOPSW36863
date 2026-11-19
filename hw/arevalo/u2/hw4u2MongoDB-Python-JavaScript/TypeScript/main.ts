import { MongoClient } from "mongodb";

interface Customer {
  id: number;
  name: string;
  age: number;
  moneySpent: number;
}

async function main(): Promise<void> {
  const password = process.env.MONGODB_PASSWORD;

  if (!password) {
    throw new Error("Set MONGODB_PASSWORD in PowerShell before running.");
  }

  const client = new MongoClient("mongodb+srv://cluster0.ovakidn.mongodb.net/", {
    auth: {
      username: "amarevalo3_db_user",
      password,
    },
    authSource: "admin",
    serverSelectionTimeoutMS: 10000,
  });

  const customers: Customer[] = [
    { id: 1, name: "Anthony", age: 20, moneySpent: 1000.27 },
    { id: 2, name: "Anderson", age: 22, moneySpent: 100.50 },
    { id: 3, name: "Carlos", age: 24, moneySpent: 200.75 },
  ];

  try {
    await client.connect();
    console.log("Connected to MongoDB Atlas.");

    const collection = client.db("OPP").collection<Customer>("customers");

    for (const customer of customers) {
      await collection.updateOne(
        { id: customer.id },
        { $set: customer },
        { upsert: true }
      );
    }

    const ids = customers.map((customer) => customer.id);
    const results = await collection
      .find({ id: { $in: ids } })
      .project<Customer>({ _id: 0, id: 1, name: 1, age: 1, moneySpent: 1 })
      .sort({ id: 1 })
      .toArray();

    console.log("Customers in OPP.customers:");
    console.table(results);
  } finally {
    await client.close();
  }
}

main().catch((error: unknown) => {
  console.error(error instanceof Error ? error.message : String(error));
  process.exitCode = 1;
});