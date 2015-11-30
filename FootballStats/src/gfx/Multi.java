package gfx;

import base.Team;
import gfx.multi.MBarres1;
import gfx.multi.MBarres2;
import gfx.multi.MBarres3;
import gfx.multi.MCamembert;

import java.awt.*;
import java.util.ArrayList;


public class Multi extends AbstractPano {

    private MCamembert mCamembert;
    private MBarres1 mBarres1;
    private MBarres2 mBarres2;
    private MBarres3 mBarres3;

    public Multi(ArrayList<Team> teamList) {
        super(teamList);

        mCamembert = new MCamembert(teamList);
        mBarres1 = new MBarres1(teamList);
        mBarres2 = new MBarres2(teamList);
        mBarres3 = new MBarres3(teamList);

        GridBagConstraints cont = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        cont.gridx = 0;
        cont.gridy = 0;
        this.add(mCamembert, cont);

        cont.gridx = 1;
        cont.gridy = 0;
        this.add(mBarres1, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        this.add(mBarres2, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        this.add(mBarres3, cont);
    }
}
