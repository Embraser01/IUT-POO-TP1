package gfx;

import base.Team;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer3D;
import org.jfree.data.category.CategoryDataset;

import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 30/11/2015.
 */
public abstract class AbstractBarres extends AbstractPano {

    public AbstractBarres(ArrayList<Team> teamList, String title, String domain, String range) {
        this(teamList, title, domain, range, PlotOrientation.VERTICAL, false);
    }

    public AbstractBarres(ArrayList<Team> teamList, String title, String domain, String range, PlotOrientation orientation) {
        this(teamList, title, domain, range, orientation, false);
    }

    public AbstractBarres(ArrayList<Team> teamList, String title, String domain, String range, PlotOrientation orientation, boolean stacked) {
        super(teamList);

        // create a dataset...
        final CategoryDataset dataset = createDataset();

        // create the chart...
        final JFreeChart chart = createCategoryChart(dataset, title, domain, range, orientation, stacked);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        this.add(chartPanel);
    }


    protected abstract CategoryDataset createDataset();


    private JFreeChart createCategoryChart(final CategoryDataset dataset, String title, String domain, String range, PlotOrientation orientation, boolean stacked) {

        final JFreeChart chart;

        if (stacked) {
            chart = ChartFactory.createStackedBarChart(
                    title,      // chart title
                    domain,               // domain axis label
                    range,                 // range axis label
                    dataset,                  // data
                    orientation, // orientation
                    true,                     // include legend
                    true,                     // tooltips
                    false                     // urls
            );
        } else {
            chart = ChartFactory.createBarChart3D(
                    title,      // chart title
                    domain,               // domain axis label
                    range,                 // range axis label
                    dataset,                  // data
                    orientation, // orientation
                    true,                     // include legend
                    true,                     // tooltips
                    false                     // urls
            );
        }
        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );

        if (stacked) {
            final StackedBarRenderer renderer = (StackedBarRenderer) plot.getRenderer();
            renderer.setDrawBarOutline(false);
        } else {
            final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
            renderer.setDrawBarOutline(false);
        }

        return chart;
    }
}
