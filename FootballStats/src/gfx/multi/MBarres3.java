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
public class MBarres3 extends AbstractBarres {

    private ArrayList<Team> tmpList = null;

    public MBarres3(ArrayList<Team> teamList) {
        super(teamList, "Champions/Continent", "Nombre", "Continent");
    }

    @Override
    protected CategoryDataset createDataset() {

        final double[][] data = getData();
        final String[] names = {"Africa", "America", "Asia", "Europe", "Oceania"};
        final String[] labels = {"Nothing"};

        return DatasetUtilities.createCategoryDataset(labels, names, data);
    }

    private double[][] getData() {
        tmpList = new ArrayList<Team>();

        for (Team aTeamList : teamList) if (aTeamList.getChampionships() >= 1) tmpList.add(aTeamList);

        double[][] data = new double[1][5];

        for(int i = 0; i < 5; i++) data[0][i] = 0;

        String tmp = "";

        for (int i = 0; i < tmpList.size(); i++) {
            tmp = tmpList.get(i).getContinent();

            switch (tmp) {
                case "Africa":
                    data[0][0] += tmpList.get(i).getChampionships();
                    break;
                case "America":
                    data[0][1] += tmpList.get(i).getChampionships();
                    break;
                case "Asia":
                    data[0][2] += tmpList.get(i).getChampionships();
                    break;
                case "Europe":
                    data[0][3] += tmpList.get(i).getChampionships();
                    break;
                case "Oceania":
                    data[0][4] += tmpList.get(i).getChampionships();
                    break;
            }
        }
        return data;
    }
}
