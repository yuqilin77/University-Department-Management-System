package test;

import concentration.Concentration;
import course.Course;
import course.CourseBuilder;
import department.Department;
import faculty.Faculty;
import faculty.FacultyFactory;
import faculty.FullTimeFacultyFactory;
import java.util.Map;
import java.util.Set;
import program.Certificate;
import program.Degree;
import program.DegreeTypeSingleton;
import semester.Semester;
import student.Student;

public class DepartmentInfoTest {
  public static void main(String[] args) {
    System.out.println("* Testing Department Info");
    System.out.println("----------------------");

    FacultyFactory factory = new FullTimeFacultyFactory();
    Faculty yuqi = factory.createFaculty("Yuqi");

    Course course1 = new CourseBuilder()
        .setName("Introduction to Java")
        .setIsElective(false)
        .setSemester(Semester.FALL_2022)
        .setDescription("An introductory course on Java.")
        .setSyllabus("The Syllabus for Introduction to Java")
        .setFaculty(yuqi)
        .setEnrollmentLimit(30)
        .build();

    Course course2 = new CourseBuilder()
        .setName("Introduction to Erlang")
        .setIsElective(true)
        .setSemester(Semester.SPRING_2024)
        .setDescription("An introductory course on Erlang.")
        .setSyllabus("The Syllabus for Introduction to Erlang")
        .setFaculty(yuqi)
        .setEnrollmentLimit(25)
        .build();

    Student tom = new Student(
        "Tom",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCS()),
        Semester.SPRING_2021
    );
    tom.enrollCourse(course1);
    tom.enrollCourse(course2);

    Student mary = new Student(
        "Mary",
        new Certificate("Programming Languages I", new Concentration("Programming Languages")),
        Semester.SPRING_2019
    );
    mary.enrollCourse(course1);

    Student lily = new Student(
        "Lily",
        new Degree(DegreeTypeSingleton.getMasterOfScienceDA()),
        Semester.SPRING_2023
    );
    lily.enrollCourse(course2);


    Department csDepartment = new Department();
    csDepartment.addCourse(course1);
    csDepartment.addCourse(course2);

    csDepartment.addStudent(tom);
    csDepartment.addStudent(mary);
    csDepartment.addStudent(lily);

    System.out.println();
    System.out.println("Printing courses by semester...");
    Map<Semester, Set<Course>> getCourseBySemester = csDepartment.getCourseBySemester();
    for (Semester semester : getCourseBySemester.keySet()) {
      System.out.println("- " + semester + ":");
      for (Course course : getCourseBySemester.get(semester)) {
        System.out.println("  - " + course.getName());
      }
    }

    System.out.println();
    System.out.println("Printing student enrolled course status...");
    csDepartment.studentEnrolledInCourseInSemester(tom, course1, course1.getSemester());
    csDepartment.studentEnrolledInCourseInSemester(mary, course1, course1.getSemester());
    csDepartment.studentEnrolledInCourseInSemester(lily, course1, course1.getSemester());
    System.out.println();
    csDepartment.studentEnrolledInCourseInSemester(tom, course2, course2.getSemester());
    csDepartment.studentEnrolledInCourseInSemester(mary, course2, course2.getSemester());
    csDepartment.studentEnrolledInCourseInSemester(lily, course2, course2.getSemester());
    System.out.println("----------------------");
    System.out.println();
  }
}
