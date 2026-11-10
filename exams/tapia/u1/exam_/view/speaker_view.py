import sys
import os

sys.path.append(
    os.path.dirname(
        os.path.dirname(
            os.path.abspath(__file__)
        )
    )
)

from controller.speaker_controller import SpeakerController


def menu():
    controller = SpeakerController()

    while True:
        print("\n===== SPEAKER MENU =====")
        print("1. Add Speaker")
        print("2. Show Speakers")
        print("3. Exit")

        option = input("Choose an option: ")

        if option == "1":
            id = input("ID: ")
            brand = input("Brand: ")
            power = input("Power: ")
            price = input("Price: ")

            controller.add_speaker(
                id,
                brand,
                power,
                price
            )

            print("Speaker added successfully!")

        elif option == "2":
            controller.list_speakers()

        elif option == "3":
            print("Goodbye!")
            break

        else:
            print("Invalid option.")


if __name__ == "__main__":
    menu()