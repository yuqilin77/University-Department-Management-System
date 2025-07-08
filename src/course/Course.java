package course;

import concentration.Concentration;
import concentrationcomponent.ConcentrationComponent;
import faculty.Chairperson;
import faculty.Faculty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import observer.Observer;
import observer.Subject;
import semester.Semester;
import student.Student;

public class Course extends ConcentrationComponent implements Subject {
  private final String name;
  private final Semester semester;
  private String description;
  private String syllabus;
  private Concentration concentration;
  private final boolean isElective;
  private final Faculty faculty;
  private final int enrollmentLimit;
  private Set<Student> enrolledStudents;
  private List<Student> waitlist;
  private List<Observer> observers;

  Course(CourseBuilder builder) {
    this.name = builder.name;
    this.isElective = builder.isElective;
    this.semester = builder.semester;
    this.description = builder.description;
    this.syllabus = builder.syllabus;
    this.concentration = builder.concentration;
    this.faculty = builder.faculty;
    this.enrollmentLimit = builder.enrollmentLimit;
    this.enrolledStudents= new HashSet<>();
    this.waitlist = new ArrayList<>();
    this.observers = new ArrayList<>();
  }

  @Override
  public String format() {
    StringBuilder html = new StringBuilder();
    html.append("<div class='course'>")
        .append("<h4>").append(name).append("</h4>")
        .append("<p><strong>Description:</strong> ").append(description).append("</p>")
        .append("<p><strong>Syllabus:</strong> ").append(syllabus).append("</p>")
        .append("<p><strong>semester.Semester:</strong> ").append(semester).append("</p>")
        .append("<p><strong>Elective:</strong> ").append(isElective ? "Yes" : "No").append("</p>")
        .append("<p><strong>Enrollment Limit:</strong> ").append(enrollmentLimit).append("</p>")
        .append("<p><strong>Faculty:</strong> ").append(faculty.getName()).append("</p>")
        .append("<p><strong>Enrolled Students:</strong> ").append(enrolledStudents.size()).append("</p>")
        .append("</div>");
    return html.toString();
  }

  @Override
  public String getName() {
    return this.name;
  }

  public Semester getSemester() {
    return this.semester;
  }

  public String getDescription() {
    return this.description;
  }

  public String getSyllabus() {
    return this.syllabus;
  }

  public Concentration getConcentration() {
    return this.concentration;
  }

  public Faculty getFaculty() {
    return this.faculty;
  }

  public int getEnrollmentLimit() {
    return this.enrollmentLimit;
  }

  public List<Student> getEnrolledStudents() {
    return new ArrayList<>(this.enrolledStudents);
  }

  public List<Student> getWaitlist() {
    return new ArrayList<>(this.waitlist);
  }

  public boolean isElective() {
    return this.isElective;
  }

  public boolean enrollStudent(Student student) {
    boolean enrolled = false;
    if (this.enrolledStudents.size() < this.enrollmentLimit) {
      this.enrolledStudents.add(student);
      enrolled = true;
    } else {
      this.waitlist.add(student);
    }
    if (this.enrolledStudents.size() == this.enrollmentLimit) {
      notifyObservers(Chairperson.class);
    }
    return enrolled;
  }

  public void dropStudent(Student student) {
    this.enrolledStudents.remove(student);
    if (!this.waitlist.isEmpty()) {
      Student nextStudent = this.waitlist.remove(0);
      this.enrolledStudents.add(nextStudent);
      addObserver(nextStudent);
      notifyObservers(Student.class);
      removeObserver(nextStudent);
    }
  }

  @Override
  public void addObserver(Observer observer) {
    this.observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers(Class<?> observerClass) {
    for (Observer observer : observers) {
      observer.update(this);
    }
  }

  @Override
  public void add(ConcentrationComponent component) {
    throw new UnsupportedOperationException("Cannot add component to a course");
  }

  @Override
  public void remove(ConcentrationComponent component) {
    throw new UnsupportedOperationException("Cannot remove component from a course");
  }

  @Override
  public List<ConcentrationComponent> getSubcomponents() {
    throw new UnsupportedOperationException("A course does not have subcomponents");
  }
}
