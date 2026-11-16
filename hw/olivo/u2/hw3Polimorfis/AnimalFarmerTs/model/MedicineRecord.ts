import { Medicine } from './Medicine';

export class MedicineRecord {
    private static idCounter = 1;
    private id: number;
    private medicine: Medicine[];
    private date: Date;

    constructor(medicine: Medicine[], date: Date, id?: number) {
        this.id = id !== undefined ? id : MedicineRecord.idCounter++;
        this.medicine = medicine;
        this.date = date;
        if (this.id >= MedicineRecord.idCounter) {
            MedicineRecord.idCounter = this.id + 1;
        }
    }

    public getId(): number { return this.id; }
    public getMedicine(): Medicine[] { return this.medicine; }
    public getDate(): Date { return this.date; }
    public setMedicine(medicine: Medicine[]): void { this.medicine = medicine; }
    public setDate(date: Date): void { this.date = date; }

    public addMedicine(medicine: Medicine): void {
        this.medicine.push(medicine);
    }

    public administerMedicine(medicineName: string): boolean {
        for (const med of this.medicine) {
            if (med.getName() === medicineName) {
                med.administer();
                return true;
            }
        }
        return false;
    }
}