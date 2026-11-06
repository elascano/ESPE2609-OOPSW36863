class Speaker:
    def __init__(self, id, brand, power, price):
        self.id = id
        self.brand = brand
        self.power = power
        self.price = price

    def to_dict(self):
        return {
            "id": self.id,
            "brand": self.brand,
            "power": self.power,
            "price": self.price
        }

    def __str__(self):
        return (
            f"ID: {self.id}\n"
            f"Brand: {self.brand}\n"
            f"Power: {self.power}\n"
            f"Price: {self.price}"
        )