import os
from chicken import Chicken

FILE_NAME = "chickens.csv"

class CsvManager:

    @staticmethod
    def save_chicken_to_csv(chicken):
        # Verificamos si el archivo ya existe para saber si debemos escribir la cabecera
        file_exists = os.path.exists(FILE_NAME)

        try:
            with open(FILE_NAME, "a", encoding="utf-8") as file:
                # Si el archivo es nuevo, escribimos primero los títulos de las columnas
                if not file_exists:
                    file.write("ID,Name,Color,BornOnDate,AgeInYears,Molting\n")
                
                # Escribimos los datos de la gallina separados por comas
                line = f"{chicken.id},{chicken.name},{chicken.color},{chicken.born_on_date},{chicken.age_in_years},{chicken.molting}\n"
                file.write(line)
            print("--> Chicken saved to CSV file successfully.")
        except Exception as e:
            print(f"Error saving to CSV file: {e}")

    @staticmethod
    def read_chicken_csv():
        print("\n--- CSV FILE CONTENT ---")
        if not os.path.exists(FILE_NAME):
            print("The CSV file is empty or does not exist.")
            print("------------------------")
            return

        try:
            with open(FILE_NAME, "r", encoding="utf-8") as file:
                lines = file.readlines()
                if len(lines) <= 1:
                    print("The CSV file only contains headers or is empty.")
                else:
                    # Mostramos línea por línea omitiendo la cabecera (índice 0)
                    for line in lines[1:]:
                        parts = line.strip().split(",")
                        if len(parts) >= 6:
                            print(f"Chicken --> ID: {parts[0]} | Name: {parts[1]} | Color: {parts[2]} | Born: {parts[3]} | Age: {parts[4]} | Molting: {parts[5]}")
        except Exception as e:
            print(f"Error reading CSV file: {e}")
        print("------------------------")