package thesis;

import student.Student;

public class Thesis {
  private Student student;
  private String name;

  public Thesis(String name) {
    this.name = name;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public String getName() {
    return this.name;
  }

  public Student getStudent() {
    return this.student;
  }
}
