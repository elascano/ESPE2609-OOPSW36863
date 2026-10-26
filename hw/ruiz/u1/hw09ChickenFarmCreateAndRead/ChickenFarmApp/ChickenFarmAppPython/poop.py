class Poop:
    def __init__(self, id, color, consistency):
        self._id = id
        self._color = color
        self._consistency = consistency

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, value):
        self._color = value

    @property
    def consistency(self):
        return self._consistency

    @consistency.setter
    def consistency(self, value):
        self._consistency = value

    def __str__(self):
        return f"Poop{{id={self._id}, color={self._color}, consistency={self._consistency}}}"