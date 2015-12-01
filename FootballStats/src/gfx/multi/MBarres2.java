package gfx.multi;

import base.Team;
import gfx.AbstractBarres;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 30/11/2015.
 */
public class MBarres2 extends AbstractBarres {

    private ArrayList<Team> tmpList = null;

    public MBarres2(ArrayList<Team> teamList) {
        super(teamList, "Marqués-encaissés/Champion", "Buts", "Pays", PlotOrientation.HORIZONTAL, true);
    }

    @Override
    protected CategoryDataset createDataset() {

        final double[][] data = getData();
        final String[] names = getNames();
        final String[] labels = {"Marqués", "Encaissés"};

        return DatasetUtilities.createCategoryDataset(labels, names, data);
    }

    private double[][] getData() {
        tmpList = new ArrayList<>();

        for (int i = 0; i < teamList.size(); i++)
            if (teamList.get(i).getChampionships() >= 1) tmpList.add(teamList.get(i));

        double[][] data = new double[2][tmpList.size()];

        for (int i = 0; i < tmpList.size(); i++) {
            data[0][i] = tmpList.get(i).getGoalsfor();
            data[1][i] = -tmpList.get(i).getGoalsagainst();
        }
        return data;
    }

    private String[] getNames() {
        if (tmpList == null) return null;

        String[] data = new String[tmpList.size()];

        for (int i = 0; i < tmpList.size(); i++)
            data[i] = tmpList.get(i).getTeam();

        return data;
    }
}
