from ec.edu.espe.soundmixer.controller.SoundMixerController import SoundMixerController


class SoundMixerApp:
    def __init__(self, controller: SoundMixerController):
        self.__controller = controller

    def run(self):
        while True:
            print("\nSOUND MIXER")
            print("1. Create sound mixer")
            print("2. Read sound mixers from JSON")
            print("3. Exit")
            try:
                option = input("Select an option: ")
                if option == "1":
                    self.createSoundMixer()
                elif option == "2":
                    self.readSoundMixers()
                elif option == "3":
                    print("Goodbye!")
                    break
                else:
                    print("Invalid option. Select 1, 2 or 3.")
            except (ValueError, OSError) as error:
                print(f"Error: {error}")
            except (EOFError, KeyboardInterrupt):
                print("\nGoodbye!")
                break

    def createSoundMixer(self):
        try:
            id = int(input("ID: "))
        except ValueError:
            raise ValueError("ID must be a positive integer.") from None
        brand = input("Brand: ")
        model = input("Model: ")
        try:
            channels = int(input("Number of channels: "))
        except ValueError:
            raise ValueError("Number of channels must be a positive integer.") from None
        self.__controller.createSoundMixer(id, brand, model, channels)
        print("Sound mixer created and saved to JSON.")

    def readSoundMixers(self):
        soundMixers = self.__controller.readSoundMixers()
        if not soundMixers:
            print("No sound mixers found.")
            return
        for mixer in soundMixers:
            print(f"\nID: {mixer.getId()}")
            print(f"Brand: {mixer.getBrand()}")
            print(f"Model: {mixer.getModel()}")
            print(f"Number of channels: {mixer.getNumberOfChannels()}")
        print(f"\nTotal sound mixers: {len(soundMixers)}")
