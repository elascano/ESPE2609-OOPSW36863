export class KineticEnergy {
    public calculateKineticEnergy(mass: number, velocity: number): number {
        return 0.5 * mass * (velocity ** 2);
    }
}