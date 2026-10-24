class Poop:
    def __init__(self, poop_id, color, consistency):
        self.id = poop_id
        self.color = color
        self.consistency = consistency 

    def __repr__(self):
        return f"Poop{{id={self.id}, color={self.color}, consistency={self.consistency}}}"
