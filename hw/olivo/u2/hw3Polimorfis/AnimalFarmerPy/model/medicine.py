class Medicine:
    __id = 0
    def __init__(self, name:str, description:str, price:float):
        self.__id = Medicine.__id
        self.__name = name
        self.__description = description
        self.__price = price
        Medicine.__id += 1

    def get_id(self):
        return self.__id

    def get_name(self):
        return self.__name

    def set_name(self, name: str):
        self.__name = name

    def get_description(self):
        return self.__description

    def set_description(self, description: str):
        self.__description = description

    def get_price(self):
        return self.__price

    def set_price(self, price: float):
        self.__price = price

    def __str__(self):
        return f"Medicine [id={self.__id}, name={self.__name}, description={self.__description}, price={self.__price}]"
    
    def administer(self):
        print(f"Administering medicine: {self.__name}")