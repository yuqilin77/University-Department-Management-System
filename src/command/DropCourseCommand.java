package command;

import course.Course;
import coursemanager.CourseManager;

public class DropCourseCommand implements Command {
  private CourseManager courseManager;
  private Course course;

  public DropCourseCommand(CourseManager courseManager, Course course) {
    this.courseManager = courseManager;
    this.course = course;
  }

  @Override
  public void execute() {
    this.courseManager.dropCourse(this.course);
  }
}
