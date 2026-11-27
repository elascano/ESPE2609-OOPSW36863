/**
 * ContactBook - WS29 TypeScript
 * Modelo equivalente a Contact.java del proyecto Java Swing original.
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
namespace ContactBook {
  export class Contact {
    private id: number;
    private firstName: string;
    private lastName: string;
    private email: string;
    private isKnown: boolean;
    private cellPhoneNumber: string;
    private type: string;
    private grade: string; // Java char: TypeScript representa caracteres con string.
    private hobbies: string[];
    private instagram: string;
    private birthDate: Date | null;

    constructor(
      id = 0,
      firstName = "",
      lastName = "",
      email = "",
      isKnown = false,
      cellPhoneNumber = "",
      type = "",
      grade = "",
      hobbies: string[] = [],
      instagram = "",
      birthDate: Date | null = null
    ) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.isKnown = isKnown;
      this.cellPhoneNumber = cellPhoneNumber;
      this.type = type;
      this.grade = grade;
      this.hobbies = [...hobbies];
      this.instagram = instagram;
      this.birthDate = birthDate;
    }

    getId(): number { return this.id; }
    setId(id: number): void { this.id = id; }

    getFirstName(): string { return this.firstName; }
    setFirstName(firstName: string): void { this.firstName = firstName; }

    getLastName(): string { return this.lastName; }
    setLastName(lastName: string): void { this.lastName = lastName; }

    getEmail(): string { return this.email; }
    setEmail(email: string): void { this.email = email; }

    getIsKnown(): boolean { return this.isKnown; }
    setKnown(isKnown: boolean): void { this.isKnown = isKnown; }

    getCellPhoneNumber(): string { return this.cellPhoneNumber; }
    setCellPhoneNumber(cellPhoneNumber: string): void { this.cellPhoneNumber = cellPhoneNumber; }

    getType(): string { return this.type; }
    setType(type: string): void { this.type = type; }

    getGrade(): string { return this.grade; }
    setGrade(grade: string): void { this.grade = grade; }

    getHobbies(): string[] { return [...this.hobbies]; }
    setHobbies(hobbies: string[]): void { this.hobbies = [...hobbies]; }

    getInstagram(): string { return this.instagram; }
    setInstagram(instagram: string): void { this.instagram = instagram; }

    getBirthDate(): Date | null { return this.birthDate; }
    setBirthDate(birthDate: Date | null): void { this.birthDate = birthDate; }

    toString(): string {
      return `id=${this.id}`
        + `\n firstName=${this.firstName}`
        + `\n lastName=${this.lastName}`
        + `\n email=${this.email}`
        + `\n isKnown=${this.isKnown}`
        + `\n cellPhoneNumber=${this.cellPhoneNumber}`
        + `\n type=${this.type}`
        + `\n grade=${this.grade}`
        + `\n hobbies=[${this.hobbies.join(", ")}]`
        + `\n instagram=${this.instagram}`
        + `\n birthDate=${this.birthDate?.toString() ?? "null"}`;
    }
  }
}
