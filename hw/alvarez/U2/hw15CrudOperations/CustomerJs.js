const { MongoClient } = require('mongodb');

const uri = "mongodb+srv://krac12345678_db_user:ULfgr8a9H3FHaK0k@cluster0.2bvydoq.mongodb.net/";
const client = new MongoClient(uri);

async function run() {
    try {
        await client.connect();
        console.log("Connected to MongoDB Database");

        const db = client.db("OOP");
        const collection = db.collection("Customer");

        async function addCustomer(id, name, age, moneySpent) {
            const document = { id, name, age, moneySpent };
            const result = await collection.insertOne(document);
            console.log("Customer created:", document);
            return result;
        }

        async function getAllCustomers() {
            const customers = await collection.find({}).toArray();
            console.log("All customers:", customers);
            return customers;
        }

        async function getCustomerById(id) {
            const customer = await collection.findOne({ id });
            console.log(`Customer with id ${id}:`, customer);
            return customer;
        }

        async function updateCustomer(id, updatedFields) {
            const result = await collection.updateOne(
                { id },
                { $set: updatedFields }
            );
            console.log(`Customer ${id} updated:`, result.modifiedCount > 0 ? "Success" : "Not found");
            return result;
        }

       
        async function deleteCustomer(id) {
            const result = await collection.deleteOne({ id });
            console.log(`Customer ${id} deleted:`, result.deletedCount > 0 ? "Success" : "Not found");
            return result;
        }

        console.log("\n--- 1. INITIAL READ ---");
        await getAllCustomers();

        console.log("\n--- 2. CREATE ---");
        await addCustomer(4, "Maria", 22, 1500.50);
        await getAllCustomers();

        console.log("\n--- 3. UPDATE ---");
        await updateCustomer(4, { name: "Maria Fernanda", age: 23, moneySpent: 1850.75 });
        await getCustomerById(4);

        console.log("\n--- 4. DELETE ---");
        await deleteCustomer(4);
        await getAllCustomers();

    } catch (error) {
        console.error("Error executing CRUD operations:", error);
    } finally {
        await client.close();
    }
}

run();