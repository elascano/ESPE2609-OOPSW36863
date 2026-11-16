class Food:
    __id = 0
    def __init__(self, name: str):
        self.__id = Food.__id
        self.__name = name
        Food.__id += 1
    
    def get_id(self):
        return self.__id
    
    def get_name(self):
        return self.__name
    
    def set_name(self, name: str):
        self.__name = name
    
    def __str__(self):
        return f"Food [id={self.__id}, name={self.__name}]"    