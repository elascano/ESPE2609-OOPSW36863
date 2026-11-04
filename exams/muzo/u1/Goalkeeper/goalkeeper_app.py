"""
@author Lesly Muzo, @ESPE
"""

import sys
import os
import json


sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from ec.edu.espe.goalkeeper.model import Goalkeeper

def main():
    print("========================================")
    print("| Goalkeeper - Python  |")
    print("| Lesly Muzo, @ESPE                    |")
    print("========================================")

  
    goalkeepers = []


    goalkeepers.append(Goalkeeper(1, "Manuel Neuer", "Bayern Munich", 120))
    goalkeepers.append(Goalkeeper(2, "Thibaut Courtois", "Real Madrid", 98))

    print("\n--- Arqueros actuales en la lista ---")
    for g in goalkeepers:
        print(g)


    file_name = "goalkeepers.json"
    print(f"\n--- Guardando datos en '{file_name}' ---")
    

    data_to_save = [g.to_dict() for g in goalkeepers]
    
    with open(file_name, "w", encoding="utf-8") as file:
        json.dump(data_to_save, file, indent=4)
    print("¡Archivo JSON guardado con éxito!")

    print(f"\n--- Leyendo datos desde '{file_name}' ---")
    if os.path.exists(file_name):
        with open(file_name, "r", encoding="utf-8") as file:
            loaded_data = json.load(file)
            print("Datos recuperados del JSON:")
            for item in loaded_data:
                print(f" -> ID: {item['id']}, Nombre: {item['name']}, Equipo: {item['team']}, Partidos: {item['matchesPlayed']}")
    else:
        print("El archivo JSON no se encontró.")

if __name__ == "__main__":
    main()