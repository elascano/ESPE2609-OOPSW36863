from datetime import date


class Chicken:
    def __init__(self, id, name, color, born_on_date, molting):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date  # a datetime.date
        self.molting = molting            # True or False

    def compute_age(self):
        # age in years, calculated from born_on_date
        today = date.today()
        age = today.year - self.born_on_date.year
        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            age = age - 1
        return age

    def __str__(self):
        return (f"Chicken(id={self.id}, name={self.name}, color={self.color}, "
                f"born_on_date={self.born_on_date}, age={self.compute_age()}, "
                f"molting={self.molting})")