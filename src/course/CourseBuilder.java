package course;

import concentration.Concentration;
import faculty.Faculty;
import semester.Semester;

public class CourseBuilder {
  public String name;
  public Semester semester;
  public String description;
  public String syllabus;
  public Concentration concentration;
  public Faculty faculty;
  public int enrollmentLimit;
  public boolean isElective;

  public CourseBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CourseBuilder setIsElective(boolean isElective) {
    this.isElective = isElective;
    return this;
  }
  public CourseBuilder setSemester(Semester semester) {
    this.semester = semester;
    return this;
  }

  public CourseBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CourseBuilder setSyllabus(String syllabus) {
    this.syllabus = syllabus;
    return this;
  }

  public CourseBuilder setConcentration(Concentration concentration) {
    this.concentration = concentration;
    return this;
  }

  public CourseBuilder setFaculty(Faculty faculty) {
    this.faculty = faculty;
    return this;
  }

  public CourseBuilder setEnrollmentLimit(int enrollmentLimit) {
    this.enrollmentLimit = enrollmentLimit;
    return this;
  }

  public Course build() {
    return new Course(this);
  }
}
