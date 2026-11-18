const { MongoClient } = require('mongodb');
const readline = require('readline/promises');
const { stdin: input, stdout: output } = require('process');

class Client {
    constructor(id, name, age, moneySpent) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.moneySpent = moneySpent;
    }
}

class MongoManager {
    constructor(uri, dbName, collectionName) {
        this.client = new MongoClient(uri);
        this.dbName = dbName;
        this.collectionName = collectionName;
        this.collection = null;
    }

    async connect() {
        await this.client.connect();
        const db = this.client.db(this.dbName);
        this.collection = db.collection(this.collectionName);
        console.log("Connected to MongoDB");
    }

    async close() {
        await this.client.close();
        console.log("Connection closed");
    }

    async create(client) {
        await this.collection.insertOne(client);
        console.log(`Saved: ${client.name} (ID: ${client.id})`);
    }

    async delete(id) {
        const result = await this.collection.deleteOne({ id: id });
        if (result.deletedCount === 1) {
            console.log(`Deleted record with ID ${id}`);
        } else {
            console.log(`No record found with ID ${id}`);
        }
    }

    async list() {
        const data = await this.collection.find({}).toArray();
        console.log("\nClient List:");
        console.table(data.map(({ id, name, age, moneySpent }) => ({
            id, name, age, moneySpent
        })));
    }
}

async function main() {
    const uri = "mongodb+srv://amtiban1_db_user:DYaZkdg5WiHEuJDM@cluster0.ku0zu6t.mongodb.net/?retryWrites=true&w=majority";
    const manager = new MongoManager(uri, "hw14", "Javascript");
    const rl = readline.createInterface({ input, output });

    try {
        await manager.connect();
        let option = "";

        while (option !== "4") {
            console.log("\n--- MENU ---");
            console.log("1. Create client");
            console.log("2. List clients");
            console.log("3. Delete client");
            console.log("4. Exit");

            option = await rl.question("Choose an option: ");

            if (option === "1") {
                const id = Number(await rl.question("ID: "));
                const name = await rl.question("Name: ");
                const age = Number(await rl.question("Age: "));
                const moneySpent = Number(await rl.question("Money spent: "));

                const newClient = new Client(id, name, age, moneySpent);
                await manager.create(newClient);

            } else if (option === "2") {
                await manager.list();

            } else if (option === "3") {
                const id = Number(await rl.question("Enter ID to delete: "));
                await manager.delete(id);

            } else if (option !== "4") {
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