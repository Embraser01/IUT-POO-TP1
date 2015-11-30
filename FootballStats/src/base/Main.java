package base;

import db.DatabaseConnector;
import gfx.Fenetre;

public class Main {

    public static void main(String[] args) {

        Fenetre fen = new Fenetre();
        fen.setLocationRelativeTo(fen.getParent());
        fen.setVisible(true);

        DatabaseConnector.close();
    }
 }
