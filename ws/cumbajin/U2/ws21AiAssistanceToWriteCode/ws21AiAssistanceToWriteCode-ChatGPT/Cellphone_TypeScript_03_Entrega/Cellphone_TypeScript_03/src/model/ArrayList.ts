/**
 * TypeScript has no built-in java.util.ArrayList.
 * This generic class implements a dynamic ArrayList using Array<T>.
 */
export class ArrayList<T> {
  private readonly elements: T[] = [];

  public add(item: T): void {
    this.elements.push(item);
  }

  public size(): number {
    return this.elements.length;
  }

  public isEmpty(): boolean {
    return this.elements.length === 0;
  }

  public some(predicate: (item: T) => boolean): boolean {
    return this.elements.some(predicate);
  }

  public toArray(): T[] {
    return [...this.elements];
  }
}
