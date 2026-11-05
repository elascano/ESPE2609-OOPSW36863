"""VinylRecord exam implementation by Dominguez Mateo."""
from model.autor import Autor

class VinylRecord:
    def __init__(self, id_record: int, name: str, autor: Autor, gender: str):
        self.__id = id_record
        self.__name = name
        self.__autor = autor
        self.__gender = gender

    def get_id(self):
        return self.__id

    def get_name(self):
        return self.__name

    def get_autor(self):
        return self.__autor

    def get_gender(self):
        return self.__gender

    def to_dict(self):
        return {"id": self.__id, "name": self.__name,
                "autor": self.__autor.to_dict(), "gender": self.__gender}

    @staticmethod
    def from_dict(data):
        return VinylRecord(data["id"], data["name"],
                           Autor.from_dict(data["autor"]), data["gender"])