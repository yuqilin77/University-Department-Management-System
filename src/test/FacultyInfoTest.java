package test;

import course.Course;
import course.CourseBuilder;
import department.Department;
import faculty.Faculty;
import faculty.FacultyFactory;
import faculty.FullTimeFaculty;
import faculty.FullTimeFacultyFactory;
import java.util.Arrays;
import program.Degree;
import program.DegreeTypeSingleton;
import semester.Semester;
import student.Student;
import thesis.Thesis;
import java.util.List;

public class FacultyInfoTest {
  public static void main(String[] args) {

    System.out.println("* Testing Faculty Info");
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

    Department csDepartment = new Department();
    csDepartment.addCourse(course1);
    csDepartment.addCourse(course2);

    Student tom = new Student(
        "Tom",
        new Degree(DegreeTypeSingleton.getBachelorOfScienceCS()),
        Semester.SPRING_2021
    );
    Thesis thesis1 = new Thesis("How to improve garbage collection in Java");
    tom.setThesis(thesis1, Semester.FALL_2024);
    tom.setThesisAdvisor((FullTimeFaculty) yuqi, Semester.FALL_2024);

    Student mary = new Student(
        "Mary",
        new Degree(DegreeTypeSingleton.getMasterOfScienceDA()),
        Semester.SPRING_2022
    );
    Thesis thesis2 = new Thesis("How to improve garbage collection in Erlang");
    mary.setThesis(thesis2, Semester.FALL_2023);
    mary.setThesisAdvisor((FullTimeFaculty) yuqi, Semester.FALL_2023);

    System.out.println();
    System.out.println("Faculty: " + yuqi.getName());
    System.out.println("Faculty Type: " + yuqi.getClass().getName());
    System.out.println();

    List<Semester> semesters =  Arrays.asList(Semester.FALL_2022, Semester.FALL_2023, Semester.SPRING_2024);
    for (Semester semester: semesters) {
      System.out.println("Semester: " + semester);
      List<Course> courses = yuqi.getCoursesBySemester(semester);
      System.out.println("Courses teaching: ");
      for (Course course : courses) {
        System.out.println("- " + course.getName());
      }
      System.out.println("Student advising: ");
      List<Student> students = ((FullTimeFaculty) yuqi).getThesisAdvisorStudentsBySemester(semester);
      for (Student student : students) {
        System.out.println("- " + student.getName());
      }
      System.out.println();
    }
    System.out.println("----------------------");
    System.out.println();
  }
}
