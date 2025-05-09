package org.vaadin.addons.chartjs.options;

import elemental.json.Json;
import elemental.json.JsonObject;
import java.io.Serializable;
import org.vaadin.addons.chartjs.utils.And;
import org.vaadin.addons.chartjs.utils.JUtils;
import org.vaadin.addons.chartjs.utils.JsonBuilder;

public class LegendLabel<T> extends And<Legend<T>> implements JsonBuilder, Serializable {

  private static final long serialVersionUID = -7792493411933479339L;

  private Integer boxWidth;
  private Integer fontSize;
  private String fontStyle;
  private String fontColor;
  private String fontFamily;
  private Integer padding;
  // TODO callback generateLabels
  private Boolean usePointStyle;

  /** Width of coloured box. Default: 40 */
  public LegendLabel<T> boxWidth(int boxWidth) {
    this.boxWidth = boxWidth;
    return this;
  }

  /** Font size. Default: 12 */
  public LegendLabel<T> fontSize(int fontSize) {
    this.fontSize = fontSize;
    return this;
  }

  /** Font style. Default: normal */
  public LegendLabel<T> fontStyle(String fontStyle) {
    this.fontStyle = fontStyle;
    return this;
  }

  /** Font color. Default: #666 */
  public LegendLabel<T> fontColor(String fontColor) {
    this.fontColor = fontColor;
    return this;
  }

  /** Font family. Default: 'Helvetica Neue', 'Helvetica', 'Arial', sans-serif */
  public LegendLabel<T> fontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
    return this;
  }

  /** Padding between rows of colored boxes. Default: 10 */
  public LegendLabel<T> padding(int padding) {
    this.padding = padding;
    return this;
  }

  public LegendLabel(Legend<T> parent) {
    super(parent);
  }

  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNull(map, "boxWidth", boxWidth);
    JUtils.putNotNull(map, "fontSize", fontSize);
    JUtils.putNotNull(map, "fontStyle", fontStyle);
    JUtils.putNotNull(map, "fontColor", fontColor);
    JUtils.putNotNull(map, "fontFamily", fontFamily);
    JUtils.putNotNull(map, "padding", padding);
    JUtils.putNotNull(map, "usePointStyle", usePointStyle);
    return map;
  }
}
