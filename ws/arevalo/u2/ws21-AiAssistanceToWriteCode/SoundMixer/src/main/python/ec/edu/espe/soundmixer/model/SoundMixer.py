class SoundMixer:
    def __init__(self, id: int, brand: str, model: str, numberOfChannels: int):
        if type(id) is not int or id <= 0:
            raise ValueError("ID must be a positive integer.")
        if not isinstance(brand, str) or not brand.strip():
            raise ValueError("Brand is required.")
        if not isinstance(model, str) or not model.strip():
            raise ValueError("Model is required.")
        if type(numberOfChannels) is not int or numberOfChannels <= 0:
            raise ValueError("Number of channels must be a positive integer.")
        self.__id = id
        self.__brand = brand.strip()
        self.__model = model.strip()
        self.__numberOfChannels = numberOfChannels

    def getId(self) -> int:
        return self.__id

    def getBrand(self) -> str:
        return self.__brand

    def getModel(self) -> str:
        return self.__model

    def getNumberOfChannels(self) -> int:
        return self.__numberOfChannels

    def toDictionary(self) -> dict:
        return {
            "id": self.__id,
            "brand": self.__brand,
            "model": self.__model,
            "numberOfChannels": self.__numberOfChannels,
        }

    @classmethod
    def fromDictionary(cls, data: dict) -> "SoundMixer":
        fields = {"id", "brand", "model", "numberOfChannels"}
        if not isinstance(data, dict) or set(data) != fields:
            raise ValueError("Each JSON record must contain id, brand, model and numberOfChannels.")
        return cls(data["id"], data["brand"], data["model"], data["numberOfChannels"])
