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

def delete_customer(customer_id):
    collection.delete_one({"id": customer_id})

add_customer(4, "Maria", 22, 1500.50)
delete_customer(4)