
# @author Dylan Cumbajin, MosQ, @ESPE

from model.operation import Operation


class BasicOperations:

    @staticmethod
    def main():
        print("Operations!")

        # declare and instantiate an object
        # declare and initialize parameters
        # call the method

        operation = Operation()

        print("the addition of 1.2 and 2.4 is -->", operation.add(1.2, 2.4))
        print("the addition of 1.2 and 2.4 is -->", operation.add(1.2, 2.4))
        print("the addition of 1.2 and 2.4 is -->", operation.add(1.2, 2.4))

        print("divide -->", operation.divide(1, 0))

        # enter data from keyboard
        # call the method
        # observe the results


if __name__ == "__main__":
    BasicOperations.main()
