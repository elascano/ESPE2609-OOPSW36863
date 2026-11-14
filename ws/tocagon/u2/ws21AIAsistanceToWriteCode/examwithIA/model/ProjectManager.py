import json

class ProjectorManager:
    def __init__(self, manager_name, employee_id, department):
        self.manager_name = manager_name
        self.employee_id = employee_id
        self.department = department

    def save(self):
        data = {
            "manager_name": self.manager_name,
            "employee_id": self.employee_id,
            "department": self.department
        }

        with open("manager.json", "w") as file:
            json.dump(data, file, indent=4)

    def load(self):
        with open("manager.json", "r") as file:
            data = json.load(file)

        self.manager_name = data["manager_name"]
        self.employee_id = data["employee_id"]
        self.department = data["department"]
