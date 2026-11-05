import json
import os
from model.vinyl_record import VinylRecord

class Inventory:
    def __init__(self):
        self.__records = []

    def addVinyl(self, vinyl: VinylRecord):
        self.__records.append(vinyl)

    def removeVinyl(self, id_record: int):
        self.__records = [r for r in self.__records if r.get_id() != id_record]

    def get_records(self):
        return self.__records

    def load_from_json(self, path: str):
        if not os.path.exists(path):
            print("Archivo no encontrado, se inicia con inventario vacío.")
            return
        with open(path, "r", encoding="utf-8") as f:
            data = json.load(f)
        self.__records = [VinylRecord.from_dict(d) for d in data]
        print(f"Se cargaron {len(self.__records)} discos.")

    def save_to_json(self, path: str):
        with open(path, "w", encoding="utf-8") as f:
            json.dump([r.to_dict() for r in self.__records], f,
                      indent=4, ensure_ascii=False)
        print("Inventario guardado en", path)