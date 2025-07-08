package test;

import program.DegreeType;
import program.DegreeTypeSingleton;

public class SingletonPatternTest {
  public static void main(String[] args) {
    System.out.println("* Testing Singleton Pattern for DegreeType");
    System.out.println("------------------------------------------");

    DegreeType instance1 = DegreeTypeSingleton.getBachelorOfScienceCS();
    System.out.println("Calling DegreeTypeSingleton.getBachelorOfScienceCS() to create DegreeType: " + instance1.getName());

    DegreeType instance2 = DegreeTypeSingleton.getBachelorOfScienceCS();
    System.out.println("Calling DegreeTypeSingleton.getBachelorOfScienceCS() to create DegreeType: " + instance2.getName());

    System.out.println("Those two degreeTypes are the same: " + (instance1 == instance2));
    System.out.println("------------------------------------------");
    System.out.println();
  }
}
