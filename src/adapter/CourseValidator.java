package adapter;

import course.Course;
import program.Degree;
import student.Student;

public class CourseValidator {
  Course course;
  public CourseValidator(Course course){
    this.course = course;
  }

  public boolean validate(Student student) {
    if (!(student.getProgram() instanceof Degree)) {
      return true;
    }

    Degree degree = (Degree) student.getProgram();
    int interval = this.course.getSemester().interval(student.getStartingSemester());
    if (interval < 0 || interval >= degree.getDurationOfYears() * 2) {
      return false;
    }
    if (this.course.isElective()) {
      return interval >= (degree.getDurationOfYears() - 1) * 2;
    }
    return true;
  }
}
