import json
import os


class Notebook:

    def __init__(self, id, marca, modelo, precio):
        self.id = id
        self.marca = marca
        self.modelo = modelo
        self.precio = precio

    def to_dict(self):
        return {
            "id": self.id,
            "marca": self.marca,
            "modelo": self.modelo,
            "precio": self.precio
        }

    def mostrar_info(self):
        print("ID:", self.id)
        print("Marca:", self.marca)
        print("Modelo:", self.modelo)
        print("Precio:", self.precio)
        print("------------------------")


lista_notebooks = []
archivo_json = "notebooks.json"


def cargar_json():

    if os.path.exists(archivo_json):

        with open(archivo_json, "r", encoding="utf-8") as archivo:
            datos = json.load(archivo)

        for dato in datos:
            notebook = Notebook(
                dato["id"],
                dato["marca"],
                dato["modelo"],
                dato["precio"]
            )

            lista_notebooks.append(notebook)


def registrar_notebook():

    print("\nREGISTRAR NOTEBOOK")

    try:
        id = int(input("Ingrese el ID: "))

        for notebook in lista_notebooks:
            if notebook.id == id:
                print("El ID ya existe.")
                return

        marca = input("Ingrese la marca: ")
        modelo = input("Ingrese el modelo: ")
        precio = float(input("Ingrese el precio: "))

        if precio < 0:
            print("El precio no puede ser negativo.")
            return

        notebook = Notebook(id, marca, modelo, precio)

        lista_notebooks.append(notebook)

        print("Notebook registrada correctamente.")

    except ValueError:
        print("Ingrese datos validos.")


def guardar_json():

    datos = []

    for notebook in lista_notebooks:
        datos.append(notebook.to_dict())

    with open(archivo_json, "w", encoding="utf-8") as archivo:
        json.dump(datos, archivo, indent=4, ensure_ascii=False)

    print("Datos guardados correctamente.")


def leer_json():

    print("\nLISTA DE NOTEBOOKS")

    if not os.path.exists(archivo_json):
        print("No existe archivo .")
        return

    with open(archivo_json, "r", encoding="utf-8") as archivo:
        datos = json.load(archivo)

    if len(datos) == 0:
        print("No hay notebooks registradas.")
        return

    for dato in datos:

        notebook = Notebook(
            dato["id"],
            dato["marca"],
            dato["modelo"],
            dato["precio"]
        )

        notebook.mostrar_info()


def menu():

    cargar_json()

    while True:

        print("NOTEBOOK")
        print("1. Registrar Notebook")
        print("2. Guardar en archivo JSON")
        print("3. Leer desde archivo JSON")
        print("4. Salir")
        
        opcion = input("Seleccione una opcion: ")

        if opcion == "1":
            registrar_notebook()

        elif opcion == "2":
            guardar_json()

        elif opcion == "3":
            leer_json()

        elif opcion == "4":
            print("Programa finalizado.")
            break

        else:
            print("Opcion incorrecta.")


menu()