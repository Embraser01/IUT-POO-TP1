package gfx.multi;

import base.Team;
import gfx.AbstractCamembert;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.ArrayList;


/**
 * Created by Marc-Antoine on 30/11/2015.
 */
public class MCamembert extends AbstractCamembert {

    public MCamembert(ArrayList<Team> teamList) {
        super(teamList,"Nbre joués/continent");
    }


    protected PieDataset createDataset() {

        final int data[] = getContinentPlayedMatch();

        final DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Africa", data[0]);
        result.setValue("America", data[1]);
        result.setValue("Asia", data[2]);
        result.setValue("Europe", data[3]);
        result.setValue("Oceania", data[4]);
        return result;
    }

    private int[] getContinentPlayedMatch() {
        int data[] = {0, 0, 0, 0, 0};

        String tmp = "";

        for (int i = 0; i < teamList.size(); i++) {
            tmp = teamList.get(i).getContinent();

            if (tmp.equals("Africa")) {
                data[0]++;
            } else if (tmp.equals("America")) {
                data[1]++;
            } else if (tmp.equals("Asia")) {
                data[2]++;
            } else if (tmp.equals("Europe")) {
                data[3]++;
            } else if (tmp.equals("Oceania")) {
                data[4]++;
            }
        }
        return data;
    }
}
