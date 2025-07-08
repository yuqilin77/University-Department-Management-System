package concentration;

import concentrationcomponent.ConcentrationComponent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concentration extends ConcentrationComponent {
  private String name;
  private Set<ConcentrationComponent> subComponents;

  public Concentration(String name) {
    this.name = name;
    this.subComponents = new HashSet<>();
  }

  @Override
  public String getName() {
    return this.name;
  }
  @Override
  public void add(ConcentrationComponent component) {
    this.subComponents.add(component);
  }

  @Override
  public void remove(ConcentrationComponent component) {
    this.subComponents.remove(component);
  }

  @Override
  public List<ConcentrationComponent> getSubcomponents() {
    return new ArrayList<>(this.subComponents);
  }

  @Override
  public String format() {
    StringBuilder html = new StringBuilder();
    html.append("<div class='concentration'>")
        .append("<h2>").append(name).append("</h2>");

    if (!subComponents.isEmpty()) {
      html.append("<div class='components'>");
      for (ConcentrationComponent component : subComponents) {
        html.append(component.format());  // Recursively format subcomponents
      }
      html.append("</div>");
    }

    html.append("</div>");
    return html.toString();
  }
}
