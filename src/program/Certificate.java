package program;

import concentration.Concentration;

public class Certificate extends Program {
  private Concentration concentration;
  private final int requiredCourseNumber = 4;

  public Certificate(String name, Concentration concentration) {
    super(name);
    this.concentration = concentration;
  }

  public Concentration getConcentration() {
    return this.concentration;
  }

  public int getRequiredCourseNumber() {
    return this.requiredCourseNumber;
  }
}