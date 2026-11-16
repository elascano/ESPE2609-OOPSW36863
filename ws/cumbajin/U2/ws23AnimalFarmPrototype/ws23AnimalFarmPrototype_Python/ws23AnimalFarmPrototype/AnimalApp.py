"""WS23 Animal Farm Prototype - Python entry point.

Author: Dylan Cumbajin, MosQ, @ESPE
"""

from controller.AnimalController import AnimalController
from view.AnimalView import AnimalView


def main():
    view = AnimalView()
    controller = AnimalController(view)
    controller.run()


if __name__ == "__main__":
    main()
