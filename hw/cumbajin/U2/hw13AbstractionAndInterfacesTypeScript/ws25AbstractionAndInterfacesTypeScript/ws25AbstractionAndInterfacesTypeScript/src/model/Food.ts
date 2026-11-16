/**
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export class Food {
  public constructor(private description: string) {}

  public getDescription(): string {
    return this.description;
  }

  public setDescription(description: string): void {
    this.description = description;
  }

  public toString(): string {
    return this.description;
  }
}
