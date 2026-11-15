class Food:
    def __init__(self, Description: str):
        self.Description = Description

    def __str__(self):
        return self.Description

    def getDescription(self):
        return self.Description

    def setDescription(self, Description: str):
        self.Description = Description
