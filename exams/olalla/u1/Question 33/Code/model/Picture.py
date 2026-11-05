class Picture:

    def __init__(self, pictureId, author, tittle, year):
        self.pictureId = pictureId
        self.author = author
        self.tittle = tittle
        self.year = year

    def show_information(self):
        print("id:", self.pictureId)
        print("author:", self.author)
        print("tittle:", self.tittle)
        print("year:", self.year)

    def to_dict(self):
            return {
                "id": self.pictureId,
                "title": self.title,
                "author": self.author,
                "year": self.year,
            }
    def ask_picture(pictures):
                while True:
                    try:
                        pic_id = int(input("ID (number, mandatory): "))
                    except ValueError:
                        print("The ID must be a number.")
                        continue
                    if any(p.id == pic_id for p in pictures):
                        print("That ID already exists. Try another one.")
                        continue
                    break
            
                title = input("Title: ")
                author = input("Author: ")
                year = input("Year: ")
                return Picture(pic_id, title, author, year)

    