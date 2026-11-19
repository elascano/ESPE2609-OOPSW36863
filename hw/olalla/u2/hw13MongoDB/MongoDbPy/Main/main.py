from pymongo import MongoClient
from pymongo.server_api import ServerApi

uri = "mongodb+srv://jaolalla_db_user:5JXQQU4u3FdPiU0i@cluster0.qzrdwnw.mongodb.net/"


def ask_int(prompt):
    # Keep asking until the user types a valid whole number
    while True:
        try:
            return int(input(prompt).strip())
        except ValueError:
            print("Please enter a valid number.")


def ask_text(prompt):
    # Keep asking until the user types something that is not empty
    while True:
        value = input(prompt).strip()
        if value:
            return value
        print("This field cannot be empty.")


def create_student(collection):
    student_id = ask_int("Student ID: ")

    if collection.find_one({"student_id": student_id}):
        print("A student with that ID already exists.")
        return

    collection.insert_one({
        "student_id": student_id,
        "name": ask_text("Name: "),
        "age": ask_int("Age: "),
        "career": ask_text("Career: ")
    })
    print("Student successfully registered!")


def read_all_students(collection):
    students = list(collection.find({}, {"_id": 0}))

    if not students:
        print("There are no students yet.")
    for student in students:
        print(student)


def read_one_student(collection):
    student_id = ask_int("Student ID: ")
    student = collection.find_one({"student_id": student_id}, {"_id": 0})

    if student:
        print("Student found:")
        print(student)
    else:
        print("Student not found.")


def update_student(collection):
    student_id = ask_int("Student ID: ")

    if not collection.find_one({"student_id": student_id}):
        print("Student not found.")
        return

    # Press Enter to keep the current value of a field
    changes = {}
    name = input("New name (Enter to skip): ").strip()
    age = input("New age (Enter to skip): ").strip()
    career = input("New career (Enter to skip): ").strip()

    if name:
        changes["name"] = name
    if age:
        try:
            changes["age"] = int(age)
        except ValueError:
            print("Invalid age, update cancelled.")
            return
    if career:
        changes["career"] = career

    if not changes:
        print("No changes were made.")
        return

    collection.update_one({"student_id": student_id}, {"$set": changes})
    print("Student successfully updated!")


def delete_student(collection):
    student_id = ask_int("Student ID: ")
    result = collection.delete_one({"student_id": student_id})

    if result.deleted_count > 0:
        print("Student successfully deleted!")
    else:
        print("Student not found.")


actions = {
    "1": create_student,
    "2": read_all_students,
    "3": read_one_student,
    "4": update_student,
    "5": delete_student
}

menu = """
--- Students CRUD ---
1. Create student
2. List all students
3. Find student by ID
4. Update student
5. Delete student
0. Exit
"""

client = MongoClient(
    uri,
    server_api=ServerApi("1")
)

try:
    client.admin.command("ping")
    print("Successfully connected to MongoDB!")

    database = client["University"]
    collection = database["Students"]

    while True:
        print(menu)
        option = input("Choose an option: ").strip()

        if option == "0":
            break

        action = actions.get(option)
        if action is None:
            print("Invalid option.")
            continue

        # An error in one operation should not close the menu
        try:
            action(collection)
        except Exception as error:
            print("Operation failed:", error)

except Exception as error:
    print("Connection error:", error)

finally:
    client.close()