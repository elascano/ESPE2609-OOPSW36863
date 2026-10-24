
"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

class Egg:

    # Constructor
    def __init__(self, id, size):
        self.id = id
        self.size = size

    def __str__(self):
        return f"Egg{{id={self.id}, size={self.size}}}"

    def getSize(self):
        return self.size

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id
