package program;

public class DegreeType {
  private final String name;
  private final int durationOfYears;
  private final int requiredCoreCourseNumber;
  private final int requiredElectiveCourseNumber;

  DegreeType(String name, int durationOfYears, int requiredCoreCourseNumber, int requiredElectiveCourseNumber) {
    this.name = name;
    this.durationOfYears = durationOfYears;
    this.requiredCoreCourseNumber = requiredCoreCourseNumber;
    this.requiredElectiveCourseNumber = requiredElectiveCourseNumber;
  }

  public String getName() {
    return name;
  }

  public int getDurationOfYears() {
    return durationOfYears;
  }

  public int getRequiredCoreCourseNumber() {
    return requiredCoreCourseNumber;
  }

  public int getRequiredElectiveCourseNumber() {
    return requiredElectiveCourseNumber;
  }
}