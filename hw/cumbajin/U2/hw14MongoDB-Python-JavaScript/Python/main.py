from pymongo import MongoClient
from getpass import getpass

# MongoDB Atlas connection
host = input("Enter your Atlas cluster host: ").strip()
username = input("Enter your MongoDB username: ").strip()
password = getpass("Enter your MongoDB password: ")

client = MongoClient(
    f"mongodb+srv://{host}/",
    username=username,
    password=password,
    serverSelectionTimeoutMS=10000
)

try:
    client.admin.command("ping")
    print("\nConnected to MongoDB successfully!")

    # Database and collection
    database = client["OPP"]
    collection = database["customers"]

    # Customer information
    customers = [
        {"id": 101, "name": "Dylan", "age": 20, "moneySpent": 250.50},
        {"id": 102, "name": "Anthony", "age": 21, "moneySpent": 320.75},
        {"id": 103, "name": "Juan", "age": 22, "moneySpent": 180.25}
    ]

    # Save customers
    for customer in customers:
        collection.update_one(
            {"id": customer["id"]},
            {"$set": customer},
            upsert=True
        )

    print("Customers saved successfully!")

    # Display customers
    print("\nCustomer list:")
    for customer in collection.find(
        {"id": {"$in": [101, 102, 103]}},
        {"_id": 0}
    ):
        print(customer)

except Exception as error:
    print("Error:", error)

finally:
    client.close()
