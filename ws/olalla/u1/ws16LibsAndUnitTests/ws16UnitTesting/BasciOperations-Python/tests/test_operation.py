import math
import unittest

from model.operation import Operation


class OperationTest(unittest.TestCase):
    """
    @author Julian Olalla, 404 Founders, @ESPE
    """

    def test_add(self):
        print("add")
        addend1 = 1.2
        addend2 = 3.4
        instance = Operation()
        exp_result = 4.6
        result = instance.add(addend1, addend2)
        self.assertEqual(exp_result, result)

    def test_substract(self):
        print("substract")
        minuhend = 2.0
        subtrahened = 4.0
        instance = Operation()
        exp_result = -2.0
        result = instance.substract(minuhend, subtrahened)
        self.assertEqual(exp_result, result)

    def test_multiply(self):
        print("multiply")
        multiplicand = 3.0
        multiplier = 2.0
        instance = Operation()
        exp_result = 6.0
        result = instance.multiply(multiplicand, multiplier)
        self.assertEqual(exp_result, result)

    def test_divide(self):
        print("divide")
        dividend = 6.0
        divisor = 2.0
        instance = Operation()
        exp_result = 3.0
        result = instance.divide(dividend, divisor)
        self.assertEqual(exp_result, result)

    # ---- pruebas extra: división entre cero (en Java no lanza error) ----

    def test_divide_zero_by_zero_is_nan(self):
        self.assertTrue(math.isnan(Operation().divide(0, 0)))

    def test_divide_by_zero_is_infinity(self):
        self.assertEqual(math.inf, Operation().divide(5, 0))
        self.assertEqual(-math.inf, Operation().divide(-5, 0))


if __name__ == "__main__":
    unittest.main()
