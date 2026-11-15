class Truck:
    def __init__(self, truck_id, brand, model_year, max_load):
        self.truck_id = truck_id
        self.brand = brand
        self.model_year = model_year
        self.max_load = max_load

    def to_dictionary(self):
        return {
            "truck_id": self.truck_id,
            "brand": self.brand,
            "model_year": self.model_year,
            "max_load": self.max_load
        }

    @classmethod
    def from_dictionary(cls, data):
        return cls(data["truck_id"], data["brand"], data["model_year"], data["max_load"])