import { Location } from "./Location";

/** Interfaz para animales que pastan. */
export interface GrazeAnimal {
  graze(location: Location): void;
}
