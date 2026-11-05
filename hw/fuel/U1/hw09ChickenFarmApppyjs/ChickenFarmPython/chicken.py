from datetime import datetime

class Chicken:
    def __init__(self, id_chicken, name, color, born_on_date, molting):
        self.id = id_chicken
        self.name = name
        self.color = color
        self.born_on_date = born_on_date  # Format "YYYY-MM-DD"
        self.molting = molting
        self.age_in_years = self.compute_age_in_years()

    def compute_age_in_years(self):
        if self.born_on_date:
            try:
                birth_date = datetime.strptime(self.born_on_date, "%Y-%m-%d")
                today = datetime.now()
                age = today.year - birth_date.year - ((today.month, today.day) < (birth_date.month, birth_date.day))
                return max(0, age)
            except ValueError:
                return 0
        return 0

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "color": self.color,
            "bornOnDate": self.born_on_date,
            "ageInYears": self.age_in_years,
            "molting": self.molting
        }

    def __str__(self):
        return f"Chicken{{id={self.id}, name='{self.name}', color='{self.color}', bornOnDate={self.born_on_date}, age={self.age_in_years}, molting={self.molting}}}"