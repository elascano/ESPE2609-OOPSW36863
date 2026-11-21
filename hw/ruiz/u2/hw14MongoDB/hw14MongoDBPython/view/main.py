import os
import sys

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from model import crud_operations as crud


def create_option():
    try:
        employee = {
            "id": int(input("Id: ")),
            "name": input("Name: "),
            "age": int(input("Age: ")),
            "job": input("Job: "),
            "salary": float(input("Salary: ")),
        }
    except ValueError:
        print("Id and age must be integers, salary must be a number")
        return

    if crud.create_employee(employee):
        print("Employee created")
    else:
        print("An employee with that id already exists")


def show_all_option():
    for employee in crud.get_all_employees():
        print(employee)


def find_option():
    field = input("Search by (id/name/age/job/salary): ")
    if field not in ("id", "name", "age", "job", "salary"):
        print("Invalid field")
        return

    value = input("Value to search: ")
    try:
        if field in ("id", "age"):
            value = int(value)
        elif field == "salary":
            value = float(value)
    except ValueError:
        print("That field needs a number")
        return

    employees = crud.find_employees(field, value)
    if employees:
        for employee in employees:
            print(employee)
    else:
        print("Not found")


def update_option():
    try:
        employee_id = int(input("Id of the employee to update: "))
        field = input("Field to change (name/age/job/salary): ")
        if field not in ("name", "age", "job", "salary"):
            print("Invalid field")
            return
        value = input("New value: ")
        if field == "age":
            value = int(value)
        elif field == "salary":
            value = float(value)
    except ValueError:
        print("Age must be an integer and salary must be a number")
        return

    if crud.update_employee(employee_id, {field: value}) == 1:
        print("Employee updated")
    else:
        print("Employee not found")


def delete_option():
    try:
        employee_id = int(input("Id of the employee to delete: "))
    except ValueError:
        print("Id must be an integer")
        return

    if crud.delete_employee(employee_id) == 1:
        print("Employee deleted")
    else:
        print("Employee not found")


def show_menu():
    print("\n--- Cosmetology Employees ---")
    print("1. Create employee")
    print("2. Show all employees")
    print("3. Find employee")
    print("4. Update employee")
    print("5. Delete employee")
    print("0. Exit")

def main():
    while True:
        show_menu()
        option = input("Choose an option: ")

        if option == "1":
            create_option()
        elif option == "2":
            show_all_option()
        elif option == "3":
            find_option()
        elif option == "4":
            update_option()
        elif option == "5":
            delete_option()
        elif option == "0":
            print("Goodbye")
            break
        else:
            print("Invalid option")


if __name__ == "__main__":
    main()