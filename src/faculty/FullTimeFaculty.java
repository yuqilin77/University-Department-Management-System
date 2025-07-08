package faculty;

import concentration.Concentration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import semester.Semester;
import student.Student;

public class FullTimeFaculty extends Faculty {
  private Set<Semester> graduateAdvisorSemesters;
  private Set<Semester> undergraduateAdvisorSemesters;
  private Map<Semester, Set<Student>> thesisAdvisorStudentsBySemester;

  private Set<Concentration> concentrations;

  public FullTimeFaculty(String name, int courseLimit) {
    super(name, courseLimit);
    this.graduateAdvisorSemesters = new HashSet<>();
    this.undergraduateAdvisorSemesters = new HashSet<>();
    this.thesisAdvisorStudentsBySemester = new HashMap<>();
  }

  public List<Semester> getGraduateAdvisorSemesters() {
    return new ArrayList<>(this.graduateAdvisorSemesters);
  }

  public List<Semester> getUndergraduateAdvisorSemesters() {
    return new ArrayList<>(this.undergraduateAdvisorSemesters);
  }

  public List<Student> getThesisAdvisorStudentsBySemester(Semester semester) {
    return new ArrayList<>(this.thesisAdvisorStudentsBySemester.getOrDefault(semester, new HashSet<>()));
  }

  public List<Concentration> getConcentrations() {
    return new ArrayList<>(this.concentrations);
  }

  public void setGraduateAdvisorInSemester(Semester semester) {
    this.graduateAdvisorSemesters.add(semester);
  }

  public void setUndergraduateAdvisorInSemester(Semester semester) {
    this.undergraduateAdvisorSemesters.add(semester);
  }

  public void setConcentration(Concentration concentration) {
    this.concentrations.add(concentration);
  }

  public void setConcentrations(List<Concentration> concentrations) {
    this.concentrations.addAll(concentrations);
  }

  public void setThesisAdvisorForStudent(Semester semester, Student student) {
    Set<Student> students = this.thesisAdvisorStudentsBySemester.getOrDefault(semester, new HashSet<>());
    students.add(student);
    this.thesisAdvisorStudentsBySemester.put(semester, students);
  }
}
