from datetime import date


def read_int(message):
    # asks until the user types a whole number
    while True:
        try:
            return int(input(message))
        except ValueError:
            print("That is not a valid number, try again")


def read_yes_no(message):
    # True if the user types y
    return input(message).strip().lower() == "y"


def read_date(message):
    # asks year, month and day until they make a real date
    print(message)
    while True:
        year = read_int("  Year (e.g. 2022): ")
        month = read_int("  Month (1-12): ")
        day = read_int("  Day (1-31): ")
        try:
            return date(year, month, day)
        except ValueError:
            print("That date does not exist, try again")