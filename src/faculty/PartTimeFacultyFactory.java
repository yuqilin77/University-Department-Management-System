package faculty;

public class PartTimeFacultyFactory implements FacultyFactory {

  public Faculty createFaculty(String name) {
    return new PartTimeFaculty(name, 1);
  }
}
