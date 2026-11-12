from models.vinyl_record import VinylRecord
from storage.json_storage import JsonStorage

FILE_PATH = "data/vinyl_records.json"


def read_int(message: str) -> int:
    while True:
        try:
            return int(input(message))
        except ValueError:
            print("Please enter a valid number.")


def id_exists(records: list, id: int) -> bool:
    return any(r.get_id() == id for r in records)


def create_records(records: list) -> None:
    quantity = read_int("How many vinyl records do you want to add? ")
    for _ in range(quantity):
        print("\n--- New vinyl record ---")
        while True:
            id = read_int("ID: ")
            if id_exists(records, id):
                print("That ID already exists, try another one.")
            else:
                break
        title = input("Title: ").strip()
        artist = input("Artist: ").strip()
        year = read_int("Year: ")
        records.append(VinylRecord(id, title, artist, year))


def show_records(records: list) -> None:
    if not records:
        print("No records to show.")
        return
    for record in records:
        print(record)


def main() -> None:
    storage = JsonStorage(FILE_PATH)
    records = []

    while True:
        print("\n===== VINYL RECORD MENU =====")
        print("1. Add vinyl records")
        print("2. Save to JSON file")
        print("3. Read from JSON file")
        print("4. Show records in memory")
        print("5. Exit")
        option = input("Choose an option: ").strip()

        if option == "1":
            create_records(records)
        elif option == "2":
            storage.save(records)
            print("Records saved to", FILE_PATH)
        elif option == "3":
            records = storage.load()
            print(f"{len(records)} record(s) loaded from", FILE_PATH)
            show_records(records)
        elif option == "4":
            show_records(records)
        elif option == "5":
            print("Goodbye!")
            break
        else:
            print("Invalid option.")


if __name__ == "__main__":
    main()
    