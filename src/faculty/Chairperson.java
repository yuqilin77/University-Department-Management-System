package faculty;

import concentration.Concentration;
import course.Course;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import observer.Observer;

public class Chairperson extends Faculty implements Observer {
  private Set<Concentration> concentrations;

  public Chairperson(String name, int courseLimit) {
    super(name, courseLimit);
    this.concentrations = new HashSet<>();
  }

  public void addConcentration(Concentration concentration) {
    this.concentrations.add(concentration);
  }
  public void addConcentrations(List<Concentration> concentrations) {
    this.concentrations.addAll(concentrations);
  }

  public List<Concentration> getConcentrations() {
    return new ArrayList<>(this.concentrations);
  }

  @Override
  public void update(Course course) {
    System.out.println("Chairperson " + this.name + " notified: Course " + course.getName() + " has reached its enrollment limit."
    + " Current waitlist length: " + course.getWaitlist().size());
  }
}