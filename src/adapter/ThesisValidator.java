package adapter;

import program.Degree;
import semester.Semester;
import student.Student;
import thesis.Thesis;

public class ThesisValidator {
  Thesis thesis;
  Semester semester;

  public ThesisValidator(Thesis thesis, Semester semester){
    this.thesis = thesis;
    this.semester = semester;
  }

  public boolean validate(Student student) {
    if (!(student.getProgram() instanceof Degree)) {
      return false;
    }
    Degree degree = (Degree) student.getProgram();
    return this.semester.interval(student.getStartingSemester()) == degree.getDurationOfYears() * 2 - 1;
  }
}
