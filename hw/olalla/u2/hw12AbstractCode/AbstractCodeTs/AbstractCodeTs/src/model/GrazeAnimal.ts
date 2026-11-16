import { Location } from "./Location";

export interface GrazeAnimal {
    /** Send the animal to eat grass at a location */
    graze(location: Location): void;
}
