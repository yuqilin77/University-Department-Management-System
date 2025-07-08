import test.AdapterPatternTest;
import test.CommandPatternTest;
import test.CompositePatternTest;
import test.DepartmentInfoTest;
import test.FactoryMethodPatternTest;
import test.FacultyInfoTest;
import test.ObserverPatternTest;
import test.SingletonPatternTest;
import test.StudentInfoTest;

public class Main {

  public static void main(String[] args) {
    FactoryMethodPatternTest.main(args);
    SingletonPatternTest.main(args);
    CompositePatternTest.main(args);
    AdapterPatternTest.main(args);
    ObserverPatternTest.main(args);
    CommandPatternTest.main(args);
    StudentInfoTest.main(args);
    DepartmentInfoTest.main(args);
    FacultyInfoTest.main(args);
  }
}