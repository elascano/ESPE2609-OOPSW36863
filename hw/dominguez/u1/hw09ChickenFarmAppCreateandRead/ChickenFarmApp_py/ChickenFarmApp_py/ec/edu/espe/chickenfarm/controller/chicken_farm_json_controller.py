import json
from datetime import date

from ec.edu.espe.chickenfarm.model.chicken import Chicken
from ec.edu.espe.chickenfarm.model.chicken_coop import ChickenCoop
from ec.edu.espe.chickenfarm.model.chicken_farmer import ChickenFarmer


class ChickenFarmJsonController:

    def _chicken_to_dict(self, chicken):
        if chicken is None:
            return None
        return {
            "id": chicken.id,
            "name": chicken.name,
            "color": chicken.color,
            "born_on_date": chicken.born_on_date.isoformat(),
            "age_in_years": chicken.age_in_years,
            "molting": chicken.molting,
        }

    def _coop_to_dict(self, coop):
        if coop is None:
            return None
        return {
            "chicken_coop_id": coop.chicken_coop_id,
            "chickens": [self._chicken_to_dict(c) for c in coop.chickens],
            "current_index": coop.current_index,
        }

    def _farmer_to_dict(self, farmer):
        return {
            "chicken_farmer_id": farmer.chicken_farmer_id,
            "name": farmer.name,
            "coops": [self._coop_to_dict(c) for c in farmer.coops],
            "current_index": farmer.current_index,
        }

    def _dict_to_chicken(self, data):
        if data is None:
            return None
        chicken = Chicken(data["id"], data["name"], data["color"],
                          date.fromisoformat(data["born_on_date"]), data["molting"])
        chicken.age_in_years = data["age_in_years"]
        return chicken

    def _dict_to_coop(self, data):
        if data is None:
            return None
        chickens = [self._dict_to_chicken(c) for c in data["chickens"]]
        coop = ChickenCoop(data["chicken_coop_id"], chickens)
        coop.current_index = data["current_index"]
        return coop

    def _dict_to_farmer(self, data):
        coops = [self._dict_to_coop(c) for c in data["coops"]]
        farmer = ChickenFarmer(data["chicken_farmer_id"], data["name"], coops)
        farmer.current_index = data["current_index"]
        return farmer

    def save_to_json(self, chicken_farmer, file_name):
        text = json.dumps(self._farmer_to_dict(chicken_farmer), indent=2, ensure_ascii=False)
        print("JSON -->\n" + text)

        try:
            with open(file_name, "w", encoding="utf-8") as file:
                file.write(text)
            print(f"Archivo {file_name} guardado correctamente")
        except OSError as e:
            print(f"No se pudo guardar el archivo: {e}")

    def load_from_json(self, file_name):
        chicken_farmer = None

        try:
            with open(file_name, "r", encoding="utf-8") as file:
                chicken_farmer = self._dict_to_farmer(json.load(file))
        except OSError as e:
            print(f"No se pudo leer el archivo: {e}")
        except (ValueError, KeyError, TypeError) as e:
            print(f"El archivo JSON tiene un formato incorrecto: {e}")

        return chicken_farmer
