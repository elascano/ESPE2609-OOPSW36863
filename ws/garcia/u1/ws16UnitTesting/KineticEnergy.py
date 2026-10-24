class KineticEnergy:
    def calculate_kinetic_energy(self, mass: float, velocity: float) -> float:
        return 0.5 * mass * (velocity ** 2)