import json
from pathlib import Path

from ec.edu.espe.soundmixer.model.SoundMixer import SoundMixer


class SoundMixerController:
    def __init__(self, filePath: Path):
        self.__filePath = Path(filePath)
        self.__soundMixers: list[SoundMixer] = []

    def createSoundMixer(self, id: int, brand: str, model: str,
                         numberOfChannels: int) -> SoundMixer:
        soundMixer = SoundMixer(id, brand, model, numberOfChannels)
        soundMixers = self.readSoundMixers()
        if any(item.getId() == id for item in soundMixers):
            raise ValueError(f"ID {id} already exists. Use a different ID.")
        soundMixers.append(soundMixer)
        self.__filePath.parent.mkdir(parents=True, exist_ok=True)
        with self.__filePath.open("w", encoding="utf-8") as file:
            json.dump([item.toDictionary() for item in soundMixers], file,
                      indent=4, ensure_ascii=False)
            file.write("\n")
        self.__soundMixers = soundMixers
        return soundMixer

    def readSoundMixers(self) -> list[SoundMixer]:
        if not self.__filePath.exists():
            self.__soundMixers = []
            return []
        try:
            with self.__filePath.open("r", encoding="utf-8") as file:
                records = json.load(file)
        except (json.JSONDecodeError, UnicodeError) as error:
            raise ValueError("The JSON file is invalid. Correct it before continuing.") from error
        if not isinstance(records, list):
            raise ValueError("The JSON file must contain an array of sound mixers.")
        soundMixers = [SoundMixer.fromDictionary(record) for record in records]
        ids = [item.getId() for item in soundMixers]
        if len(ids) != len(set(ids)):
            raise ValueError("The JSON file contains duplicate IDs.")
        self.__soundMixers = soundMixers
        return list(self.__soundMixers)
