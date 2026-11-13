from pathlib import Path
import sys

sys.path.insert(0, str(Path(__file__).resolve().parent / "src" / "main" / "python"))
from ec.edu.espe.animalfarm.view.AnimalFarm import AnimalFarm

if __name__ == "__main__":
    AnimalFarm.main(sys.argv[1:])
