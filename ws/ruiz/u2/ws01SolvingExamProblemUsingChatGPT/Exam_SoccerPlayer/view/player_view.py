from model.soccer_player import SoccerPlayer


class PlayerView:

    @staticmethod
    def ask_int(message: str) -> int:
        while True:
            try:
                return int(input(message))
            except ValueError:
                print("Please enter a valid number.")

    @staticmethod
    def ask_text(message: str) -> str:
        while True:
            value = input(message).strip()
            if value:
                return value
            print("This field cannot be empty.")

    @staticmethod
    def show_menu() -> int:
        print("\n==============================")
        print("   SOCCER PLAYER MANAGER (MVC)")
        print("==============================")
        print("---------- MENU ----------")
        print("1. Add player")
        print("2. Delete player")
        print("3. List players")
        print("4. Review JSON file")
        print("5. Exit")
        return PlayerView.ask_int("\nChoose an option: ")

    @staticmethod
    def ask_player(players: list[SoccerPlayer]) -> SoccerPlayer:
        """Ask for the data of ONE player; the id cannot be repeated."""
        print("\n>> Add player")
        while True:
            player_id = PlayerView.ask_int("ID: ")
            if any(p.id == player_id for p in players):
                print(f"A player with ID {player_id} already exists.")
                continue
            break
        return SoccerPlayer(
            player_id,
            PlayerView.ask_text("Name: "),
            PlayerView.ask_text("Position: "),
            PlayerView.ask_int("Shirt number: "),
        )

    @staticmethod
    def ask_id_to_delete() -> int:
        print("\n>> Delete player")
        return PlayerView.ask_int("ID of the player to delete: ")

    @staticmethod
    def show_message(message: str) -> None:
        print(message)

    @staticmethod
    def show_players(players: list[SoccerPlayer]) -> None:
        print("\n--- Players ---")
        if not players:
            print("There are no players yet.")
        for player in players:
            print(player)

    @staticmethod
    def show_json(content: str) -> None:
        print("\n--- JSON file content ---")
        print(content if content else "The file does not exist or is empty.")