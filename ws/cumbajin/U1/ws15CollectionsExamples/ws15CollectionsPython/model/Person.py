
"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

class Person:

    # Constructor
    def __init__(self, id, name, salary):
        self.id = id
        self.name = name
        self.salary = salary

    def __str__(self):
        return (f"id={self.id}, name={self.name}, "
                f"salary={self.salary}")

    def __repr__(self):
        return self.__str__()

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    def getSalary(self):
        return self.salary

    def setSalary(self, salary):
        self.salary = salary
