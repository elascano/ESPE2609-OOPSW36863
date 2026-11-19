from getpass import getpass

from pymongo import MongoClient
from pymongo.errors import PyMongoError


def main():
    uri = "mongodb+srv://cluster0.ovakidn.mongodb.net/"
    username = "amarevalo3_db_user"
    password = getpass("MongoDB password: ", echo_char="*")

    customers = [
        {"id": 1, "name": "Anthony", "age": 20, "moneySpent": 1000.27},
        {"id": 2, "name": "Anderson", "age": 22, "moneySpent": 100.50},
        {"id": 3, "name": "Carlos", "age": 24, "moneySpent": 200.75},
    ]

    try:
        with MongoClient(
            uri,
            username=username,
            password=password,
            authSource="admin",
            serverSelectionTimeoutMS=10000,
        ) as client:
            client.admin.command("ping")
            print("Connected to MongoDB Atlas.")

            collection = client["OPP"]["customers"]

            for customer in customers:
                collection.update_one(
                    {"id": customer["id"]},
                    {"$set": customer},
                    upsert=True,
                )

            print("\nCustomers in OPP.customers:")
            customer_ids = [customer["id"] for customer in customers]
            results = collection.find(
                {"id": {"$in": customer_ids}},
                {"_id": 0},
            ).sort("id", 1)

            for customer in results:
                print(customer)

    except PyMongoError as error:
        print(f"MongoDB error: {error}")


if __name__ == "__main__":
    main()