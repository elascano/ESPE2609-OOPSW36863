"""
@author Lesly Muzo, @ESPE
"""

class Goalkeeper:
    def __init__(self, goalkeeper_id, name, team, matches_played):
        self.id = goalkeeper_id
        self.name = name
        self.team = team
        self.matches_played = matches_played

    def to_dict(self):

        return {
            "id": self.id,
            "name": self.name,
            "team": self.team,
            "matchesPlayed": self.matches_played
        }

    def __str__(self):
        return f"Goalkeeper(id={self.id}, name='{self.name}', team='{self.team}', matchesPlayed={self.matches_played})"