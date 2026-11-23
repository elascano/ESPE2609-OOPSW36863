from datetime import datetime
from pathlib import Path
import sys

ROOT_DIR = Path(__file__).resolve().parent.parent
if str(ROOT_DIR) not in sys.path:
    sys.path.insert(0, str(ROOT_DIR))

from controller.conection import connection
from model.student import Student


def parse_birth_day(date_str: str) -> datetime:
    return datetime.strptime(date_str.strip(), "%Y-%m-%d")


def register_student(students_col) -> None:
    name = input("Student name: ").strip()
    dni = input("DNI: ").strip()
    birth_str = input("Birth date (YYYY-MM-DD): ").strip()

    try:
        birth_day = parse_birth_day(birth_str)
    except ValueError:
        print("Invalid date format. Please use YYYY-MM-DD (e.g., 2003-08-25).")
        return

    student = Student(name=name, birth_day=birth_day, dni=dni)
    result = students_col.insert_one(student.to_dict())
    print(
        f"Student saved with _id: {result.inserted_id} "
        f"(Internal ID: {student.get_id()}, Age: {student.get_age_in_years()})"
    )


def list_students(students_col) -> None:
    students = list(students_col.find())
    if not students:
        print("No students registered.")
        return

    print("\n--- Student List ---")
    for doc in students:
        print(
            f"ID: {doc.get('id')} | Name: {doc.get('name')} | "
            f"DNI: {doc.get('dni')} | Age: {doc.get('age_in_years')}"
        )


def main() -> None:
    client = connection()
    if client is None:
        print("Could not connect to MongoDB. Check your credentials or network.")
        return

    db = client["OOP"]
    students_col = db["student"]

    while True:
        print("\n=== Student Management ===")
        print("1. Register student")
        print("2. List students")
        print("3. Exit")
        option = input("Choose an option: ").strip()

        if option == "1":
            register_student(students_col)
        elif option == "2":
            list_students(students_col)
        elif option == "3":
            client.close()
            print("Connection closed. Goodbye!")
            break
        else:
            print("Invalid option.")


if __name__ == "__main__":
    main()