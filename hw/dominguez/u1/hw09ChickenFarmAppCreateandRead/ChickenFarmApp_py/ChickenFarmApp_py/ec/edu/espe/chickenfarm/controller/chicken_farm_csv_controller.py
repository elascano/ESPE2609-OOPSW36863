from datetime import date

from ec.edu.espe.chickenfarm.model.chicken import Chicken
from ec.edu.espe.chickenfarm.model.chicken_coop import ChickenCoop
from ec.edu.espe.chickenfarm.model.chicken_farmer import ChickenFarmer


class ChickenFarmCsvController:
    SEPARATOR = ";"
    HEADER = "farmerId;farmerName;coopId;chickenId;name;color;bornOnDate;molting"

    def save_to_csv(self, chicken_farmer, file_name):
        try:
            with open(file_name, "w", encoding="utf-8") as writer:
                writer.write(self.HEADER + "\n")

                for coop in chicken_farmer.coops:
                    if coop is None:
                        continue
                    for chicken in coop.chickens:
                        if chicken is None:
                            continue
                        fields = [
                            chicken_farmer.chicken_farmer_id,
                            chicken_farmer.name,
                            coop.chicken_coop_id,
                            chicken.id,
                            chicken.name,
                            chicken.color,
                            chicken.born_on_date.isoformat(),
                            str(chicken.molting).lower(),
                        ]
                        writer.write(self.SEPARATOR.join(str(f) for f in fields) + "\n")
            print(f"Archivo {file_name} guardado correctamente")
        except OSError as e:
            print(f"No se pudo guardar el archivo: {e}")

    def load_from_csv(self, file_name):
        chicken_farmer = None

        try:
            with open(file_name, "r", encoding="utf-8") as reader:
                reader.readline()  

                for line in reader:
                    if line.strip() == "":
                        continue
                    data = line.strip().split(self.SEPARATOR)

                    farmer_id = int(data[0])
                    farmer_name = data[1]
                    coop_id = int(data[2])
                    chicken_id = int(data[3])
                    name = data[4]
                    color = data[5]
                    born_on_date = date.fromisoformat(data[6])
                    molting = data[7].lower() == "true"

                    if chicken_farmer is None:
                        chicken_farmer = ChickenFarmer(farmer_id, farmer_name, [None] * 10)

                    coop = None
                    for existing_coop in chicken_farmer.coops:
                        if existing_coop is not None and existing_coop.chicken_coop_id == coop_id:
                            coop = existing_coop
                            break
                    if coop is None:
                        coop = ChickenCoop(coop_id, [None] * 10)
                        chicken_farmer.add(coop)

                    coop.add(Chicken(chicken_id, name, color, born_on_date, molting))

            if chicken_farmer is not None:
                chicken_farmer.reset_iteration()
                for coop in chicken_farmer.coops:
                    if coop is not None:
                        coop.reset_iteration()
        except OSError as e:
            print(f"No se pudo leer el archivo: {e}")
        except (ValueError, IndexError) as e:
            print(f"El archivo CSV tiene un formato incorrecto: {e}")

        return chicken_farmer
