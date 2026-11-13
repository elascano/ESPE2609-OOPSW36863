from pathlib import Path
import sys

projectDirectory = Path(__file__).resolve().parent
sys.path.insert(0, str(projectDirectory / "src" / "main" / "python"))

from ec.edu.espe.soundmixer.controller.SoundMixerController import SoundMixerController
from ec.edu.espe.soundmixer.view.SoundMixerApp import SoundMixerApp


if __name__ == "__main__":
    controller = SoundMixerController(projectDirectory / "data" / "sound_mixers.json")
    app = SoundMixerApp(controller)
    app.run()
