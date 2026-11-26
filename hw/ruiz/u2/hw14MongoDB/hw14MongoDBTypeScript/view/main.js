const readline = require("readline/promises");
const crud = require("../model/crudOperations");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function toNumber(text) {
  if (text.trim() === "") {
    return NaN;
  }
  return Number(text);
}

async function createOption() {
  const id = toNumber(await rl.question("Id: "));
  const name = await rl.question("Name: ");
  const age = toNumber(await rl.question("Age: "));
  const job = await rl.question("Job: ");
  const salary = toNumber(await rl.question("Salary: "));

  if (Number.isNaN(id) || Number.isNaN(age) || Number.isNaN(salary)) {
    console.log("Id, age and salary must be numbers");
    return;
  }

  const created = await crud.createEmployee({ id, name, age, job, salary });
  console.log(created ? "Employee created" : "An employee with that id already exists");
}

async function showAllOption() {
  const employees = await crud.getAllEmployees();
  for (const employee of employees) {
    console.log(employee);
  }
}

async function findOption() {
  const field = await rl.question("Search by (id/name/age/job/salary): ");
  if (!["id", "name", "age", "job", "salary"].includes(field)) {
    console.log("Invalid field");
    return;
  }

  let value = await rl.question("Value to search: ");
  if (["id", "age", "salary"].includes(field)) {
    value = toNumber(value);
    if (Number.isNaN(value)) {
      console.log("That field needs a number");
      return;
    }
  }

  const employees = await crud.findEmployees(field, value);
  if (employees.length > 0) {
    for (const employee of employees) {
      console.log(employee);
    }
  } else {
    console.log("Not found");
  }
}

async function updateOption() {
  const employeeId = toNumber(await rl.question("Id of the employee to update: "));
  if (Number.isNaN(employeeId)) {
    console.log("Id must be a number");
    return;
  }

  const field = await rl.question("Field to change (name/age/job/salary): ");
  if (!["name", "age", "job", "salary"].includes(field)) {
    console.log("Invalid field");
    return;
  }

  let value = await rl.question("New value: ");
  if (field === "age" || field === "salary") {
    value = toNumber(value);
    if (Number.isNaN(value)) {
      console.log("That field needs a number");
      return;
    }
  }

  const found = await crud.updateEmployee(employeeId, { [field]: value });
  console.log(found === 1 ? "Employee updated" : "Employee not found");
}

async function deleteOption() {
  const employeeId = toNumber(await rl.question("Id of the employee to delete: "));
  if (Number.isNaN(employeeId)) {
    console.log("Id must be a number");
    return;
  }

  const deleted = await crud.deleteEmployee(employeeId);
  console.log(deleted === 1 ? "Employee deleted" : "Employee not found");
}

function showMenu() {
  console.log("\n--- Cosmetology Employees ---");
  console.log("1. Create employee");
  console.log("2. Show all employees");
  console.log("3. Find employees");
  console.log("4. Update employee");
  console.log("5. Delete employee");
  console.log("0. Exit");
}

async function main() {
  await crud.connect();

  try {
    let running = true;
    while (running) {
      showMenu();
      const option = await rl.question("Choose an option: ");

      switch (option) {
        case "1":
          await createOption();
          break;
        case "2":
          await showAllOption();
          break;
        case "3":
          await findOption();
          break;
        case "4":
          await updateOption();
          break;
        case "5":
          await deleteOption();
          break;
        case "0":
          console.log("Goodbye");
          running = false;
          break;
        default:
          console.log("Invalid option");
      }
    }
  } finally {
    rl.close();
    await crud.close();
  }
}

main();