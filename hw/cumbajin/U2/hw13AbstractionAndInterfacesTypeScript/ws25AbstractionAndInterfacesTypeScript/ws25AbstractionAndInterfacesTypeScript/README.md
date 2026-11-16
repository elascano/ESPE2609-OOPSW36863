# Workshop 25 - Abstraction and Interfaces (TypeScript)

TypeScript version of Dylan's Animal Farm project.

## OOP concepts

- `FarmAnimal` is an abstract class.
- `feed()` is an abstract method implemented by every concrete animal.
- `GrazeAnimal` is an interface.
- `Cow` and `Sheep` implement the `GrazeAnimal` interface.
- Polymorphism allows different animals to be handled through `FarmAnimal`.
- `Cow.milk()` demonstrates method overloading by using overload signatures.

## Install, compile and run

```bash
npm install
npm run build
npm start
```

TypeScript uses only one numeric type (`number`), so Java overloads that differ
only between `int` and `float` become one TypeScript overload accepting `number`.
