from hmac import new

class Cable :
    large = int
    typeConector = str
    type = str
    id = int

    def __init__(self, large, typeConector, type, id):
        self.large = large
        self.typeConector = typeConector
        self.type = type
        self.id = id

    def getLarge(self):
        return self.large
    def getTypeConector(self):
        return self.typeConector
    def getType(self):
        return self.type
    def getId(self):
        return self.id
    def setLarge(self, large):
        self.large = large
    def setTypeConector(self, typeConector):
        self.typeConector = typeConector
    def setType(self, type):
        self.type = type
    def setId(self, id):
        self.id = id

    def __str__(self):
        return "Cable [large=" + str(self.large) + ", typeConector=" + self.typeConector + ", type=" + self.type + ", id=" + str(self.id) + "]" 
    def __repr__(self):
        return self.__str__()
    def to_dict(self):
        return {
            "large": self.large,
            "typeConector": self.typeConector,
            "type": self.type,
            "id": self.id
        }
    @staticmethod
    def from_dict(data):
        return Cable(
            data["large"],
            data["type_connector"],
            data["cable_type"],
            data["id_cable"],
        )
    
class Device :
    type = str
    typeConector = str
    id = int 

    def __init__(self, type, typeConector, id):
        self.type = type
        self.typeConector = typeConector
        self.id = id

    def getType(self):
        return self.type    
    def getTypeConector(self):
        return self.typeConector
    def getId(self):
        return self.id
    def setType(self, type):
        self.type = type
    def setTypeConector(self, typeConector):
        self.typeConector = typeConector    
    def setId(self, id):
        self.id = id    
    def __str__(self):
        return "Device [type=" + self.type + ", typeConector=" + self.typeConector + ", id=" + str(self.id) + "]"       
    def to_dict(self):
        return {
            "type": self.type,
            "typeConector": self.typeConector,
            "id": self.id
        }
    @staticmethod
    def from_dict(data):
        return Device(
            data["name"],
            data["type_connector"],
            data["id_device"],
        )

class OperationsCable :
    cable = Cable
    device = Device

    def __init__(self, cable, device):
        self.cable = cable
        self.device = device

    def getCable(self):
        return self.cable
    def getDevice(self):
        return self.device
    def setCable(self, cable):
        self.cable = cable
    def setDevice(self, device):
        self.device = device

    def ConcectDevices(self, cable, device):
        if (cable.getTypeConector() == device.getTypeConector()):
            print("Conected")
            print ("Select an operation: ")
            option = input("1. Transfer data \n2. Transfer energy \n")
            if option == "1":
                self.TranferData(cable, device)
            elif option == "2": 
                self.TransferEnergy(cable, device)  
        else:
            print("Not conected")


    def TranferData(self, cable, device):
        if (cable.getTypeConector() == device.getTypeConector()):
            print("Transfering data")
        else:
            print("Not transfering data")

    def TransferEnergy(self, cable, device):
        if (cable.getTypeConector() == device.getTypeConector()):
            print("Transfering energy")
        else:
            print("Not transfering energy")

    
            