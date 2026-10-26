
/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */

import { describe, test, expect } from "vitest";
import { EulerBuckling } from "../src/model/EulerBuckling";

describe("EulerBuckling Unit Testing", () => {

    const eulerBuckling = new EulerBuckling();

    test("test01ShortSteelColumn", () => {
        const result = eulerBuckling.calculateCriticalLoad(
            200e9, 0.000008, 1.0, 3.0);
        expect(result).toBeCloseTo(1754596.3379714412, 5);
    });

    test("test02SteelColumn", () => {
        const result = eulerBuckling.calculateCriticalLoad(
            210e9, 0.000005, 1.0, 2.0);
        expect(result).toBeCloseTo(2590771.155285957, 5);
    });

    test("test03AluminumColumn", () => {
        const result = eulerBuckling.calculateCriticalLoad(
            70e9, 0.000003, 1.0, 1.5);
        expect(result).toBeCloseTo(921163.0774350067, 5);
    });

    test("test04ZeroColumnLength", () => {
        expect(() => eulerBuckling.calculateCriticalLoad(
            200e9, 0.000008, 1.0, 0.0)).toThrow();
    });

    test("test05NegativeElasticModulus", () => {
        expect(() => eulerBuckling.calculateCriticalLoad(
            -200e9, 0.000008, 1.0, 3.0)).toThrow();
    });

    test("test06FixedFixedColumn", () => {
        const result = eulerBuckling.calculateCriticalLoad(
            200e9, 0.000008, 0.5, 3.0);
        expect(result).toBeCloseTo(7018385.351885765, 5);
    });

    test("test07LongSteelColumn", () => {
        const result = eulerBuckling.calculateCriticalLoad(
            200e9, 0.000008, 1.0, 6.0);
        expect(result).toBeCloseTo(438649.0844928603, 5);
    });

    test("test08ZeroMomentOfInertia", () => {
        expect(() => eulerBuckling.calculateCriticalLoad(
            200e9, 0.0, 1.0, 3.0)).toThrow();
    });

    test("test09NegativeLengthFactor", () => {
        expect(() => eulerBuckling.calculateCriticalLoad(
            200e9, 0.000008, -1.0, 3.0)).toThrow();
    });

    test("test10DecimalPrecision", () => {
        const result = eulerBuckling.calculateCriticalLoad(
            205e9, 0.0000075, 0.7, 2.75);
        expect(result).toBeCloseTo(4094995.2482172074, 5);
    });

});
