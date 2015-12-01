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
public class MBarres1 extends AbstractBarres {


    public MBarres1(ArrayList<Team> teamList) {
        super(teamList, "V-N-D/Continent", "Continent", "Nombre", PlotOrientation.HORIZONTAL, true);
    }

    @Override
    protected CategoryDataset createDataset() {

        final double[][] data = getData();
        final String[] names = {"Africa", "America", "Asia", "Europe", "Oceania"};
        final String[] labels = {"Victoires", "Egalités", "Défaites"};

        return DatasetUtilities.createCategoryDataset(labels, names, data);
    }

    private double[][] getData() {

        double[][] data = new double[3][5];

        String tmp = "";

        for (int i = 0; i < teamList.size(); i++) {
            tmp = teamList.get(i).getContinent();

            if (tmp.equals("Africa")) {
                data[0][0] += teamList.get(i).getWon();
                data[1][0] += teamList.get(i).getTie();
                data[2][0] += teamList.get(i).getLost();
            } else if (tmp.equals("America")) {
                data[0][1] += teamList.get(i).getWon();
                data[1][1] += teamList.get(i).getTie();
                data[2][1] += teamList.get(i).getLost();
            } else if (tmp.equals("Asia")) {
                data[0][2] += teamList.get(i).getWon();
                data[1][2] += teamList.get(i).getTie();
                data[2][2] += teamList.get(i).getLost();
            } else if (tmp.equals("Europe")) {
                data[0][3] += teamList.get(i).getWon();
                data[1][3] += teamList.get(i).getTie();
                data[2][3] += teamList.get(i).getLost();
            } else if (tmp.equals("Oceania")) {
                data[0][4] += teamList.get(i).getWon();
                data[1][4] += teamList.get(i).getTie();
                data[2][4] += teamList.get(i).getLost();
            }
        }
        return data;
    }
}
