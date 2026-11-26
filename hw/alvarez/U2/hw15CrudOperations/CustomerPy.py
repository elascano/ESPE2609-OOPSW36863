from pymongo import MongoClient

client = MongoClient("mongodb+srv://krac12345678_db_user:BeR9TGanftrsrm7h@cluster0.2red1uf.mongodb.net/")
db = client["OOP"]
collection = db["Customer"]

def add_customer(customer_id, name, age, money_spent):
    document = {
        "id": customer_id,
        "name": name,
        "age": age,
        "moneySpent": money_spent
    }
    collection.insert_one(document)
    print("Customer created:", document)

def get_all_customers():
    customers = list(collection.find({}, {"_id": 0}))
    print("All customers:", customers)
    return customers

def get_customer_by_id(customer_id):
    customer = collection.find_one({"id": customer_id}, {"_id": 0})
    print(f"Customer with id {customer_id}:", customer)
    return customer

def update_customer(customer_id, updated_fields):
    result = collection.update_one(
        {"id": customer_id},
        {"$set": updated_fields}
    )
    status = "Success" if result.modified_count > 0 else "Not found"
    print(f"Customer {customer_id} updated: {status}")
    return result

def delete_customer(customer_id):
    result = collection.delete_one({"id": customer_id})
    status = "Success" if result.deleted_count > 0 else "Not found"
    print(f"Customer {customer_id} deleted: {status}")
    return result

if __name__ == "__main__":
    print("\n--- 1. INITIAL READ ---")
    get_all_customers()

    print("\n--- 2. CREATE ---")
    add_customer(4, "Maria", 22, 1500.50)
    get_all_customers()

    print("\n--- 3. UPDATE ---")
    update_customer(4, {"name": "Maria Fernanda", "age": 23, "moneySpent": 1850.75})
    get_customer_by_id(4)

    print("\n--- 4. DELETE ---")
    delete_customer(4)
    get_all_customers()

    client.close()