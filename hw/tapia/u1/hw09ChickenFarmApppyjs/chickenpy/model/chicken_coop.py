from model.chicken import Chicken
from model.chicken_filemanager import ChickenFileManager

class ChickenCoop:

    def __init__(self, chickens, chicken_coop_id):

        self.chickens = chickens
        self.chicken_coop_id = chicken_coop_id
        self.current_index = 0

    def add(
            self,
            name,
            color,
            born_on_date,
            molting
    ):

        for i in range(len(self.chickens)):

            if self.chickens[i] is None:

                chicken_id = i + 1

                self.chickens[i] = Chicken(
                    chicken_id,
                    name,
                    color,
                    born_on_date,
                    molting
                )

                print(
                    f"Chicken added --> "
                    f"{name}, "
                    f"ID --> {chicken_id}"
                )

                ChickenFileManager.save_as_csv(
                    self.chickens
                )

                ChickenFileManager.save_as_json(
                    self.chickens
                )

                return

        print("The chicken coop is full")

    def remove(self, chicken_id):

        for i in range(len(self.chickens)):

            if (
                    self.chickens[i] is not None
                    and self.chickens[i].id == chicken_id
            ):

                for j in range(
                        i,
                        len(self.chickens) - 1
                ):
                    self.chickens[j] = \
                        self.chickens[j + 1]

                self.chickens[-1] = None

                self.reassign_ids()

                ChickenFileManager.save_as_csv(
                    self.chickens
                )

                ChickenFileManager.save_as_json(
                    self.chickens
                )

                print(
                    f"Chicken removed --> {chicken_id}"
                )

                return

        print("Chicken not found")

    def reassign_ids(self):

        for i in range(len(self.chickens)):

            if self.chickens[i] is not None:
                self.chickens[i].id = i + 1

    def reset_iteration(self):
        self.current_index = 0

    def next(self):

        while self.current_index < len(self.chickens):

            chicken = self.chickens[
                self.current_index
            ]

            self.current_index += 1

            if chicken is not None:
                return chicken

        return None