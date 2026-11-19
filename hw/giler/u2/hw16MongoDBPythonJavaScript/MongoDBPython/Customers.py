import json
from pymongo import MongoClient


URI = "mongodb+srv://aagilerizquierdo987_db_user:rbgAjVHPtOZsN4TV@cluster0.7yxz6us.mongodb.net/"
client = MongoClient(URI)
db = client["HW"]          
collection = db["CustomersPython"]        


def create_record():
    document = {
        "id": int(input("ID (number): ")),
        "name": input("Name: "),
        "age": int(input("Age: ")),
        "moneySpent": float(input("Money spent (moneySpent): "))
    }
    collection.insert_one(document)
    print("Record saved successfully.")


def view_records():
    
    records = list(collection.find({}, {"_id": 0}))
    print("\n--- Records in CustomersPython (JSON) ---")
    print(json.dumps(records, indent=2))


def update_record():
    target_id = int(input("Enter the ID of the record to update: "))
    print("Which field do you want to update? (name / age / moneySpent)")
    field = input("Field: ").strip()

    if field == "name":
        new_value = input("New name: ")
    elif field == "age":
        new_value = int(input("New age: "))
    elif field == "moneySpent":
        new_value = float(input("New moneySpent: "))
    else:
        print("Invalid field.")
        return

    
    result = collection.update_one(
        {"id": target_id},
        {"$set": {field: new_value}}
    )
    if result.matched_count:
        print("Record updated successfully.")
    else:
        print("No record found with that ID.")


def delete_record():
    target_id = int(input("Enter the ID of the record to delete: "))
    
    result = collection.delete_one({"id": target_id})
    if result.deleted_count:
        print(f"Record with ID {target_id} deleted.")
    else:
        print("No record found with that ID.")


def menu():
    while True:
        print("\n=== PYTHON MENU (db_python) ===")
        print("1. Add record")
        print("2. View records (JSON)")
        print("3. Update a record")
        print("4. Delete a record")
        print("5. Exit")
        option = input("Choose an option: ").strip()

        if option == "1":
            create_record()
        elif option == "2":
            view_records()
        elif option == "3":
            update_record()
        elif option == "4":
            delete_record()
        elif option == "5":
            client.close()
            print("Connection closed.")
            break
        else:
            print("Invalid option.")


if __name__ == "__main__":
    menu()