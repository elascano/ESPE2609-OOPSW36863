/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export class Location {
  public constructor(
    private id: number,
    private description: string
  ) {}

  public getId(): number {
    return this.id;
  }

  public setId(id: number): void {
    this.id = id;
  }

  public getDescription(): string {
    return this.description;
  }

  public setDescription(description: string): void {
    this.description = description;
  }

  public toString(): string {
    return `Location{id=${this.id}, description=${this.description}}`;
  }
}
