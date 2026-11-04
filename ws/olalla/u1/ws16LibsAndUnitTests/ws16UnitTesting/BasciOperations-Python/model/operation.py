import math


class Operation:
    """
    @author Julian Olalla, 404 Founders, @ESPE
    """

    def add(self, addend1: float, addend2: float) -> float:
        sum_ = addend1 + addend2

        # Java usa Math.round, que redondea el .5 hacia arriba.
        # El round() de Python lo redondea al par más cercano, por eso
        # se usa floor(x + 0.5) para obtener el mismo resultado que Java.
        if math.isfinite(sum_):
            sum_ = math.floor(sum_ * 100.0 + 0.5) / 100.0

        return sum_

    def substract(self, minuhend: float, subtrahened: float) -> float:
        difference = minuhend - subtrahened
        return difference

    def multiply(self, multiplicand: float, multiplier: float) -> float:
        product = multiplicand * multiplier
        return product

    def divide(self, dividend: float, divisor: float) -> float:
        # En Java, dividir floats entre 0 no lanza error:
        #   0 / 0  ->  NaN        5 / 0  ->  Infinity        -5 / 0  ->  -Infinity
        # En Python sí lanzaría ZeroDivisionError, así que se replica aquí.
        if divisor == 0:
            if dividend == 0 or math.isnan(dividend):
                return math.nan

            sign = math.copysign(1.0, dividend) * math.copysign(1.0, divisor)
            return math.copysign(math.inf, sign)

        quotient = dividend / divisor
        return quotient
