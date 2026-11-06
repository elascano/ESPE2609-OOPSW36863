from pathlib import Path

from mixer_repository import MixerRepository
from sound_mixer import SoundMixer


def create_mixer(repo):
    mixer_id = input("ID: ").strip()
    brand = input("Brand: ").strip()
    model = input("Model: ").strip()
    try:
        channel_count = int(input("Channel count: "))
    except ValueError:
        raise ValueError("Enter a whole number for the channel count.") from None
    repo.add(SoundMixer(mixer_id, brand, model, channel_count))
    print("Mixer saved.")


def list_mixers(repo):
    mixers = repo.read()
    if not mixers:
        print("No mixers have been saved.")
    for mixer in mixers:
        print(f"{mixer.id} | {mixer.brand} | {mixer.model} | {mixer.channel_count} channels")


def main():
    file_path = Path(__file__).resolve().parents[1] / "data" / "mixers.json"
    repo = MixerRepository(file_path)
    while True:
        print("\nSound Mixer   1. Create   2. Read from JSON   3. Exit")
        try:
            choice = input("Choice: ").strip()
            if choice == "1":
                create_mixer(repo)
            elif choice == "2":
                list_mixers(repo)
            elif choice == "3":
                return
            else:
                print("Choose 1, 2, or 3.")
        except (EOFError, KeyboardInterrupt):
            return
        except (ValueError, TypeError, OSError) as error:
            print(f"Error: {error}")


if __name__ == "__main__":
    main()
