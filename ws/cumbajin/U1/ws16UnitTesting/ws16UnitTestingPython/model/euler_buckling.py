
# @author Dylan Cumbajin, MosQ, @ESPE

import math


class EulerBuckling:

    def calculateCriticalLoad(self, elasticModulus, momentOfInertia, lengthFactor, columnLength):

        criticalLoad = (math.pi * math.pi * elasticModulus * momentOfInertia) / ((lengthFactor * columnLength) * (lengthFactor * columnLength))

        return criticalLoad
