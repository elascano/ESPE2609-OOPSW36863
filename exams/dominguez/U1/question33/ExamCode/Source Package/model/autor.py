class Autor:
    def __init__(self, id_autor: int, name: str):
        self.__id = id_autor
        self.__name = name

    def get_id(self):
        return self.__id

    def get_name(self):
        return self.__name

    def to_dict(self):
        return {"id": self.__id, "name": self.__name}

    @staticmethod
    def from_dict(data):
        return Autor(data["id"], data["name"])