import { Location } from "./Location";

export abstract class GrazeAnimal {
  abstract graze(location: Location): void;
}
