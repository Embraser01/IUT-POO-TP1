package gfx;

import base.Team;

import javax.swing.*;
import java.util.ArrayList;


public abstract class AbstractPano extends JPanel {

    protected ArrayList<Team> teamList;

    public AbstractPano(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }
}
