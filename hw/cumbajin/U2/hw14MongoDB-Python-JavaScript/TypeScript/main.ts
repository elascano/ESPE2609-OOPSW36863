import { MongoClient } from "mongodb";

// Customer interface
interface Customer {
    id: number;
    name: string;
    age: number;
    moneySpent: number;
}

// MongoDB Atlas connection
const uri = "mongodb+srv://cluster0.dlmldsz.mongodb.net/";
const username = "ws26_user";

async function main(): Promise<void> {

    const password = process.env.MONGODB_PASSWORD;

    if (!password) {
        console.log("MongoDB password is missing!");
        return;
    }

    const client = new MongoClient(uri, {
        auth: {
            username: username,
            password: password
        },
        serverSelectionTimeoutMS: 10000
    });

    try {
        // Connect to MongoDB
        await client.connect();
        await client.db("admin").command({ ping: 1 });

        console.log("Connected to MongoDB successfully!");

        // Database and collection
        const database = client.db("OPP");
        const collection = database.collection<Customer>("customers");

        // Customer information
        const customers: Customer[] = [
            {
                id: 101,
                name: "Dylan",
                age: 20,
                moneySpent: 250.50
            },
            {
                id: 102,
                name: "Anthony",
                age: 21,
                moneySpent: 320.75
            },
            {
                id: 103,
                name: "Juan",
                age: 22,
                moneySpent: 180.25
            }
        ];

        // Save customers
        for (const customer of customers) {
            await collection.updateOne(
                { id: customer.id },
                { $set: customer },
                { upsert: true }
            );
        }

        console.log("Customers saved successfully!");

        // Read customers
        console.log("\nCustomer list:");

        const results = await collection.find(
            { id: { $in: [101, 102, 103] } }
        ).toArray();

        for (const customer of results) {
            console.log({
                id: customer.id,
                name: customer.name,
                age: customer.age,
                moneySpent: customer.moneySpent
            });
        }

    } catch (error) {
        console.error("Error:", error);
    } finally {
        await client.close();
    }
}

main();
