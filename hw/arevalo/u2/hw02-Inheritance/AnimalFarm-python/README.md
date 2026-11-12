# Animal Farm — Python

Python translation of the Java inheritance exercise, with one file per class.
All code, comments, and application messages are in English.

## Structure

```text
python/
├── animal_farm.py         # Launcher for the view
├── ec/edu/espe/animalfarm/
│   ├── controller/
│   │   └── __init__.py    # Reserved for controllers
│   ├── model/
│   │   ├── __init__.py
│   │   ├── farm_animal.py # Parent class
│   │   ├── chicken.py     # Inherits from FarmAnimal
│   │   ├── cow.py         # Inherits from FarmAnimal
│   │   ├── pig.py         # Inherits from FarmAnimal
│   │   └── sheep.py       # Inherits from FarmAnimal
│   └── view/
│       ├── __init__.py
│       └── animal_farm.py # AnimalFarm class and main method
├── venv/                 # Local Python virtual environment
├── .gitignore
└── README.md
```

Each directory in `ec/edu/espe/animalfarm` also contains an `__init__.py`
file so Python recognizes it as a package. The slash-separated directories
correspond to the dotted Java package name `ec.edu.espe.animalfarm`.

## Run on Windows

Open a terminal inside this `python` folder and run:

```powershell
.\venv\Scripts\python.exe animal_farm.py
```

Alternatively, run the view as a module from this same `python` folder:

```powershell
.\venv\Scripts\python.exe -m ec.edu.espe.animalfarm.view.animal_farm
```

Activation is optional. In PowerShell, you can also use:

```powershell
.\venv\Scripts\Activate.ps1
python animal_farm.py
deactivate
```

No external packages are needed. If you move the project to another computer,
recreate the environment with `python -m venv venv` using that computer's Python.

## Java to Python

| Java | Python |
| --- | --- |
| `class Pig extends FarmAnimal` | `class Pig(FarmAnimal)` |
| Constructor `Pig(...)` | `__init__(self, ...)` |
| `super(id, breed, bornOnDate)` | `super().__init__(id, breed, born_on_date)` |
| `this.weightInKg` | `self._weight_in_kg` |
| `toString()` | `__str__()` |
| `getWeightInKg()` | `get_weight_in_kg()` |
| `System.out.println(...)` | `print(...)` |
| `Date` | `datetime.date` |

The underscore marks internal attributes by convention; it does not enforce
Java-style private access. Getters and setters are kept for the exercise.
`model` holds the animal classes, `view` creates and prints the examples,
and `controller` is reserved for future controllers, as in the reference image.
The root launcher starts the view. `venv` holds the Python environment,
not the application code.

The package hierarchy follows the reference image: `ec.edu.espe.animalfarm`
contains `controller`, `model`, and `view`. Java source files remain in their
original location. Python filenames use snake_case; class names stay the same.

To preserve the original exercise, `get_age_in_months()` still returns `0`.
The cow's example birth date remains September 20, 2123, matching Java's
normalization of `new Date(222, 20, 20)`. Dates are represented without a time.
