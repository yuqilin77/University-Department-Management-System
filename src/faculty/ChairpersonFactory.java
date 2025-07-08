package faculty;

public class ChairpersonFactory implements FacultyFactory {

  public Faculty createFaculty(String name) {
    return new Chairperson(name, 1);
  }
}
