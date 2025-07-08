package department;

import concentration.Concentration;
import course.Course;
import faculty.Chairperson;
import faculty.Faculty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import program.Program;
import semester.Semester;
import student.Student;

public class Department {
  private Chairperson chairperson;
  private Set<Faculty> faculties = new HashSet<>();
  private Set<Program> programs = new HashSet<>();
  private Set<Concentration> topLevelConcentration = new HashSet<>();
  private Map<Semester, Set<Course>> courseBySemester = new HashMap<>();
  private Map<Semester, Set<Student>> studentBySemester = new HashMap<>();

  public void addFaculty(Faculty faculty) {
    this.faculties.add(faculty);
  }

  public void addFaculties(List<Faculty> faculties) {
    this.faculties.addAll(faculties);
  }

  public void addProgram(Program program) {
    this.programs.add(program);
  }

  public void addPrograms(List<Program> programs) {
    this.programs.addAll(programs);
  }

  public void addConcentration(Concentration concentration) {
    this.topLevelConcentration.add(concentration);
  }

  public void addConcentrations(List<Concentration> concentrations) {
    this.topLevelConcentration.addAll(concentrations);
  }

  public void addCourse(Course course) {
    Set<Course> courses = this.courseBySemester.getOrDefault(course.getSemester(), new HashSet<>());
    courses.add(course);
    this.courseBySemester.put(course.getSemester(), courses);
    course.getFaculty().addCourse(course);
    if (this.chairperson != null) {
      course.addObserver(this.chairperson);
    }
  }

  public void addStudent(Student student) {
    Set<Student> students = this.studentBySemester.getOrDefault(student.getStartingSemester(), new HashSet<>());
    students.add(student);
    this.studentBySemester.put(student.getStartingSemester(), students);
  }

  public void setChairperson(Chairperson chairperson) {
    this.chairperson = chairperson;
    for (Set<Course> courses : this.courseBySemester.values()) {
      for (Course course : courses) {
        course.addObserver(chairperson);
      }
    }
  }

  public Chairperson getChairperson() {
    return this.chairperson;
  }

  public List<Faculty> getFaculties() {
    return new ArrayList<>(this.faculties);
  }

  public List<Program> getPrograms() {
    return new ArrayList<>(this.programs);
  }

  public List<Concentration> getTopLevelConcentration() {
    return new ArrayList<>(this.topLevelConcentration);
  }

  public Map<Semester, Set<Course>> getCourseBySemester() {
    return this.courseBySemester;
  }

  public Map<Semester, Set<Student>> getStudentBySemester() {
    return this.studentBySemester;
  }

  public boolean studentEnrolledInCourseInSemester(Student student, Course course, Semester semester) {
    boolean enrolled = (semester == course.getSemester()) && course.getEnrolledStudents().contains(student);
    System.out.println("student " + student.getName() + (enrolled ? " enrolled " : " did not enroll ") + "course \"" + course.getName() + "\" in semester " + semester);
    return enrolled;
  }
}
