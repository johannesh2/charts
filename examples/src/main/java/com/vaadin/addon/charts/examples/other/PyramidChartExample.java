package com.vaadin.addon.charts.examples.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataLabelsFunnel;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsPyramid;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class PyramidChartExample extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Pyramid chart example";
    }

    @Override
    protected Component getChart() {
        DataSeries dataSeries = new DataSeries("Unique users");
        dataSeries.add(new DataSeriesItem("Website visits", 15654));
        dataSeries.add(new DataSeriesItem("Downloads", 4064));
        dataSeries.add(new DataSeriesItem("Requested price list", 1987));
        dataSeries.add(new DataSeriesItem("Invoice sent", 976));
        dataSeries.add(new DataSeriesItem("Finalized", 846));

        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Sales pyramid");
        conf.getLegend().setEnabled(false);

        PlotOptionsPyramid options = new PlotOptionsPyramid();

        // FIXME missing generated API
        // options.setWidthAsPercentage(70); // With default (90%), long labels
        // in
        // this example may be cut
        // options.setWidth(400); // in pixels

        DataLabelsFunnel dataLabels = new DataLabelsFunnel();
        dataLabels.setFormat("<b>{point.name}</b> ({point.y:,.0f})");
        options.setDataLabels(dataLabels);

        dataSeries.setPlotOptions(options);
        conf.addSeries(dataSeries);

        return chart;
    }

}
