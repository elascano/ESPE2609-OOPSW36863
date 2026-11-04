import sys
from pathlib import Path

sys.path.append(str(Path(__file__).resolve().parent.parent))

from model.inventory import Inventory
from model.autor import Autor
from model.vinyl_record import VinylRecord

def main():
    JSON_FILE = str(Path(__file__).resolve().parent.parent / "vinyl_data.json")
    my_inventory = Inventory()
    
    print("--- 1. READ FILE ---")
    my_inventory.load_from_json(JSON_FILE)
    
    print("\n--- 2. CREATE AND ADD NEW OBJECTS ---")
    autor1 = Autor(101, "Elvis Presley")
    disc1 = VinylRecord(1, "Jailhouse Rock", autor1, "Rock")
    
    autor2 = Autor(102, "Michael Jackson")
    disc2 = VinylRecord(2, "Thriller", autor2, "Pop")
    
    my_inventory.addVinyl(disc1)
    my_inventory.addVinyl(disc2)
    print("2 new records were added to the inventory.")
    
    print("\n--- 3. SAVE TO JSON ---")
    my_inventory.save_to_json(JSON_FILE)
    
    print("\n--- 4. CURRENT DISCS IN MEMORY ---")
    for record in my_inventory.get_records():
        print(f"Disc: {record.get_name()} | Autor: {record.get_autor().get_name()}")

if __name__ == "__main__":
    main()