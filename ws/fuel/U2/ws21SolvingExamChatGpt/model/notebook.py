class Notebook:

    def __init__(self, id, marca, modelo, precio):
        self.id = id
        self.marca = marca
        self.modelo = modelo
        self.precio = precio

    def to_dict(self):
        return {
            "id": self.id,
            "marca": self.marca,
            "modelo": self.modelo,
            "precio": self.precio
        }

    def mostrar_info(self):
        print("ID:", self.id)
        print("Marca:", self.marca)
        print("Modelo:", self.modelo)
        print("Precio:", self.precio)
        print("------------------------")