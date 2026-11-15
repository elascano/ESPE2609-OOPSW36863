from model.notebook import Notebook
from controller.notebook_controller import NotebookController


def menu():

    controller = NotebookController()

    while True:

        print("\n========== SISTEMA DE NOTEBOOKS ==========")
        print("1. Registrar Notebook")
        print("2. Leer Notebooks")
        print("3. Guardar en JSON")
        print("4. Salir")
        print("==========================================")

        opcion = input("Seleccione una opcion: ")

        if opcion == "1":

            try:
                id = int(input("Ingrese el ID: "))
                marca = input("Ingrese la marca: ")
                modelo = input("Ingrese el modelo: ")
                precio = float(input("Ingrese el precio: "))

                if id <= 0 or precio < 0:
                    print("Ingrese un ID positivo y un precio valido.")
                    continue

                notebook = Notebook(id, marca, modelo, precio)

                controller.registrar_notebook(notebook)

            except ValueError:
                print("Error: Ingrese datos validos.")

        elif opcion == "2":

            controller.leer_notebooks()

        elif opcion == "3":

            controller.guardar_json()

        elif opcion == "4":

            print("Programa finalizado.")
            break

        else:

            print("Opcion incorrecta.")