from data.player_data import PlayerData
from view.player_view import PlayerView


class PlayerController:

    def __init__(self):
        self.players = PlayerData.read_from_json()  # list loaded from the JSON

    def add_player(self) -> None:
        self.players.append(PlayerView.ask_player(self.players))
        PlayerData.save_to_json(self.players)
        PlayerView.show_message("Player added and saved.")

    def delete_player(self) -> None:
        player_id = PlayerView.ask_id_to_delete()
        found = [p for p in self.players if p.id == player_id]
        if found:
            self.players.remove(found[0])
            PlayerData.save_to_json(self.players)
            PlayerView.show_message("Player deleted.")
        else:
            PlayerView.show_message(f"No player with ID {player_id}.")

    def list_players(self) -> None:
        PlayerView.show_players(PlayerData.read_from_json())

    def review_json(self) -> None:
        PlayerView.show_json(PlayerData.read_raw())

    def run(self) -> None:
        
        while True:
            option = PlayerView.show_menu()

            if option == 1:
                self.add_player()
            elif option == 2:
                self.delete_player()
            elif option == 3:
                self.list_players()
            elif option == 4:
                self.review_json()
            elif option == 5:
                PlayerView.show_message("Goodbye!")
                break
            else:
                PlayerView.show_message("Invalid option, choose from 1 to 5.")