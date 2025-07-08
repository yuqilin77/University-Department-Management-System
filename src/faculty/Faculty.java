package faculty;

import course.Course;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import semester.Semester;

public abstract class Faculty {
  protected final String name;
  protected final int courseLimit;
  protected Map<Semester, Set<Course>> coursesBySemester;

  public Faculty(String name, int courseLimit) {
    this.name = name;
    this.courseLimit = courseLimit;
    this.coursesBySemester = new HashMap<>();
  }

  public String getName() {
    return this.name;
  }

  public boolean addCourse(Course course) {
    Set<Course> courses = this.coursesBySemester.getOrDefault(course.getSemester(), new HashSet<>());
    if (courses.size() >= this.courseLimit) {
      return false;
    }
    courses.add(course);
    this.coursesBySemester.put(course.getSemester(), courses);
    return true;
  };

  public List<Course> getCoursesBySemester(Semester semester) {
    return new ArrayList<>(this.coursesBySemester.getOrDefault(semester, new HashSet<>()));
  }
}
