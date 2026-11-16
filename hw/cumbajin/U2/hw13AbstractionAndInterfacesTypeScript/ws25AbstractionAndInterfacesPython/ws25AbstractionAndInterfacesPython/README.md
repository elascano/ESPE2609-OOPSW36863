# Workshop 25 - Abstraction and Interfaces (Python)

Python version of Dylan's Animal Farm project.

## OOP concepts

- `FarmAnimal` is an abstract class.
- `feed()` is an abstract method implemented by every concrete animal.
- `GrazeAnimal` represents an interface through an abstract base class.
- `Cow` and `Sheep` implement the `GrazeAnimal` interface.
- Polymorphism allows different animals to be handled as `FarmAnimal` objects.

## Run

From the project folder, execute:

```bash
python -m src.view.animal
```

No external libraries are required.
