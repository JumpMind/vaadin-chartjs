package org.vaadin.addons.chartjs.config;

import elemental.json.Json;
import elemental.json.JsonObject;
import org.vaadin.addons.chartjs.data.Data;
import org.vaadin.addons.chartjs.options.AbstractOptions;
import org.vaadin.addons.chartjs.options.types.RadarChartOptions;
import org.vaadin.addons.chartjs.utils.JUtils;

/**
 * A radar chart is a way of showing multiple data points and the variation between them.
 *
 * <p>They are often useful for comparing the points of two or more different data sets.
 *
 * @author michael@byteowls.com
 */
public class RadarChartConfig implements ChartConfig {

  private static final long serialVersionUID = -6327042538315582431L;

  private Data<RadarChartConfig> data;
  private RadarChartOptions options;

  public Data<RadarChartConfig> data() {
    if (this.data == null) {
      this.data = new Data<>(this);
    }
    return this.data;
  }

  public RadarChartOptions options() {
    if (options == null) {
      options = new RadarChartOptions(this);
    }
    return options;
  }

  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNull(map, "type", "radar");
    // data
    if (data != null) {
      JUtils.putNotNull(map, "data", data.buildJson());
    }
    // options
    if (options != null) {
      JUtils.putNotNull(map, "options", options.buildJson());
    }
    return map;
  }

  @Override
  public AbstractOptions<?> getOptions() {
    return options;
  }
}
