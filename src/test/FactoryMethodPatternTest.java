package test;

import faculty.Faculty;
import faculty.FacultyFactory;
import faculty.ChairpersonFactory;
import faculty.FullTimeFacultyFactory;
import faculty.PartTimeFacultyFactory;

public class FactoryMethodPatternTest {

  public static void main(String[] args) {
    System.out.println("* Testing Factory Method Pattern for Faculty");
    System.out.println("-------------------------------------");

    FacultyFactory factory;
    Faculty faculty;

    factory = new ChairpersonFactory();
    faculty = factory.createFaculty("Chairperson Yuqi");
    System.out.println("Creating Chairperson: " + faculty.getName());

    factory = new FullTimeFacultyFactory();
    faculty = factory.createFaculty("Fulltime Faculty Yuqi");
    System.out.println("Creating Full Time Faculty: " + faculty.getName());

    factory = new PartTimeFacultyFactory();
    faculty = factory.createFaculty("Partime Faculty Yuqi");
    System.out.println("Creating Part Time Faculty: " + faculty.getName());
    System.out.println("-------------------------------------");
    System.out.println();
  }
}