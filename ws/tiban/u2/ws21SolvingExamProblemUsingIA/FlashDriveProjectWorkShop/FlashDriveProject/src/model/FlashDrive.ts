import { FlashDriveRecord } from "./FlashDriveRecord";

/**
 * Model class: represents one flash drive (USB memory).
 */
export class FlashDrive {
    private id: number;
    private brand: string;
    private capacityGB: number;
    private usbVersion: string;

    constructor(id: number, brand: string, capacityGB: number, usbVersion: string) {
        this.id = id;
        this.brand = brand;
        this.capacityGB = capacityGB;
        this.usbVersion = usbVersion;
    }

    /** Creates a FlashDrive object from the plain data read from the JSON file. */
    public static fromRecord(record: FlashDriveRecord): FlashDrive {
        return new FlashDrive(record.id, record.brand, record.capacityGB, record.usbVersion);
    }

    /** Converts this object into plain data that can be saved in the JSON file. */
    public toRecord(): FlashDriveRecord {
        return {
            id: this.id,
            brand: this.brand,
            capacityGB: this.capacityGB,
            usbVersion: this.usbVersion
        };
    }

    public getId(): number {
        return this.id;
    }

    public getBrand(): string {
        return this.brand;
    }

    public getCapacityGB(): number {
        return this.capacityGB;
    }

    public getUsbVersion(): string {
        return this.usbVersion;
    }

    public setId(id: number): void {
        this.id = id;
    }

    public setBrand(brand: string): void {
        this.brand = brand;
    }

    public setCapacityGB(capacityGB: number): void {
        this.capacityGB = capacityGB;
    }

    public setUsbVersion(usbVersion: string): void {
        this.usbVersion = usbVersion;
    }

    public toString(): string {
        return `FlashDrive{id=${this.id}, brand='${this.brand}', ` +
            `capacityGB=${this.capacityGB}, usbVersion='${this.usbVersion}'}`;
    }
}
