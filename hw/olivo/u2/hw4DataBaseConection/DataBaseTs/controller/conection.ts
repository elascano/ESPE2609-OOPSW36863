import { MongoClient } from "mongodb";

const uri = "mongodb+srv://cluster0.xnckdig.mongodb.net/";
const username = "josenestorolivo_db_user";
const password = "TqyWKpXNDfH6SYTg";

export async function connection(): Promise<MongoClient | null> {
  const encodedUser = encodeURIComponent(username);
  const encodedPass = encodeURIComponent(password);
  const fullUri = uri.replace(
    "mongodb+srv://",
    `mongodb+srv://${encodedUser}:${encodedPass}@`
  );

  const client = new MongoClient(fullUri, {
    serverSelectionTimeoutMS: 5000,
  });

  try {
    await client.connect();
    await client.db("admin").command({ ping: 1 });
    console.log("Successfully connected to MongoDB.");
    return client;
  } catch (error) {
    console.error("Failed to connect to MongoDB:", error);
    await client.close();
    return null;
  }
}