from chicken import Chicken
from json_manager import JsonManager

def main():
    print("Alejandro Fuel's Chicken Farm (Python Version)")
    print("==========")

    option = 0
    while option != 3:
        print("\n--- MAIN MENU (JSON) ---")
        print("1. Add a chicken and save to JSON")
        print("2. Read and view JSON file")
        print("3. Exit")
        
        try:
            option = int(input("Choose an option: "))
        except ValueError:
            print("Please enter a valid number.")
            continue

        if option == 1:
            try:
                id_chicken = int(input("Enter chicken ID: "))
                name = input("Enter chicken name: ")
                color = input("Enter chicken color: ")
                born_date = input("Enter birth date (YYYY-MM-DD): ")
                molting_input = input("Is it molting? (y/n): ").lower()
                molting = True if molting_input == 'y' else False

                new_chicken = Chicken(id_chicken, name, color, born_date, molting)
                JsonManager.save_chicken_to_json(new_chicken)
            except ValueError:
                print("Error in the entered data. Please try again.")

        elif option == 2:
            JsonManager.read_chicken_json()

        elif option == 3:
            print("Exiting the program. Goodbye!")
        else:
            print("Invalid option. Please try again.")

if __name__ == "__main__":
    main()