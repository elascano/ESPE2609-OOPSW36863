from datetime import date


class Egg:
    def __init__(self, id: int = 1):
        self.id = id

    def __str__(self) -> str:
        return f"Egg{{id={self.id}}}"


class Poop:
    def __init__(self, amount: int = 1):
        self.amount = amount

    def __str__(self) -> str:
        return f"Poop{{amount={self.amount}}}"


class Chicken:
    def __init__(self, id: int, name: str, color: str, bornOnDate: date, molting: bool):
        self.id = id
        self.name = name
        self.color = color
        self.bornOnDate = bornOnDate
        self.molting = molting
        self.age = self.computeAge(bornOnDate)

    @staticmethod
    def computeAge(bornOnDate: date) -> int:
        today = date.today()
        age = today.year - bornOnDate.year - (
            (today.month, today.day) < (bornOnDate.month, bornOnDate.day)
        )
        return max(0, age)

    def cluck(self) -> None:
        print(f"Chicken {self.name} is clucking: cluck, cluck, cluck")

    def wander(self) -> None:
        print(f"Chicken {self.name} is wandering")

    def eat(self) -> None:
        print(f"Chicken {self.name} is eating")

    def drink(self) -> None:
        print(f"Chicken {self.name} is drinking")

    def poop(self, amount: int = 1) -> Poop:
        poop = Poop(amount)
        print(f"Chicken {self.name} is pooping a {poop}")
        return poop

    def layAnEgg(self, id: int = 1) -> Egg:
        egg = Egg(id)
        print(f"Chicken {self.name} is laying an {egg}")
        return egg

    def doStuff(self, forTime: int = 1) -> None:
        self.cluck()
        self.eat()
        self.drink()
        self.poop(forTime)
        self.wander()
        self.layAnEgg(forTime)

    def __str__(self) -> str:
        return (
            f"Chicken{{id={self.id}, name={self.name}, color={self.color}, "
            f"age={self.age}, bornOnDate={self.bornOnDate.isoformat()}, molting={str(self.molting).lower()}}}"
        )