package test;

import concentration.Concentration;
import course.Course;
import course.CourseBuilder;
import faculty.Faculty;
import faculty.FacultyFactory;
import faculty.FullTimeFacultyFactory;
import semester.Semester;

public class CompositePatternTest {
  public static void main(String[] args) {
    System.out.println("* Testing Builder Pattern for Concentration");
    System.out.println("-------------------------------------------");
    Concentration concentration = new Concentration("Programming Languages");

    Concentration subConcentration1 = new Concentration("Procedural Languages");
    Concentration subConcentration2 = new Concentration("Object Oriented Languages");
    Concentration subConcentration3 = new Concentration("Functional Languages");

    FacultyFactory factory = new FullTimeFacultyFactory();
    Faculty yuqi = factory.createFaculty(" Yuqi");

    Course course1 = new CourseBuilder()
        .setName("Introduction to Java")
        .setIsElective(false)
        .setSemester(Semester.FALL_2024)
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

    subConcentration2.add(course1);
    subConcentration3.add(course2);

    concentration.add(subConcentration1);
    concentration.add(subConcentration2);
    concentration.add(subConcentration3);

    System.out.println("Concentration:");
    System.out.println(concentration.format());
    System.out.println("-------------------------------------------");
    System.out.println();
  }
}
