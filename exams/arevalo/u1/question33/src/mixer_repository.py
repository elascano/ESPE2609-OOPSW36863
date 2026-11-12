import json
from dataclasses import asdict
from pathlib import Path

from sound_mixer import SoundMixer


class MixerRepository:
    def __init__(self, file_path: Path):
        self.file_path = file_path

    def read(self) -> list[SoundMixer]:
        if not self.file_path.exists():
            return []
        records = json.loads(self.file_path.read_text(encoding="utf-8"))
        if not isinstance(records, list):
            raise ValueError("Expected a list in the JSON file.")
        
        legacy_keys = {"marca": "brand", "modelo": "model", "canales": "channel_count"}
        mixers = []
        for record in records:
            if not isinstance(record, dict):
                raise ValueError("Expected each mixer to be a JSON object.")
            fields = {legacy_keys.get(key, key): value for key, value in record.items()}
            mixers.append(SoundMixer(**fields))
        return mixers

    def add(self, mixer: SoundMixer):
        mixers = self.read()
        if any(item.id.casefold() == mixer.id.casefold() for item in mixers):
            raise ValueError("A mixer with that ID already exists.")
        mixers.append(mixer)
        records = [asdict(item) for item in mixers]
        temporary_file = self.file_path.with_suffix(".tmp")
        temporary_file.write_text(json.dumps(records, ensure_ascii=False, indent=2) + "\n",
                            encoding="utf-8")
        temporary_file.replace(self.file_path)
