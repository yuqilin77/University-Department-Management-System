package test;

import concentration.Concentration;
import course.Course;
import course.CourseBuilder;
import department.Department;
import faculty.Chairperson;
import faculty.ChairpersonFactory;
import faculty.Faculty;
import faculty.FacultyFactory;
import program.Degree;
import program.DegreeTypeSingleton;
import semester.Semester;
import student.Student;

public class ObserverPatternTest {
  public static void main(String[] args) {
    System.out.println("* Testing Observer Pattern for enrolling and dropping Course");
    System.out.println("------------------------------------------------------------");

    FacultyFactory factory = new ChairpersonFactory();
    Faculty yuqi = factory.createFaculty("Yuqi");
    Concentration concentration = new Concentration("Programming Languages");
    Course course = new CourseBuilder()
        .setName("Introduction to Python")
        .setIsElective(false)
        .setSemester(Semester.FALL_2022)
        .setDescription("An introductory course on Python.")
        .setSyllabus("The Syllabus for Introduction to Python")
        .setConcentration(concentration)
        .setFaculty(yuqi)
        .setEnrollmentLimit(2)
        .build();

    Student tom = new Student(
        "Tom",
        new Degree(DegreeTypeSingleton.getMasterOfScienceCIS()),
        Semester.SPRING_2021
    );
    Student mary = new Student(
        "Mary",
        new Degree(DegreeTypeSingleton.getMasterOfScienceDA()),
        Semester.SPRING_2022
    );
    Student lily = new Student(
        "Lily",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCIS()),
        Semester.FALL_2021
    );
    Student peter = new Student(
        "Peter",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCIS()),
        Semester.FALL_2021
    );

    Department csDepartment = new Department();
    csDepartment.setChairperson((Chairperson) yuqi);
    csDepartment.addCourse(course);

    tom.enrollCourse(course);
    System.out.println();
    mary.enrollCourse(course);
    System.out.println();
    lily.enrollCourse(course);
    System.out.println();
    peter.enrollCourse(course);
    System.out.println();
    tom.dropCourse(course);
    System.out.println();
    mary.dropCourse(course);

    System.out.println("------------------------------------------------------------");
    System.out.println();
  }
}
