package semester;

public enum Semester {
  SPRING_2019,
  FALL_2010,
  SPRING_2020,
  FALL_2020,
  SPRING_2021,
  FALL_2021,
  SPRING_2022,
  FALL_2022,
  SPRING_2023,
  FALL_2023,
  SPRING_2024,
  FALL_2024;

  public int interval(Semester other) {
    return this.ordinal() - other.ordinal();
  }
}
