class Location:
    def __init__(self, location_id, description):
        self.location_id = location_id
        self.description = description

    def __str__(self):
        return f"Location(id={self.location_id}, description={self.description})"