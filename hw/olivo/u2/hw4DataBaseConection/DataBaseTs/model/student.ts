export interface StudentDocument {
  id: number;
  name: string;
  birth_day: Date;
  dni: string;
  age_in_years: number;
}

export class Student {
  private static nextId = 0;

  private id: number;
  private name: string;
  private birthDay: Date;
  private dni: string;
  private ageInYears: number;

  constructor(name: string, birthDay: Date, dni: string, studentId?: number) {
    this.name = name;
    this.birthDay = birthDay;
    this.dni = dni;
    this.ageInYears = this.computeAgeInYears();

    if (studentId === undefined) {
      Student.nextId += 1;
      this.id = Student.nextId;
    } else {
      this.id = studentId;
    }
  }

  public computeAgeInYears(): number {
    const today = new Date();
    let age = today.getFullYear() - this.birthDay.getFullYear();

    const monthDiff = today.getMonth() - this.birthDay.getMonth();
    const dayDiff = today.getDate() - this.birthDay.getDate();

    if (monthDiff < 0 || (monthDiff === 0 && dayDiff < 0)) {
      age -= 1;
    }

    return age;
  }

  public toDocument(): StudentDocument {
    return {
      id: this.id,
      name: this.name,
      birth_day: this.birthDay,
      dni: this.dni,
      age_in_years: this.ageInYears,
    };
  }

  public getId(): number {
    return this.id;
  }

  public setId(id: number): void {
    this.id = id;
  }

  public getAgeInYears(): number {
    return this.ageInYears;
  }

  public setAgeInYears(age: number): void {
    this.ageInYears = age;
  }

  public getDni(): string {
    return this.dni;
  }

  public setDni(dni: string): void {
    this.dni = dni;
  }

  public getName(): string {
    return this.name;
  }

  public setName(name: string): void {
    this.name = name;
  }

  public getBirthDay(): Date {
    return this.birthDay;
  }

  public setBirthDay(birthDay: Date): void {
    this.birthDay = birthDay;
    this.ageInYears = this.computeAgeInYears();
  }
}