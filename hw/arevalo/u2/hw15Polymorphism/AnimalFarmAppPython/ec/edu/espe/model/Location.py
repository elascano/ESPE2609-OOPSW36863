class Location:
    def __init__(self, id: int, description: str):
        self._id = id
        self._description = description

    def __str__(self):
        return f"Location{{id={self._id}, description={self._description}}}"

    def getId(self):
        return self._id

    def setId(self, id: int):
        self._id = id

    def getDescription(self):
        return self._description

    def setDescription(self, description: str):
        self._description = description
