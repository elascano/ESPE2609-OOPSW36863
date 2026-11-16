# ws23AnimalFarmPrototype — Python

Workshop 23: **Animal Farm Prototype** (port of the original Java/NetBeans project).

**Student/author:** Dylan Cumbajin, MosQ, @ESPE

## Project files

```text
ws23AnimalFarmPrototype/
├── AnimalApp.py                   # Main program (Animal App)
├── controller/
│   ├── __init__.py
│   └── AnimalController.py       # Create objects and handle menu choices
├── model/
│   ├── __init__.py
│   ├── FarmAnimal.py             # Parent class
│   ├── Chicken.py                # Child class
│   ├── Cow.py                    # Child class
│   ├── Pig.py                    # Child class
│   └── Sheep.py                  # Child class
├── view/
│   ├── __init__.py
│   └── AnimalView.py             # Menu and keyboard input
├── tests/
│   └── test_animals.py
└── .vscode/
    └── launch.json              # "Animal App" run configuration
```

## Running

Python **3.9 or newer**. No external libraries are required.

In VS Code, open the **ws23AnimalFarmPrototype** folder. From its terminal:

```powershell
python AnimalApp.py
```

On Windows, you can also use:

```powershell
py AnimalApp.py
```

In VS Code's Run and Debug panel, choose **Animal App** and start it.

## Example

```text
========== FARM ANIMAL MENU ==========
1. Create Chicken
2. Create Cow
3. Create Pig
4. Create Sheep
5. Exit
Choose an option: 3
----- ENTER PIG DATA -----
Enter id: 4
Enter bread: Yorkshire
Enter born date:
Day: 12
Month: 8
Year: 2024
Pig -> Pig{FarmAnimal{id=4, bread=Yorkshire, bornOnDate=2024}}
```

Enter booleans with `true` or `false`. Decimal input accepts both `150.2` and `150,2`.

## OOP concepts

* **Inheritance:** `Chicken`, `Cow`, `Pig`, and `Sheep` inherit from `FarmAnimal`.
* **Encapsulation:** private-by-convention attributes with `_` and `@property` accessors.
* **Constructor:** `__init__`, with `super().__init__()` for the parent class.
* **String representation:** `__str__` (equivalent to Java `toString()`).
* **Modularity:** separate `model`, `view`, and `controller` packages.

Original Java naming `bread`, `numberOffLatIsMonth`, and `lastSheering` is retained in output for compatibility with the workshop. The original `getAgeInMonths` method returned 0, so `get_age_in_months` currently does the same.

## Tests

```powershell
python -m unittest discover -s tests -v
```
