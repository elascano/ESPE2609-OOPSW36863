class Location:
    def __init__(self, id, description):
        self.id = id
        self.description = description

    def __str__(self):
        return  "{id = " + (self.id) + "description = " + (self.description) + "}"