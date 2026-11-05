
/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */

export class EulerBuckling {

    calculateCriticalLoad(elasticModulus: number, momentOfInertia: number, lengthFactor: number, columnLength: number): number {

        let criticalLoad: number;

        criticalLoad = (Math.PI * Math.PI * elasticModulus * momentOfInertia) / ((lengthFactor * columnLength) * (lengthFactor * columnLength));

        return criticalLoad;
    }
}
