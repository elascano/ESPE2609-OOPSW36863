import { Location } from "./Location";

/** Interface implemented by animals that can graze. */
export interface GrazeAnimal {
  graze(location: Location): void;
}
