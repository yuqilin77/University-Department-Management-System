package command;

import course.Course;
import coursemanager.CourseManager;

public class EnrollCourseCommand implements Command {
  private CourseManager courseManager;
  private Course course;

  public EnrollCourseCommand(CourseManager courseManager, Course course) {
    this.courseManager = courseManager;
    this.course = course;
  }

  @Override
  public void execute() {
    this.courseManager.enrollCourse(this.course);
  }
}
