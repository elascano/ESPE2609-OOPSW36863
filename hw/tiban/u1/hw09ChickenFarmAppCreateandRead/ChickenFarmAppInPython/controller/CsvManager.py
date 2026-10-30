import csv

class CsvManager:
    FILE_PATH = "chickens.csv"

    @staticmethod
    def save_chickens(chickens):
        try:
            with open(CsvManager.FILE_PATH, mode='w', newline='', encoding='utf-8') as file:
                writer = csv.writer(file)
                
                writer.writerow(["id", "name", "color", "bornOnDate", "ageInYears", "molting"])
                
                if chickens is not None:
                    for c in chickens:
                        if c is not None:
                            writer.writerow([
                                c.id,
                                c.name,
                                c.color,
                                c.born_on_date.isoformat(), 
                                c.age_in_years,
                                c.molting
                            ])
                            
            print(f"[OK] Data successfully saved in: {CsvManager.FILE_PATH}")
            
        except Exception as e:
            print(f"Could not save the CSV file: {e}")