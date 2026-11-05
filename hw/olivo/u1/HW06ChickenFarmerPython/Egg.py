class Egg:
    __id = 0

    def __init__(self, size):
        Egg.__id += 1
        self.id = Egg.__id
        self.size = size

    def to_dict(self):
        return {
            "id": self.id,
            "size": self.size
        }

    @classmethod
    def from_dict(cls, data):
        egg = cls(data["size"])
        egg.id = data["id"]
        if egg.id > cls.__id:
            cls.__id = egg.id
        return egg

    def __str__(self):
        return f"Egg [ID: {self.id}, Size: {self.size}]"