"""Console menu and reusable input functions."""

from datetime import date


class AnimalView:
    def show_menu(self) -> int:
        print("========== FARM ANIMAL MENU ==========")
        print("1. Create Chicken")
        print("2. Create Cow")
        print("3. Create Pig")
        print("4. Create Sheep")
        print("5. Exit")
        return self.read_int("Choose an option: ")

    def read_int(self, message: str) -> int:
        while True:
            try:
                return int(input(message))
            except ValueError:
                print("Invalid integer. Please try again.")

    def read_float(self, message: str) -> float:
        while True:
            try:
                # Accept either 150.2 or 150,2, independent of locale.
                return float(input(message).strip().replace(",", "."))
            except ValueError:
                print("Invalid number. Please try again.")

    def read_bool(self, message: str) -> bool:
        while True:
            value = input(message).strip().lower()
            if value == "true":
                return True
            if value == "false":
                return False
            print("Please enter true or false.")

    def read_bread(self) -> str:
        # Retain the original Java field name for compatibility.
        return input("Enter bread: ").strip()

    def read_id(self) -> int:
        return self.read_int("Enter id: ")

    def read_date(self, message: str) -> date:
        while True:
            print(f"Enter {message}:")
            day = self.read_int("Day: ")
            month = self.read_int("Month: ")
            year = self.read_int("Year: ")
            try:
                return date(year, month, day)
            except ValueError:
                print("Invalid date. Please enter a real calendar date.")
