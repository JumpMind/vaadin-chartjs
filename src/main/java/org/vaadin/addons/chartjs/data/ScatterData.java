package org.vaadin.addons.chartjs.data;

import elemental.json.Json;
import elemental.json.JsonObject;
import java.io.Serializable;
import org.vaadin.addons.chartjs.utils.JUtils;
import org.vaadin.addons.chartjs.utils.JsonBuilder;

/**
 * Data for the scatter line chart is passed in the form of an object.
 *
 * @author michael@byteowls.com
 */
public class ScatterData implements JsonBuilder, Serializable {

  private static final long serialVersionUID = 680613867864908619L;

  private Double x;
  private Double y;

  /** X Value */
  public ScatterData x(Double x) {
    this.x = x;
    return this;
  }

  /** Y Value */
  public ScatterData y(Double y) {
    this.y = y;
    return this;
  }

  @Override
  public JsonObject buildJson() {
    JsonObject obj = Json.createObject();
    JUtils.putNotNull(obj, "x", x);
    JUtils.putNotNull(obj, "y", y);
    return obj;
  }

  @Override
  public String toString() {
    return "[x=" + x + ", y=" + y + "]";
  }
}
