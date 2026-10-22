
from model.Person import Person

"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

def main():
    print("====================")
    print("| Collections ws   |")
    print("| Dylan Cumbajin  |")
    print("====================")

    things = []
    person = Person(1, "Isabel", 300.25)

    print("sizze of my collection at the beginning -->", len(things))

    things.append(18000)
    things.append("Heloo OOP Programmers from Dylan")
    things.append(4073.78)
    things.append(person)

    print("sizze of my collection now -->", len(things))
    print("my ArrayList elemnts are -->", things)

    things.remove(4073.78)

    print("sizze of my collection now -->", len(things))
    print("my ArrayList elemnts are -->", things)

    print("===================")

    persons = []
    persons.append(person)

    person = Person(2, "Martin Onate", 4000.35)
    persons.append(person)

    person = Person(3, "Erick Revelo", 480.87)
    persons.append(person)

    person = Person(4, "Nestor Olivo", 4480.89)

    print("persons -->", persons)
    print("==================")

    for p in persons:
        print("Person -->", p)

    print("==================")

    for p in persons:
        print("P -->", p)

    for i in range(10):
        persons.append(
            Person(i + 1, "Edison" + str(i + 1), (i + 1) * 1000)
        )

    print("size of persons ArrayList -->", len(persons))

    for p in persons:
        print("Person -->", p)


if __name__ == "__main__":
    main()
