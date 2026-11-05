
# @author Dylan Cumbajin, MosQ, @ESPE

import math


class Operation:

    def add(self, addend1, addend2):
        sum = addend1 + addend2
        # complex algorithm
        sum = math.floor(sum * 100.0 + 0.5) / 100.0
        return sum

    def subtract(self, minuend, subtrahend):
        difference = minuend - subtrahend
        return difference

    def multiply(self, multiplicand, multiplier):
        product = multiplicand * multiplier
        return product

    def divide(self, dividend, divisor):
        quotient = dividend / divisor
        return quotient
