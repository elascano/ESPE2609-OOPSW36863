const { MongoClient } = require("mongodb");

const uri = "mongodb+srv://veroruizg01_db_user:XIDj5ljE72G7cTLu@cluster0.kgxwsbl.mongodb.net/";
const client = new MongoClient(uri);

let collection;

async function connect() {
  await client.connect();
  const db = client.db("cosmetology_db");

  const existing = await db.listCollections({ name: "employees" }).toArray();
  if (existing.length === 0) {
    await db.createCollection("employees");
  }

  collection = db.collection("employees");
}

async function close() {
  await client.close();
}

async function createEmployee(employee) {
  const existing = await collection.findOne({ id: employee.id });
  if (existing !== null) {
    return false;
  }
  await collection.insertOne(employee);
  return true;
}

async function getAllEmployees() {
  return await collection.find().toArray();
}


async function findEmployees(field, value) {
  return await collection.find({ [field]: value }).toArray();
}

async function updateEmployee(employeeId, changes) {
  const result = await collection.updateOne({ id: employeeId }, { $set: changes });
  return result.matchedCount;
}

async function deleteEmployee(employeeId) {
  const result = await collection.deleteOne({ id: employeeId });
  return result.deletedCount;
}

module.exports = {
  connect,
  close,
  createEmployee,
  getAllEmployees,
  findEmployees,
  updateEmployee,
  deleteEmployee,
};