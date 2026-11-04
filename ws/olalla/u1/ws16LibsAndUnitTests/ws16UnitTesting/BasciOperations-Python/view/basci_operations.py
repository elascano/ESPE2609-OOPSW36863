import math

from model.operation import Operation


def to_java_string(number: float) -> str:
    """Muestra NaN e Infinity como los muestra Java (Python usa nan e inf)."""
    if math.isnan(number):
        return "NaN"
    if math.isinf(number):
        return "Infinity" if number > 0 else "-Infinity"
    return str(number)


def main():
    """
    @author Julian Olalla, 404 Founders, @ESPE
    """
    print("Operations")

    # declare and instialiate an object
    # declare and analize parameters
    # call the method

    operation = Operation()
    print("the addition of 2 and 3 is -->" + to_java_string(operation.add(1.2, 2.4)))
    print("the addition of 2 and 3 is -->" + to_java_string(operation.add(1.2, 2.4)))
    print("the addition of 2 and 3 is -->" + to_java_string(operation.add(1.2, 2.4)))

    print("the addition of 2 and 3 is -->" + to_java_string(operation.divide(0, 0)))


if __name__ == "__main__":
    main()
