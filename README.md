# Vaadin 14 Chart.js
Vaadin 14 addon for the Chart.js charting library. https://github.com/chartjs/Chart.js

## Notice

This add-on was originally created by [moberwasserlechner](https://github.com/moberwasserlechner/), but the repository is now archived. I reworked it to work with Vaadin 14 because I had to upgrade an existing Vaadin 8 project using this add-on to Vaadin 14. This is probably not the most efficient implementation (I currently send the state to the client every time it is changed), and I am open to pull requests. I have also deprecated a few features.

## Features
### Deprecated
* Menu API
    * can be replaced by Vaadin 14 Menu component(s).
* Download image of chart
    * Most modern browsers allow you to download a canvas
* Annotations
    * I plan to re-implement and test this, but haven't yet
* Pan support
    * Plan to fix panning but haven't quite figured it out yet
* Legend/Data point click listeners
    * May reimplement in the future, but I want a working version of this add-on first

### Current
* Fluent api to configure the charts
* Supported chart types are
  * Horizontal bar chart
  * Vertical bar chart
  * Line chart
  * Donut chart
  * Pie chart
  * Polar area chart
  * Bubble chart
  * Radar chart
  * Scatter line chart
* Zoom support

### Chart.js

* http://www.chartjs.org/samples/latest/
* https://github.com/chartjs/Chart.js/releases/latest


### Maven

```xml
<dependencies>
  <dependency>
    <groupId>org.vaadin.addons.chartjs</groupId>
    <artifactId>chartjs</artifactId>
    <version>use.lastest.version</version>
  </dependency>
</dependencies>
```

### Gradle

```gradle
repositories {
  mavenCentral()
}

dependencies {
  compile ("org.vaadin.addons.chartjs:vaadin-chartjs:use.latest.version")
}
```

## Usage

The basic usage is always the same. You need to create a new ChartJs() and configure it with a chart type specific config.

For more examples please see the [demo app](#vaadin-addon)

```java
        ChartJs myChart = new ChartJs(config);
        // enable logging to the javascript console. You can see some interessenting things there ;). Please do not use this in production because it's only needed for debugging.
        myChart.setJsLoggingEnabled(true);
        myChart.setWidth(50, Unit.PERCENTAGE);
        // add a data point clicklistener
        myChart.addClickListener((datasetIdx, dataIdx) -> {
            BarDataset dataset = (BarDataset) barConfig.data().getDatasets().get(datasetIdx);
            Notification.show("BarDataset at idx:" + datasetIdx + "; Data: idx=" + dataIdx + "; Value=" + dataset.getData().get(dataIdx), Type.WARNING_MESSAGE);
        });
```

### Bar chart configuration

In this example we configure a horizontal bar chart with 3 dataset and add some random numbers to each of them.

```java

BarChartConfig config = new BarChartConfig();
config
    .data()
        .labels("January", "February", "March", "April", "May", "June", "July")
        .addDataset(new BarDataset().type().label("Dataset 1").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
        .addDataset(new LineDataset().type().label("Dataset 2").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
        .addDataset(new BarDataset().type().label("Dataset 3").backgroundColor("rgba(220,220,220,0.5)"))
        .and();

config.
    options()
        .responsive(true)
        .title()
            .display(true)
            .position(Position.LEFT)
            .text("Chart.js Combo Bar Line Chart")
            .and()
       .done();

List<String> labels = config.data().getLabels();
for (Dataset<?, ?> ds : config.data().getDatasets()) {
    List<Double> data = new ArrayList<>();
    for (int i = 0; i < labels.size(); i++) {
        data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
    }

    if (ds instanceof BarDataset) {
        BarDataset bds = (BarDataset) ds;
        bds.dataAsList(data);
    }

    if (ds instanceof LineDataset) {
        LineDataset lds = (LineDataset) ds;
        lds.dataAsList(data);
    }
}

ChartJs chart = new ChartJs(config);
chart.setJsLoggingEnabled(true);

return chart;
```

### Chart Options

Please have a look at the great documentation at ChartJs. (http://www.chartjs.org/docs)

You will see that every fluent api method under `config.options()` has a counterpart in the javascript json config.

### Demo

A built-in Jetty demo application is included.
To start it:
1. Run ```mvn -Dtest=DemoView``` from the project root.
2. Navigate to `http://localhost:8080/demo`.

## Prerequisite

### Addon
* JDK 8
* Vaadin 8.x

## Missing something?

The Vaadin-Chartjs is only a wrapper. So if you have any feature requests or found any bugs in the javascript lib please use Chart.js's issue tracker https://github.com/chartjs/Chart.js/issues

In all other cases please create a issue at https://github.com/rudiejd/vaadin-chartjs/issues or contribute to the project yourself. For contribution see the next section.

## Contribute

### Fix a bug or create a new feature

Please do not mix more than one issue in a feature branch. Each feature/bugfix should have its own branch and its own Pull Request (PR).

1. Create a issue and describe what you want to do at [Issue Tracker](https://github.com/rudiejd/vaadin-chartjs/issues)
2. Create your feature branch (`git checkout -b feature/my-feature` or `git checkout -b bugfix/my-bugfix`)
3. Test your changes to the best of your ability.
4. Add a demo view to the demo application
5. Commit your changes (`git commit -m 'Describe feature or bug'`)
6. Push to the branch (`git push origin feature/my-feature`)
7. Create a Github Pull Request

### Code Style

This repo includes a .editorconfig file, which your IDE should pickup automatically.

If not please use the sun coding convention. Please do not use tabs at all!

Try to change only parts your feature or bugfix requires.

## License

MIT. Please see [LICENSE](https://github.com/rudiejd/vaadin-chartjs/blob/master/LICENSE).
