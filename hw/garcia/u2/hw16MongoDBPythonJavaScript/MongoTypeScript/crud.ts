import * as dotenv from "dotenv";
import { MongoClient, Db, Collection } from "mongodb";
import * as readline from "readline/promises";
import { stdin as input, stdout as output } from "process";

dotenv.config();

interface ClientDocument {
    id: number;
    name: string;
    age: number;
    moneySpent: number;
}

class Client {
    id: number;
    name: string;
    age: number;
    moneySpent: number;

    constructor(clientId: number, name: string, age: number, moneySpent: number) {
        this.id = clientId;
        this.name = name;
        this.age = age;
        this.moneySpent = moneySpent;
    }

    toDict(): ClientDocument {
        return {
            id: this.id,
            name: this.name,
            age: this.age,
            moneySpent: this.moneySpent
        };
    }
}

class MongoManager {
    private client: MongoClient;
    private db: Db;
    private collection: Collection<ClientDocument>;

    constructor(uri: string, dbName: string, collectionName: string) {
        this.client = new MongoClient(uri);
        this.db = this.client.db(dbName);
        this.collection = this.db.collection<ClientDocument>(collectionName);
    }

    async connect(): Promise<void> {
        await this.client.connect();
        console.log("Connected to MongoDB");
    }

    async close(): Promise<void> {
        await this.client.close();
        console.log("Connection closed");
    }

    async create(client: Client): Promise<void> {
        await this.collection.insertOne(client.toDict());
        console.log(`Saved: ${client.name} (ID: ${client.id})`);
    }

    async listAll(): Promise<void> {
        const data = await this.collection.find({}, { projection: { _id: 0 } }).toArray();
        console.log("\nClient List:");
        if (data.length === 0) {
            console.log("No records found");
            return;
        }
        for (const item of data) {
            console.log(`ID: ${item.id} | Name: ${item.name} | Age: ${item.age} | Money Spent: ${item.moneySpent}`);
        }
    }

    async update(clientId: number, newName: string, newAge: number, newMoneySpent: number): Promise<void> {
        const result = await this.collection.updateOne(
            { id: clientId },
            {
                $set: {
                    name: newName,
                    age: newAge,
                    moneySpent: newMoneySpent
                }
            }
        );
        if (result.matchedCount === 1) {
            console.log(`Updated record with ID ${clientId}`);
        } else {
            console.log(`No record found with ID ${clientId}`);
        }
    }

    async delete(clientId: number): Promise<void> {
        const result = await this.collection.deleteOne({ id: clientId });
        if (result.deletedCount === 1) {
            console.log(`Deleted record with ID ${clientId}`);
        } else {
            console.log(`No record found with ID ${clientId}`);
        }
    }
}

async function main(): Promise<void> {
    const uri = process.env.MONGO_URI;
    if (!uri) {
        console.error("Error: MONGO_URI not found in .env file");
        return;
    }

    const manager = new MongoManager(uri, "hw16", "TypeScript");
    const rl = readline.createInterface({ input, output });

    try {
        await manager.connect();
        let option = "";

        while (option !== "5") {
            console.log("\n--- MENU (TYPESCRIPT) ---");
            console.log("1. Create client");
            console.log("2. List clients");
            console.log("3. Update client");
            console.log("4. Delete client");
            console.log("5. Exit");

            option = (await rl.question("Choose an option: ")).trim();

            if (option === "1") {
                const clientId = parseInt(await rl.question("ID: "), 10);
                const name = await rl.question("Name: ");
                const age = parseInt(await rl.question("Age: "), 10);
                const moneySpent = parseFloat(await rl.question("Money spent: "));

                const newClient = new Client(clientId, name, age, moneySpent);
                await manager.create(newClient);

            } else if (option === "2") {
                await manager.listAll();

            } else if (option === "3") {
                const clientId = parseInt(await rl.question("Enter ID to update: "), 10);
                const newName = await rl.question("New Name: ");
                const newAge = parseInt(await rl.question("New Age: "), 10);
                const newMoneySpent = parseFloat(await rl.question("New Money spent: "));

                await manager.update(clientId, newName, newAge, newMoneySpent);

            } else if (option === "4") {
                const clientId = parseInt(await rl.question("Enter ID to delete: "), 10);
                await manager.delete(clientId);

            } else if (option !== "5") {
                console.log("Invalid option");
            }
        }
    } catch (error) {
        console.error("Error:", error);
    } finally {
        rl.close();
        await manager.close();
    }
}

main();