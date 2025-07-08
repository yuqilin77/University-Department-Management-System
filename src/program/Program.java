package program;

public abstract class Program {
  protected final String name;

  protected Program(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
