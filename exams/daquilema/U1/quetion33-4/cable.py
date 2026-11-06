import Classes
import json
import os

FILE = "data.json"

def save_data(cables, devices):
    data = {
        "cables": [c.to_dict() for c in cables],
        "devices": [d.to_dict() for d in devices],
    }
    with open(FILE, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=4, ensure_ascii=False)


def load_data():
    if not os.path.exists(FILE):
        return [], []

    try:
        with open(FILE, "r", encoding="utf-8") as f:
            data = json.load(f)
    except json.JSONDecodeError:
        return [], []

    cables = [Classes.Cable.from_dict(c) for c in data.get("cables", [])]
    devices = [Classes.Device.from_dict(d) for d in data.get("devices", [])]
    return cables, devices

cables, devices = load_data()
exit = False
 
while exit != True:
    print ("Cable Program")
    print (" 1. Add cable ")
    print (" 2. Add device")
    print (" 3. Operations Cable")
    print (" 5. Exit")

    option = input("Enter your option: ")

    if option == "1":
        large = input("Enter the large of cable: ") 
        typeConector = input("Enter the type of conector: ")
        type = input("Enter the type of cable: ")   

        cable = Classes.Cable(large, typeConector, type, len(cables))
        cables.append(cable)
        save_data(cables, devices)   
    

    elif option == "2":
        name = input("Enter the name of the device: ")
        typeConector = input("Enter the type Connector of the device: ")
        
        device = Classes.Device(name, typeConector, len(devices))
        devices.append(device)
        save_data(cables, devices)  

    elif option == "3":
        print("Select a cable: ")
        for i in range(len(cables)):
            print(str(i) + ". " + str(cables[i]))
        cableId = int(input("Enter the id of the cable: "))
        cable = cables[cableId]

        print("Select a device: ")
        for i in range(len(devices)):
            print(str(i) + ". " + str(devices[i]))
        deviceId = int(input("Enter the id of the device: "))
        device = devices[deviceId]

        operation = Classes.OperationsCable(cable, device)
        operation.ConcectDevices(cable, device)

    elif option == "5":
        exit = True

    else:
        print("Error")
        exit = False;
