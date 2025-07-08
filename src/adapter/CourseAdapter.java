package adapter;

import student.Student;

public class CourseAdapter implements Validate {
  private CourseValidator validator;

  public CourseAdapter(CourseValidator validator){
   this.validator = validator;
  }

  public boolean validate(Student student) {
    return this.validator.validate(student);
  }
}
