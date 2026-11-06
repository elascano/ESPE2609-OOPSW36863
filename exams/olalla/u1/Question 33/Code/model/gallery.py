from Picture import Picture
import json
import os

class Gallery:

    @staticmethod
    def from_dict(data):
                return Picture(data["id"], data["title"], data["author"], data["year"])
        
    def __str__(self):
                return f"[{self.pictureId}] '{self.title}' by {self.author} ({self.year})"
        
        
    def save_pictures(pictures, filename=JSON_FILE):
            """Write the list of Picture objects to the JSON file."""
            with open(filename, "w", encoding="utf-8") as f:
                json.dump([p.to_dict() for p in pictures], f, indent=4, ensure_ascii=False)
        
        
    def load_pictures(filename=JSON_FILE):            
            if not os.path.exists(filename):
                return []
            with open(filename, "r", encoding="utf-8") as f:
                return [Picture.from_dict(d) for d in json.load(f)]                        
        
        
    def main():
            pictures = load_pictures()  # list (ArrayList equivalent)
        
            while True:
                print("\n1. Create picture")
                print("2. Show pictures from JSON file")
                print("3. Exit")
                option = input("Choose an option: ")
        
                if option == "1":
                    pictures.append(Picture.ask_picture(pictures))
                    Piccture.save_pictures(pictures)
                    print("Picture saved in", JSON_FILE)
                elif option == "2":
                    pictures = Picture.load_pictures()
                    if not pictures:
                        print("No pictures found.")
                    for p in pictures:
                        print(p)
                elif option == "3":
                    break
                else:
                    print("Invalid option.")
        
        
    if __name__ == "__main__":
            main()
        