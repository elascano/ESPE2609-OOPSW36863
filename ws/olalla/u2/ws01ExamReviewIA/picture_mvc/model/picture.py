class Picture:
    """Entity: a Picture with a mandatory id plus three more attributes."""

    def __init__(self, id, title, author, year):
        self.id = id          # mandatory attribute
        self.title = title
        self.author = author
        self.year = year

    def to_dict(self):
        return {"id": self.id, "title": self.title,
                "author": self.author, "year": self.year}

    @staticmethod
    def from_dict(data):
        return Picture(data["id"], data["title"], data["author"], data["year"])

    def __str__(self):
        return f"[{self.id}] '{self.title}' by {self.author} ({self.year})"
