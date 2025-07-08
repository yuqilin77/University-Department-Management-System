package student;

import adapter.CourseAdapter;
import adapter.CourseValidator;
import adapter.ThesisAdapter;
import adapter.ThesisValidator;
import adapter.Validate;
import course.Course;
import coursemanager.CourseManager;
import faculty.FullTimeFaculty;
import grade.Grade;
import java.util.HashMap;
import java.util.Map;
import observer.Observer;
import program.Program;
import semester.Semester;
import thesis.Thesis;

public class Student implements Observer, CourseManager {
  private final String name;
  private final Program program;
  private Map<Semester, Map<Course, Grade>> coursesTakenBySemester;
  private Thesis thesis;
  private FullTimeFaculty thesisAdvisor;
  private final Semester startingSemester;

  public Student(String name, Program program, Semester startingSemester) {
    this.name = name;
    this.program = program;
    this.startingSemester = startingSemester;
    this.coursesTakenBySemester = new HashMap<>();
  }

  public String getName() {
    return this.name;
  }

  public Program getProgram() {
    return this.program;
  }

  public Map<Semester, Map<Course, Grade>> getCoursesTakenBySemester() {
    return this.coursesTakenBySemester;
  }

  public Thesis getThesis() {
    return this.thesis;
  }

  public FullTimeFaculty getThesisAdvisor() {
    return this.thesisAdvisor;
  }

  public Semester getStartingSemester() {
    return this.startingSemester;
  }

  public void setThesis(Thesis thesis, Semester semester) {
    Validate thesisValidator = new ThesisAdapter(new ThesisValidator(thesis, semester));
    if (thesisValidator.validate(this)) {
      thesis.setStudent(this);
      this.thesis = thesis;
      System.out.println(this.name + " set the thesis \"" + thesis.getName() + "\" successfully!");
    } else {
      System.out.println(this.name + " can't do additional thesis in semester " + semester);
    }
  }

  public void setThesisAdvisor(FullTimeFaculty thesisAdvisor, Semester semester) {
    if (this.thesis != null) {
      thesisAdvisor.setThesisAdvisorForStudent(semester, this);
      this.thesisAdvisor = thesisAdvisor;
      System.out.println(this.name + " set the thesis advisor " + thesisAdvisor.getName() + " for the thesis \"" + thesis.getName() + "\" successfully!");
    } else {
      System.out.println(this.name + " has not chosen the thesis yet");
    }
  }

  public double gpa() {
    double totalPoints = 0.0;
    int totalCourses = 0;

    for (Map<Course, Grade> courses : coursesTakenBySemester.values()) {
      for (Grade grade : courses.values()) {
        totalPoints += grade.getPoints();
        totalCourses++;
      }
    }

    if (totalCourses == 0) {
      return 0.0;
    }

    return totalPoints / totalCourses;
  }

  public boolean enrollCourse(Course course) {
    Validate courseValidator = new CourseAdapter(new CourseValidator(course));
    if (courseValidator.validate(this)) {
      if (course.enrollStudent(this)) {
        Map<Course, Grade> courses = this.coursesTakenBySemester.getOrDefault(course.getSemester(),
            new HashMap<>());
        courses.put(course, null);
        this.coursesTakenBySemester.put(course.getSemester(), courses);
        System.out.println(this.name + " enrolled course \"" + course.getName() + "\" in semester "  + course.getSemester());
        return true;
      }
      System.out.println(this.name + " is added to the waitlist for course \"" + course.getName() + "\"");
      return false;
    }
    System.out.println(this.name + " can't enroll course \"" + course.getName() + "\"");
    return false;
  }

  public void dropCourse(Course course) {
    course.dropStudent(this);
    Map<Course, Grade> courses = this.coursesTakenBySemester.getOrDefault(course.getSemester(), new HashMap<>());
    courses.remove(course);
    this.coursesTakenBySemester.put(course.getSemester(), courses);
    System.out.println(this.name + " drop course \"" + course.getName() + "\" successfully!");
  }

  public void setCourseGrade(Course course, Grade grade) {
    Map<Course, Grade> courses = coursesTakenBySemester.getOrDefault(course.getSemester(), new HashMap<>());
    if (!courses.containsKey(course) || courses.get(course) != null) {
      return;
    }
    courses.put(course, grade);
    coursesTakenBySemester.put(course.getSemester(), courses);
    System.out.println(this.name + " got grade " + grade.name() + " in course \"" + course.getName() + "\"");
  }

  @Override
  public void update(Course course) {
    System.out.println(this.name + " notified: You have been enrolled in the course \"" + course.getName() + "\" successfully!");
  }
}