package program;

public class DegreeTypeSingleton {
  private static final DegreeType BACHELOR_OF_SCIENCE_CS = new DegreeType("4 year Bachelor of Science (B.S.) in CS", 4, 8, 4);
  private static final DegreeType BACHELOR_OF_SCIENCE_CIS = new DegreeType("4 year Bachelor of Science (B.S.) in CIS", 4, 8, 4);
  private static final DegreeType MASTER_OF_SCIENCE_CS = new DegreeType("2 year Master of Science (M.S.) in CS", 2, 4, 2);
  private static final DegreeType MASTER_OF_SCIENCE_CIS = new DegreeType("2 year Master of Science (M.S.) in CIS", 2, 4, 2);
  private static final DegreeType MASTER_OF_SCIENCE_DA = new DegreeType("2 year Master of Science (M.S.) in DA", 2, 4, 2);

  public static DegreeType getBachelorOfScienceCS() {
    return BACHELOR_OF_SCIENCE_CS;
  }

  public static DegreeType getBachelorOfScienceCIS() {
    return BACHELOR_OF_SCIENCE_CIS;
  }

  public static DegreeType getMasterOfScienceCS() {
    return MASTER_OF_SCIENCE_CS;
  }

  public static DegreeType getMasterOfScienceCIS() {
    return MASTER_OF_SCIENCE_CIS;
  }

  public static DegreeType getMasterOfScienceDA() {
    return MASTER_OF_SCIENCE_DA;
  }
}
