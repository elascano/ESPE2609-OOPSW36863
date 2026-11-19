from pymongo import MongoClient
import os
from dotenv import load_dotenv

load_dotenv()

class Client:
    def __init__(self, client_id, name, age, money_spent):
        self.id = client_id
        self.name = name
        self.age = age
        self.money_spent = money_spent

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "age": self.age,
            "moneySpent": self.money_spent
        }


class MongoManager:
    def __init__(self, uri, db_name, collection_name):
        self.client = MongoClient(uri)
        self.db = self.client[db_name]
        self.collection = self.db[collection_name]

    def close(self):
        self.client.close()
        print("Connection closed")

    def create(self, client):
        self.collection.insert_one(client.to_dict())
        print(f"Saved: {client.name} (ID: {client.id})")

    def delete(self, client_id):
        result = self.collection.delete_one({"id": client_id})
        if result.deleted_count == 1:
            print(f"Deleted record with ID {client_id}")
        else:
            print(f"No record found with ID {client_id}")

    def list_all(self):
        data = list(self.collection.find({}, {"_id": 0}))
        print("\nClient List:")
        if not data:
            print("No records found.")
            return
        for item in data:
            print(f"ID: {item['id']} | Name: {item['name']} | Age: {item['age']} | Money Spent: {item['moneySpent']}")


def main():
    uri = os.getenv("MONGO_URI")
    manager = MongoManager(uri, "hw14", "python")

    try:
        print("Connected to MongoDB")
        option = ""

        while option != "4":
            print("\n--- MENU ---")
            print("1. Create client")
            print("2. List clients")
            print("3. Delete client")
            print("4. Exit")

            option = input("Choose an option: ")

            if option == "1":
                client_id = int(input("ID: "))
                name = input("Name: ")
                age = int(input("Age: "))
                money_spent = float(input("Money spent: "))

                new_client = Client(client_id, name, age, money_spent)
                manager.create(new_client)

            elif option == "2":
                manager.list_all()

            elif option == "3":
                client_id = int(input("Enter ID to delete: "))
                manager.delete(client_id)

            elif option != "4":
                print("Invalid option")

    except Exception as error:
        print("Error:", error)
    finally:
        manager.close()


if __name__ == "__main__":
    main()