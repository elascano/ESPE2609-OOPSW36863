class VideoProjector:
    def __init__(self, name, id, connect):
        self.name = name
        self.id = id
        self.connect = connect

    def power_on(self):
        
        estado = input("Status (connect/not): ")
        
        
        if estado == "connect":
            self.connect = True
            print("The video projector is turned on.")
        else:
            self.connect = False
            print("The video projector remains off.")

    def add_input(self, data, id_input):
        
        print(f"Input added: {data} on ID: {id_input}")

    def select_source(self):
        
            print("Error: Cannot select source. The projector is turned off.")
            return

    
      