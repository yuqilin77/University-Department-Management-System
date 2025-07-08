package concentrationcomponent;

import java.util.List;

public abstract class ConcentrationComponent {
  public abstract String getName();
  public abstract void add(ConcentrationComponent component);
  public abstract void remove(ConcentrationComponent component);
  public abstract List<ConcentrationComponent> getSubcomponents();
  public abstract String format();
}
