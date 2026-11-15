class FarmView:
    def print_title(self):
        print("Hello this is Ariel's Animal Farm - Abstraction Exercise")
    def print_separator(self, title: str):
        print(f"\n--- {title} ---")
    def print_message(self, msg: str):
        print(msg)
    def print_animal_type(self, var_name: str, class_name: str):
        print(f"{var_name} is a --> {class_name}")