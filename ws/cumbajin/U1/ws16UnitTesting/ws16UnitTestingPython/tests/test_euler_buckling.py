
# @author Dylan Cumbajin, MosQ, @ESPE

import unittest
from model.euler_buckling import EulerBuckling


class TestEulerBuckling(unittest.TestCase):

    def setUp(self):
        self.eulerBuckling = EulerBuckling()

    def test01ShortSteelColumn(self):
        result = self.eulerBuckling.calculateCriticalLoad(
            200e9, 0.000008, 1.0, 3.0)
        self.assertAlmostEqual(1754596.3379714412, result, places=5)

    def test02SteelColumn(self):
        result = self.eulerBuckling.calculateCriticalLoad(
            210e9, 0.000005, 1.0, 2.0)
        self.assertAlmostEqual(2590771.155285957, result, places=5)

    def test03AluminumColumn(self):
        result = self.eulerBuckling.calculateCriticalLoad(
            70e9, 0.000003, 1.0, 1.5)
        self.assertAlmostEqual(921163.0774350067, result, places=5)

    def test04ZeroColumnLength(self):
        with self.assertRaises(ValueError):
            self.eulerBuckling.calculateCriticalLoad(
                200e9, 0.000008, 1.0, 0.0)

    def test05NegativeElasticModulus(self):
        with self.assertRaises(ValueError):
            self.eulerBuckling.calculateCriticalLoad(
                -200e9, 0.000008, 1.0, 3.0)

    def test06FixedFixedColumn(self):
        result = self.eulerBuckling.calculateCriticalLoad(
            200e9, 0.000008, 0.5, 3.0)
        self.assertAlmostEqual(7018385.351885765, result, places=5)

    def test07LongSteelColumn(self):
        result = self.eulerBuckling.calculateCriticalLoad(
            200e9,s 0.000008, 1.0, 6.0)
        self.assertAlmostEqual(438649.0844928603, result, places=5)

    def test08ZeroMomentOfInertia(self):
        with self.assertRaises(ValueError):
            self.eulerBuckling.calculateCriticalLoad(
                200e9, 0.0, 1.0, 3.0)

    def test09NegativeLengthFactor(self):
        with self.assertRaises(ValueError):
            self.eulerBuckling.calculateCriticalLoad(
                200e9, 0.000008, -1.0, 3.0)

    def test10DecimalPrecision(self):
        result = self.eulerBuckling.calculateCriticalLoad(
            205e9, 0.0000075, 0.7, 2.75)
        self.assertAlmostEqual(4094995.2482172074, result, places=5)


if __name__ == "__main__":
    unittest.main()
