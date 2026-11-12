/**
 * Shape of a flash drive as it is stored in the JSON file.
 * It only holds plain data (no methods), so it can be written and read with JSON.
 */
export interface FlashDriveRecord {
    id: number;
    brand: string;
    capacityGB: number;
    usbVersion: string;
}
