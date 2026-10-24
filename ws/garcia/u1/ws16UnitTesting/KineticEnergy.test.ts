import { KineticEnergy } from './KineticEnergy';

describe('KineticEnergyTest', () => {

    test('testCalculateKineticEnergy1', () => {
        console.log("calculateKineticEnergy1");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(10.0, 2.0)).toBeCloseTo(20.0, 2);
    });

    test('testCalculateKineticEnergy2', () => {
        console.log("calculateKineticEnergy2");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(2.0, 0.1)).toBeCloseTo(0.01, 20);
    });

    test('testCalculateKineticEnergy3', () => {
        console.log("calculateKineticEnergy3");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(5.0, 0.0)).toBeCloseTo(0.0, 2);
    });

    test('testCalculateKineticEnergy4', () => {
        console.log("calculateKineticEnergy4");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(5.3, 2.1)).toBeCloseTo(11.68, 20);
    });

    test('testCalculateKineticEnergy5', () => {
        console.log("calculateKineticEnergy5");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(10.0, 10.0)).toBeCloseTo(500.0, 2);
    });

    test('testCalculateKineticEnergy6', () => {
        console.log("calculateKineticEnergy6");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(4.5, 2.0)).toBeCloseTo(9.0, 2);
    });

    test('testCalculateKineticEnergy7', () => {
        console.log("calculateKineticEnergy7");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(-4.0, 5.0)).toBeCloseTo(0.0, 20);
    });

    test('testCalculateKineticEnergy8', () => {
        console.log("calculateKineticEnergy8");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(1.0, 1.0)).toBeCloseTo(0.5, 2);
    });

    test('testCalculateKineticEnergy9', () => {
        console.log("calculateKineticEnergy9");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(3.3, 3.3)).toBeCloseTo(17.97, 20);
    });

    test('testCalculateKineticEnergy10', () => {
        console.log("calculateKineticEnergy10");
        const instance = new KineticEnergy();
        expect(instance.calculateKineticEnergy(100.0, 5.0)).toBeCloseTo(1250.0, 2);
    });
});