package gfx;

import base.Team;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 30/11/2015.
 */
public abstract class AbstractCamembert extends AbstractPano {


    public AbstractCamembert(ArrayList<Team> teamList, String chartTitle) {
        this(teamList, chartTitle, "No data to display");
    }

    public AbstractCamembert(ArrayList<Team> teamList, String chartTitle, String noDataMessage) {
        super(teamList);

        final PieDataset dataset = createDataset();

        final JFreeChart chart = createChart(dataset, chartTitle, noDataMessage);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        this.add(chartPanel);
    }


    protected abstract PieDataset createDataset();

    private JFreeChart createChart(final PieDataset dataset, String chartTitle, String noDataMessage) {

        final JFreeChart chart = ChartFactory.createPieChart3D(
                chartTitle,  // chart title
                dataset,                // data
                true,                   // include legend
                true,
                false
        );

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage(noDataMessage);
        return chart;
    }
}
