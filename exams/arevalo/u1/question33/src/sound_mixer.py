from dataclasses import dataclass


@dataclass(frozen=True)
class SoundMixer:
    id: str
    brand: str
    model: str
    channel_count: int

    def __post_init__(self):
        for field in ("id", "brand", "model"):
            value = getattr(self, field)
            if not isinstance(value, str) or not value.strip():
                raise ValueError(f"The {field} field is required.")
        if type(self.channel_count) is not int or self.channel_count < 1:
            raise ValueError("Channel count must be a positive integer.")
