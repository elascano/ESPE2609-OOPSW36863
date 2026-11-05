import unittest
from kinetic_energy import KineticEnergy

class TestKineticEnergy(unittest.TestCase):

    def test_calculate_kinetic_energy_1(self):
        print("calculateKineticEnergy1")
        instance = KineticEnergy()
        self.assertAlmostEqual(20.0, instance.calculate_kinetic_energy(10.0, 2.0), delta=0.01)

    def test_calculate_kinetic_energy_2(self):
        print("calculateKineticEnergy2")
        instance = KineticEnergy()
        self.assertAlmostEqual(0.01, instance.calculate_kinetic_energy(2.0, 0.1), delta=0)

    def test_calculate_kinetic_energy_3(self):
        print("calculateKineticEnergy3")
        instance = KineticEnergy()
        self.assertAlmostEqual(0.0, instance.calculate_kinetic_energy(5.0, 0.0), delta=0.01)

    def test_calculate_kinetic_energy_4(self):
        print("calculateKineticEnergy4")
        instance = KineticEnergy()
        self.assertAlmostEqual(11.68, instance.calculate_kinetic_energy(5.3, 2.1), delta=0)

    def test_calculate_kinetic_energy_5(self):
        print("calculateKineticEnergy5")
        instance = KineticEnergy()
        self.assertAlmostEqual(500.0, instance.calculate_kinetic_energy(10.0, 10.0), delta=0.01)

    def test_calculate_kinetic_energy_6(self):
        print("calculateKineticEnergy6")
        instance = KineticEnergy()
        self.assertAlmostEqual(9.0, instance.calculate_kinetic_energy(4.5, 2.0), delta=0.01)

    def test_calculate_kinetic_energy_7(self):
        print("calculateKineticEnergy7")
        instance = KineticEnergy()
        self.assertAlmostEqual(0.0, instance.calculate_kinetic_energy(-4.0, 5.0), delta=0)

    def test_calculate_kinetic_energy_8(self):
        print("calculateKineticEnergy8")
        instance = KineticEnergy()
        self.assertAlmostEqual(0.5, instance.calculate_kinetic_energy(1.0, 1.0), delta=0.01)

    def test_calculate_kinetic_energy_9(self):
        print("calculateKineticEnergy9")
        instance = KineticEnergy()
        self.assertAlmostEqual(17.97, instance.calculate_kinetic_energy(3.3, 3.3), delta=0)

    def test_calculate_kinetic_energy_10(self):
        print("calculateKineticEnergy10")
        instance = KineticEnergy()
        self.assertAlmostEqual(1250.0, instance.calculate_kinetic_energy(100.0, 5.0), delta=0.01)

if __name__ == '__main__':
    unittest.main()