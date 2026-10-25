
"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

class Poop:

    def __init__(self, id, color, consistency):
        self.id = id
        self.color = color
        self.consistency = consistency

    def __str__(self):
        return (f"Poop{{id={self.id}, color={self.color}, "f"consistency={self.consistency}}}")

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getColor(self):
        return self.color

    def setColor(self, color):
        self.color = color

    def getConsistency(self):
        return self.consistency

    def setConsistency(self, consistency):
        self.consistency = consistency
