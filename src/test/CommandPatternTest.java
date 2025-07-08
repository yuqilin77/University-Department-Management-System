package test;

import command.Command;
import command.DropCourseCommand;
import command.EnrollCourseCommand;
import concentration.Concentration;
import course.Course;
import course.CourseBuilder;
import faculty.Faculty;
import faculty.PartTimeFacultyFactory;
import program.Certificate;
import program.Degree;
import program.DegreeTypeSingleton;
import remotecontrol.RemoteControl;
import semester.Semester;
import student.Student;

public class CommandPatternTest {
  public static void main(String[] args) {
    System.out.println("* Testing Command Pattern for for enrolling and dropping Course");
    System.out.println("---------------------------------------------------------------");

    PartTimeFacultyFactory factory = new PartTimeFacultyFactory();
    Faculty yuqi = factory.createFaculty("Yuqi");
    Concentration concentration = new Concentration("Programming Languages");
    Course course = new CourseBuilder()
        .setName("Introduction to Java")
        .setIsElective(true)
        .setSemester(Semester.FALL_2022)
        .setDescription("An introductory course on Java.")
        .setSyllabus("The Syllabus for Introduction to Java")
        .setConcentration(concentration)
        .setFaculty(yuqi)
        .setEnrollmentLimit(5)
        .build();

    System.out.println("Test case 1: Tom is a Degree student, can't enroll elective course on the second year");
    Student tom = new Student(
        "Tom",
        new Degree(DegreeTypeSingleton.getMasterOfScienceCS()),
        Semester.SPRING_2021
    );

    Command enrollCourseCommand = new EnrollCourseCommand(tom, course);
    RemoteControl remote = new RemoteControl();

    remote.setCommand(enrollCourseCommand);
    remote.execute();
    System.out.println();

    System.out.println("Test case 2: Mary is a Certificate student, can enroll all courses");
    Student mary = new Student(
        "Mary",
        new Certificate("Programming Languages I", new Concentration("Programming Languages")),
        Semester.SPRING_2019
    );
    enrollCourseCommand = new EnrollCourseCommand(mary, course);
    Command dropCourseCommand = new DropCourseCommand(mary, course);
    remote.setCommand(enrollCourseCommand);
    remote.execute();

    remote.setCommand(dropCourseCommand);
    remote.execute();

    System.out.println("---------------------------------------------------------------");
    System.out.println();
  }
}
