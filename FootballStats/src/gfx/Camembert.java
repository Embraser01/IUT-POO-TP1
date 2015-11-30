package gfx;


import base.Team;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.ArrayList;

public class Camembert extends AbstractCamembert{


    public Camembert(ArrayList<Team> teamList) {
        super(teamList,"PROPORTION PAYS/CONTINENT");
    }


    @Override
    protected PieDataset createDataset() {

        final DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Africa", countFrequency("Africa"));
        result.setValue("America", countFrequency("America"));
        result.setValue("Asia", countFrequency("Asia"));
        result.setValue("Europe", countFrequency("Europe"));
        result.setValue("Oceania", countFrequency("Oceania"));
        return result;
    }

    private int countFrequency(String filter){
        int nb = 0;

        for(int i = 0; i < teamList.size();i++)
            if(teamList.get(i).getContinent().equals(filter)) nb++;

        return nb;
    }
}
