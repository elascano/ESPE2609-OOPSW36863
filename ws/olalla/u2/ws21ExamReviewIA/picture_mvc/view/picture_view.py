class PictureView:
    """Console interface: only input/output, no logic."""

    def show_menu(self):
        print("\n=== PICTURES ===")
        print("1. Create picture")
        print("2. Read pictures from JSON")
        print("3. Exit")
        return input("Choose an option: ").strip()

    def ask_picture_data(self):
        picture_id = input("Id: ").strip()
        title = input("Title: ").strip()
        author = input("Author: ").strip()
        year = input("Year: ").strip()
        return picture_id, title, author, year

    def show_pictures(self, pictures):
        if not pictures:
            print("No pictures found.")
            return
        for p in pictures:
            print(p)

    def show_message(self, message):
        print(message)
