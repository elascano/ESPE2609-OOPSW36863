class Egg:

    def __init__(self, id, size):
        self.id = id
        self.size = size

    def __str__(self):
        return (
            f"Egg{{"
            f"id={self.id}, "
            f"size={self.size}"
            f"}}"
        )