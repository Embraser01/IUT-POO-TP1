package gfx;


import base.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener{

    private JMenuBar menuBar;

    private JMenuItem display;

    private JMenuItem display1;
    private JMenuItem display2;
    private JMenuItem display3;

    private AbstractPano pano;

    private Data data;

    public Fenetre() {

        this.data = new Data();

        this.setTitle("TP1 - POO | Fernandes Marc-Antoine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pano = new Camembert(this.data.getTeamList());

        this.display = new JMenu("Affichage");

        this.display1 = new JMenuItem("Pays/Continent");
        this.display2 = new JMenuItem("V-N-D/Champion");
        this.display3 = new JMenuItem("Multi");

        this.display1.addActionListener(this);
        this.display2.addActionListener(this);
        this.display3.addActionListener(this);

        this.display.add(this.display1);
        this.display.add(this.display2);
        this.display.add(this.display3);

        this.menuBar = new JMenuBar();
        this.menuBar.add(this.display);

        this.setJMenuBar(this.menuBar);
        this.setContentPane(this.pano);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == display1)
            this.pano = new Camembert(this.data.getTeamList());
        if(e.getSource() == display2)
            this.pano = new Barres(this.data.getTeamList());
        if(e.getSource() == display3)
            this.pano = new Multi(this.data.getTeamList());

        this.setContentPane(this.pano);
        this.pack();
    }
}