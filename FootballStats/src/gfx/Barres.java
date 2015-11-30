package gfx;

import base.Team;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.util.ArrayList;


public class Barres extends AbstractBarres {

    private ArrayList<Team> tmpList = null;

    public Barres(ArrayList<Team> teamList) {
        super(teamList, "Victoires-Egalités-Défaites/Champion", "Champions", "Nombres");
    }


    @Override
    protected CategoryDataset createDataset() {

        final double[][] data = getData();
        final String[] names = getNames();
        final String[] labels = {"Victoires", "Egalités", "Défaites"};

        return DatasetUtilities.createCategoryDataset(labels, names, data);
    }

    private double[][] getData() {
        tmpList = new ArrayList<Team>();

        for (int i = 0; i < teamList.size(); i++)
            if (teamList.get(i).getChampionships() >= 1) tmpList.add(teamList.get(i));

        double[][] data = new double[3][tmpList.size()];

        for (int i = 0; i < tmpList.size(); i++) {
            data[0][i] = tmpList.get(i).getWon();
            data[1][i] = tmpList.get(i).getTie();
            data[2][i] = tmpList.get(i).getLost();
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
