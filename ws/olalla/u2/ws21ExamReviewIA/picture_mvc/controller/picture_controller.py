from model.picture import Picture


class PictureController:
    """Connects the view with the model."""

    def __init__(self, model, view):
        self.model = model
        self.view = view

    def run(self):
        while True:
            option = self.view.show_menu()
            if option == "1":
                self.create_picture()
            elif option == "2":
                self.read_pictures()
            elif option == "3":
                self.view.show_message("Bye!")
                break
            else:
                self.view.show_message("Invalid option.")

    def create_picture(self):
        picture_id, title, author, year = self.view.ask_picture_data()
        if not picture_id:
            self.view.show_message("Id is mandatory.")
            return
        if not year.isdigit():
            self.view.show_message("Year must be a number.")
            return
        picture = Picture(picture_id, title, author, int(year))
        if self.model.add(picture):
            self.view.show_message("Picture saved in JSON file.")
        else:
            self.view.show_message("A picture with that id already exists.")

    def read_pictures(self):
        self.model.load()   # read again from the JSON file
        self.view.show_pictures(self.model.get_all())
