package test;

import concentration.Concentration;
import course.Course;
import course.CourseBuilder;
import program.Certificate;
import program.Degree;
import program.DegreeTypeSingleton;
import semester.Semester;
import student.Student;
import thesis.Thesis;

public class AdapterPatternTest {

  public static void testCourseAdapter() {
    Concentration concentration = new Concentration("Programming Languages");
    Course course1 = new CourseBuilder()
        .setName("Introduction to Java")
        .setIsElective(true)
        .setSemester(Semester.FALL_2024)
        .setDescription("An introductory course on Java.")
        .setSyllabus("The Syllabus for Introduction to Java")
        .setConcentration(concentration)
        .setEnrollmentLimit(30)
        .build();
    Course course2 = new CourseBuilder()
        .setName("Introduction to Python")
        .setIsElective(false)
        .setSemester(Semester.FALL_2024)
        .setDescription("An introductory course on Python.")
        .setSyllabus("The Syllabus for Introduction to Python")
        .setConcentration(concentration)
        .setEnrollmentLimit(30)
        .build();

    System.out.println("Test case 1: Yuqi Lin is a Degree student, can't enroll elective course on the second year");
    Student yuqi = new Student(
        "Yuqi Lin",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCS()),
        Semester.SPRING_2022
    );
    yuqi.enrollCourse(course1);
    System.out.println();

    System.out.println("Test case 2: Yuqi Lin is a Degree student, can enroll elective course on the last year");
    yuqi = new Student(
        "Yuqi Lin",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCS()),
        Semester.SPRING_2021
    );
    yuqi.enrollCourse(course1);
    System.out.println();

    System.out.println("Test case 3: Yuqi Lin is a Certificate student, can enroll all courses");
     yuqi = new Student(
        "Yuqi Lin",
        new Certificate("Programming Languages I", new Concentration("Programming Languages")),
        Semester.SPRING_2019
    );
    yuqi.enrollCourse(course1);
    System.out.println();

    System.out.println("Test case 4: Yuqi Lin is a Degree student, can enroll non-elective course on the second year");
    yuqi = new Student(
        "Yuqi Lin",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCS()),
        Semester.SPRING_2022
    );
    yuqi.enrollCourse(course2);
    System.out.println();
  }

  public static void testThesisAdapter() {
    Thesis thesis = new Thesis("How to improve garbage collection in Java");

    System.out.println("Test case 1: Yuqi Lin is a Certificate student, can't do thesis");
    Student yuqi = new Student(
        "Yuqi Lin",
        new Certificate("Programming Languages I", new Concentration("Programming Languages")),
        Semester.SPRING_2019
    );
    yuqi.setThesis(thesis, Semester.FALL_2024);
    System.out.println();

    System.out.println("Test case 2: Yuqi Lin is a Degree student, can't do thesis on the second year");
    yuqi = new Student(
        "Yuqi Lin",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCS()),
        Semester.SPRING_2019
    );
    yuqi.setThesis(thesis, Semester.FALL_2020);
    System.out.println();

    System.out.println("Test case 3: Yuqi Lin is a Degree student, can do thesis on the last semester");
    yuqi = new Student(
        "Yuqi Lin",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCS()),
        Semester.SPRING_2019
    );
    yuqi.setThesis(thesis, Semester.FALL_2022);
  }
  public static void main(String[] args) {
    System.out.println("* Testing Adapter Pattern for Student");
    System.out.println("-------------------------------------");

    System.out.println("** Testing Course Validator for Student:");
    testCourseAdapter();

    System.out.println("** Testing Thesis Validator for Student:");
    testThesisAdapter();

    System.out.println("-------------------------------------");
    System.out.println();
  }
}
