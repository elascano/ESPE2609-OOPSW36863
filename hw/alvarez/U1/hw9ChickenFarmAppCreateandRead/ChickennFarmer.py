import csv
import json
from datetime import date

JSON_FILE = "chickens.json"
CSV_FILE = "chickens.csv"


def calcular_edad(nacimiento):
    hoy = date.today()
    edad = hoy.year - nacimiento.year
    if (hoy.month, hoy.day) < (nacimiento.month, nacimiento.day):
        edad -= 1
    return edad


def cargar_gallinas():
    try:
        with open(JSON_FILE, encoding="utf-8") as f:
            return json.load(f)
    except (OSError, ValueError):
        return []


def guardar_json(gallinas):
    with open(JSON_FILE, "w", encoding="utf-8") as f:
        json.dump(gallinas, f, indent=2, ensure_ascii=False)
    print(f"[OK] Data successfully saved in: {JSON_FILE}")


def guardar_csv(gallinas):
    with open(CSV_FILE, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(["id", "name", "color", "bornOnDate", "ageInYears", "molting"])
        for g in gallinas:
            w.writerow([g["id"], g["name"], g["color"], g["bornOnDate"],
                        g["ageInYears"], str(g["molting"]).lower()])
    print(f"[OK] Data successfully saved in: {CSV_FILE}")


def pedir_entero(texto):
    while True:
        try:
            return int(input(texto))
        except ValueError:
            print("[!] Enter a valid number.")


def pedir_gallina(gallinas):
    print("\n=== New Chicken Register ===")
    while True:
        id_ = pedir_entero("Enter the ID: ")
        if any(g["id"] == id_ for g in gallinas):
            print("[!] Error: That ID is already registered. Please enter another one.")
        else:
            break
    name = input("Enter the name: ")
    color = input("Enter the color: ")
    while True:
        y = pedir_entero("Enter the year of birth: ")
        m = pedir_entero("Enter the month of birth: ")
        d = pedir_entero("Enter the day of birth: ")
        try:
            nacimiento = date(y, m, d)
            break
        except ValueError:
            print("[!] Invalid date. Try again.")
    molting = input("The chicken is molting? (true or false): ").strip().lower() == "true"
    return {"id": id_, "name": name, "color": color,
            "bornOnDate": nacimiento.isoformat(),
            "ageInYears": calcular_edad(nacimiento), "molting": molting}


def main():
    gallinas = cargar_gallinas()

    print("\n=== New Chicken Register ===")
    n = pedir_entero("How many chickens do you want to add?: ")
    for i in range(n):
        print(f"\n--- Entering new chicken data N.{i + 1} ---")
        gallinas.append(pedir_gallina(gallinas))

    print()
    guardar_json(gallinas)
    guardar_csv(gallinas)

    print("\n=== Reading chickens from the archive ===")
    for g in cargar_gallinas():
        print(f"Chicken{{id={g['id']}, name={g['name']}, color={g['color']}, "
              f"bornOnDate={g['bornOnDate']}, ageInYears={g['ageInYears']}, "
              f"molting={str(g['molting']).lower()}}}")


main()