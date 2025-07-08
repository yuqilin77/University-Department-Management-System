package grade;

public enum Grade {
  A(4),
  B(3),
  C(2),
  D(1),
  F(0);

  private final int points;

  Grade(int points) {
    this.points = points;
  }

  public int getPoints() {
    return points;
  }
}