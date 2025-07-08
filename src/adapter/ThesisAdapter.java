package adapter;

import student.Student;

public class ThesisAdapter implements Validate {
  private ThesisValidator validator;

  public ThesisAdapter(ThesisValidator validator){
    this.validator = validator;
  }

  public boolean validate(Student student) {
    return this.validator.validate(student);
  }
}
