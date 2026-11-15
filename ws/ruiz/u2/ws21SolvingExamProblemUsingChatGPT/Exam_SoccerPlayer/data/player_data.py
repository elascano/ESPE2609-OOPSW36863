import json
import os

from model.soccer_player import SoccerPlayer


class PlayerData:

    FILE_PATH = os.path.join(os.path.dirname(__file__), "players.json")

    @staticmethod
    def save_to_json(players: list[SoccerPlayer]) -> None:
        with open(PlayerData.FILE_PATH, "w", encoding="utf-8") as file:
            json.dump([p.to_dict() for p in players], file, indent=4, ensure_ascii=False)

    @staticmethod
    def read_from_json() -> list[SoccerPlayer]:
        if not os.path.exists(PlayerData.FILE_PATH):
            return []
        with open(PlayerData.FILE_PATH, "r", encoding="utf-8") as file:
            content = file.read().strip()
        if not content:
            return []
        return [SoccerPlayer.from_dict(d) for d in json.loads(content)]

    @staticmethod
    def read_raw() -> str:
        if not os.path.exists(PlayerData.FILE_PATH):
            return ""
        with open(PlayerData.FILE_PATH, "r", encoding="utf-8") as file:
            return file.read()