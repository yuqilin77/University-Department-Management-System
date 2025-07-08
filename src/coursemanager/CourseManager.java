package coursemanager;

import course.Course;

public interface CourseManager {
  boolean enrollCourse(Course course);

  void dropCourse(Course course);
}
