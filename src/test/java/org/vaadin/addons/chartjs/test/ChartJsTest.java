package org.vaadin.addons.chartjs.test;

import org.junit.Test;
import org.vaadin.addons.chartjs.config.LineChartConfig;
import org.vaadin.addons.chartjs.data.LineDataset;
import org.vaadin.addons.chartjs.options.AnimationEasing;
import org.vaadin.addons.chartjs.options.InteractionMode;
import org.vaadin.addons.chartjs.options.Position;
import org.vaadin.addons.chartjs.options.elements.Rectangle.RectangleEdge;
import org.vaadin.addons.chartjs.options.scale.Axis;
import org.vaadin.addons.chartjs.options.scale.LinearScale;
import org.vaadin.addons.chartjs.options.scale.LogarithmicScale;

import static org.junit.Assert.assertNotNull;

public class ChartJsTest {

  @Test
  public void testConfigGeneral() {

    LineChartConfig config = new LineChartConfig();
    config
        .data()
        .labels("A", "B", "C")
        .addDataset(new LineDataset().fill(true).label("Dataset 1").data(1D, 2D, 3D))
        .addDataset(new LineDataset().label("Set 2").data(3.3, 1.3, 2.9))
        .and()
        .options()
        .events("test", "test1")
        .showLines(true)
        .responsive(true)
        .title()
        .display(true)
        .position(Position.LEFT)
        .text("Hello World")
        .and()
        .animation()
        .easing(AnimationEasing.easeOutQuart)
        .and()
        .hover()
        .mode(InteractionMode.INDEX)
        .and()
        .tooltips()
        .mode(InteractionMode.INDEX)
        .and()
        .elements()
        .arc()
        .borderWidth(2)
        .and()
        .rectangle()
        .borderSkipped(RectangleEdge.BOTTOM)
        .and()
        .line()
        .fill(false)
        .and()
        .point()
        .radius(32)
        .and()
        .and()
        .scales()
        .add(Axis.X, new LinearScale().position(Position.TOP))
        .add(Axis.Y, new LogarithmicScale().position(Position.LEFT))
        .and()
        .legend()
        .fullWidth(false)
        .labels()
        .boxWidth(20)
        .and()
        .position(Position.BOTTOM)
        .and()
        .done();

    assertNotNull(config.buildJson());
  }
}
