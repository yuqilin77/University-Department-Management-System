package faculty;

public class FullTimeFacultyFactory implements FacultyFactory {

  public Faculty createFaculty(String name) {
    return new FullTimeFaculty(name, 3);
  }
}
