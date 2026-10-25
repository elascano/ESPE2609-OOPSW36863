class Person:
    def __init__(self, id_person, name, salary):
        self.id = id_person
        self.name = name
        self.salary = salary

    def __str__(self):
        return f"Person{{id={self.id}, name={self.name}, salary={self.salary}}}"
    
    def __repr__(self):
        return self.__str__()
        
    def get_id(self):
        return self.id

def main():
    print("=============")
    print("| Collections ws |")
    print("| Jesus Garcia   |")
    print("==============")
    
    things = []
    person = Person(1, "Yisus Garcia", 3000.25)
    
    print(f"size of my collection at the beginning --> {len(things)}")
    
    things.append(18000)
    things.append("Hello OOP Programmers from Jesus")
    things.append(4073.78)
    things.append(person)
    
    print(f"size of my collection now --> {len(things)}")
    print(f"My ArrayList elements are --> {things}")
    
    things.remove(4073.78)
    print(f"size of my collection now --> {len(things)}")
    print(f"My ArrayList elements are --> {things}")
    
    print("===========")
    
    persons = []
    persons.append(person)
    person = Person(2, "Martin Onate", 400.35)
    persons.append(person)
    persons.append(Person(3, "Erick Revelo", 480.87))
    persons.append(Person(4, "Nestor Olivo", 4480.87))
    
    print(f"persons --> {persons}")
    print("============")
    
    for p in persons:
        print(f"Person -->{p}")
        
    print("============")
    
    for p in persons:
        print(f"P --> {p}")
        
    for i in range(10):
        persons.append(Person(i + 1, f"Jesus {i + 1}", (i + 1) * 1000))
        
    print(f"size of persons ArrayList --> {len(persons)}")
    for p in persons:
        print(f"Person -->{p}")

if __name__ == "__main__":
    main()