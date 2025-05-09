package org.vaadin.addons.chartjs.config;

import elemental.json.Json;
import elemental.json.JsonObject;
import org.vaadin.addons.chartjs.data.Data;
import org.vaadin.addons.chartjs.options.AbstractOptions;
import org.vaadin.addons.chartjs.options.types.PolarAreaChartOptions;
import org.vaadin.addons.chartjs.utils.JUtils;

/**
 * Polar area charts are similar to pie charts, but each segment has the same angle - the radius of
 * the segment differs depending on the value.
 *
 * <p>This type of chart is often useful when we want to show a comparison data similar to a pie
 * chart, but also show a scale of values for context.
 *
 * @author michael@byteowls.com
 */
public class PolarAreaChartConfig implements ChartConfig {

  private static final long serialVersionUID = -850318331296132418L;

  private Data<PolarAreaChartConfig> data;
  private PolarAreaChartOptions options;

  public Data<PolarAreaChartConfig> data() {
    if (this.data == null) {
      this.data = new Data<>(this);
    }
    return this.data;
  }

  public PolarAreaChartOptions options() {
    if (options == null) {
      options = new PolarAreaChartOptions(this);
    }
    return options;
  }

  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNull(map, "type", "polarArea");
    if (data != null) {
      JUtils.putNotNull(map, "data", data.buildJson());
    }
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
