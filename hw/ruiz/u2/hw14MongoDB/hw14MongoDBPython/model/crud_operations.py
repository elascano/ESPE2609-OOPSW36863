from pymongo import MongoClient
client = MongoClient("mongodb+srv://veroruizg01_db_user:XIDj5ljE72G7cTLu@cluster0.kgxwsbl.mongodb.net/")
db = client["cosmetology_db"]
collection_name = "employees"

if collection_name not in db.list_collection_names():
    db.create_collection(collection_name)

collection = db[collection_name]

def create_employee(employee):
    if collection.find_one({"id": employee["id"]}) is not None:
        return False
    collection.insert_one(employee)
    return True


def get_all_employees():
    return list(collection.find())


def find_employees(field, value):
    return list(collection.find({field: value}))


def update_employee(employee_id, changes):
    result = collection.update_one({"id": employee_id}, {"$set": changes})
    return result.matched_count


def delete_employee(employee_id):
    result = collection.delete_one({"id": employee_id})
    return result.deleted_count



