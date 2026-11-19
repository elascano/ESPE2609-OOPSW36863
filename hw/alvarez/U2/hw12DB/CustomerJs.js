const { MongoClient } = require('mongodb');

const uri = "mongodb+srv://krac12345678_db_user:ULfgr8a9H3FHaK0k@cluster0.2bvydoq.mongodb.net/";
const client = new MongoClient(uri);

async function run() {
    await client.connect();
    const db = client.db("OOP");
    const collection = db.collection("Customer");

    async function addCustomer(id, name, age, moneySpent) {
        const document = { id, name, age, moneySpent };
        await collection.insertOne(document);
    }

    async function deleteCustomer(id) {
        await collection.deleteOne({ id });
    }

    await addCustomer(4, "Maria", 22, 1500.50);
    await deleteCustomer(4);

    await client.close();
}

run();