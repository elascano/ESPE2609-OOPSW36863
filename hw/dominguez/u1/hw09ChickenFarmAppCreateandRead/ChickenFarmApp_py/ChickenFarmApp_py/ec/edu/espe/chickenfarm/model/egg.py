class Egg:
    def __init__(self, egg_id, size):
        self.id = egg_id
        self.size = size 

    def __repr__(self):
        return f"Egg{{id={self.id}, size={self.size}}}"
