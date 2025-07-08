package program;

public class Degree extends Program {
  private final int durationOfYears;
  private final int requiredCoreCourseNumber;
  private final int requiredElectiveCourseNumber;
  public Degree(DegreeType degreeType) {
    super(degreeType.getName());
    this.durationOfYears = degreeType.getDurationOfYears();
    this.requiredCoreCourseNumber = degreeType.getRequiredCoreCourseNumber();
    this.requiredElectiveCourseNumber = degreeType.getRequiredElectiveCourseNumber();
  }

  public int getDurationOfYears() {
    return this.durationOfYears;
  }

  public int getRequiredCoreCourseNumber() {
    return this.requiredCoreCourseNumber;
  }

  public int getRequiredElectiveCourseNumber() {
    return this.requiredElectiveCourseNumber;
  }
}