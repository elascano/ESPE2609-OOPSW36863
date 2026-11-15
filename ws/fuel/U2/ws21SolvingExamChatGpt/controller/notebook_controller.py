import json
import os
from model.notebook import Notebook


class NotebookController:

    def __init__(self):
        self.archivo = "data/notebooks.json"
        self.notebooks = self.cargar_json()

    def cargar_json(self):

        if not os.path.exists(self.archivo):
            os.makedirs("data", exist_ok=True)

            with open(self.archivo, "w", encoding="utf-8") as archivo:
                json.dump([], archivo)

            return []

        with open(self.archivo, "r", encoding="utf-8") as archivo:
            datos = json.load(archivo)

        notebooks = []

        for dato in datos:
            notebook = Notebook(
                dato["id"],
                dato["marca"],
                dato["modelo"],
                dato["precio"]
            )

            notebooks.append(notebook)

        return notebooks

    def guardar_json(self):

        datos = []

        for notebook in self.notebooks:
            datos.append(notebook.to_dict())

        with open(self.archivo, "w", encoding="utf-8") as archivo:
            json.dump(datos, archivo, indent=4, ensure_ascii=False)

        print("Datos guardados correctamente.")

    def registrar_notebook(self, notebook):

        for n in self.notebooks:
            if n.id == notebook.id:
                print("El ID ya existe.")
                return False

        self.notebooks.append(notebook)
        self.guardar_json()

        print("Notebook registrada correctamente.")
        return True

    def leer_notebooks(self):

        self.notebooks = self.cargar_json()

        if len(self.notebooks) == 0:
            print("No hay notebooks registradas.")
            return

        print("\nLISTA DE NOTEBOOKS")

        for notebook in self.notebooks:
            notebook.mostrar_info()