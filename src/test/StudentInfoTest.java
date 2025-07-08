package test;

import course.Course;
import course.CourseBuilder;
import faculty.Faculty;
import faculty.FacultyFactory;
import faculty.FullTimeFaculty;
import faculty.FullTimeFacultyFactory;
import grade.Grade;
import java.util.Map;
import program.Degree;
import program.DegreeTypeSingleton;
import semester.Semester;
import student.Student;
import thesis.Thesis;

public class StudentInfoTest {
  public static void main(String[] args) {
    System.out.println("* Testing Student Info");
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

    Thesis thesis = new Thesis("How to improve garbage collection in Java");
    tom.setThesis(thesis, Semester.FALL_2024);
    tom.setThesisAdvisor((FullTimeFaculty) yuqi, Semester.FALL_2024);

    tom.setCourseGrade(course1, Grade.A);
    tom.setCourseGrade(course2, Grade.B);

    System.out.println();
    System.out.println("Printing student information...");
    System.out.println("Student: " + tom.getName());
    System.out.println("Program: " + tom.getProgram().getName());

    Map<Semester, Map<Course, Grade>> coursesTakenBySemester = tom.getCoursesTakenBySemester();
    System.out.println("Courses taken by semester:");
    for (Semester semester : coursesTakenBySemester.keySet()) {
      System.out.println("- " + semester + ":");
      for (Course course : coursesTakenBySemester.get(semester).keySet()) {
        System.out.println("  - " + course.getName());
      }
    }
    System.out.println("GPA:");
    System.out.println(tom.gpa());
    if (tom.getThesis() != null) {
      System.out.println("Thesis: " + tom.getThesis().getName());
      if (tom.getThesisAdvisor() != null) {
        System.out.println("Thesis Advisor: " + tom.getThesisAdvisor().getName());
      }
    } else {
      System.out.println("No thesis set.");
    }
    System.out.println("----------------------");
    System.out.println();
  }
}
