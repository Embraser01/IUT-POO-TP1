package base;

import db.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Data {

    private ArrayList<Team> teamList = null;
    private Connection db = null;
    private Statement statement = null;

    public Data() {
        //db = DatabaseConnector.openDb("statistics.sqlite");
        //db = DatabaseConnector.openDb("D:/Mes Documents/dev/Java/IUT-POO-TP1/FootballStats/src/statistics.sqlite");
        db = DatabaseConnector.openDb("F:/Documents/_IUT/POO/TP1/FootballStats/src/statistics.sqlite");
        teamList = new ArrayList<Team>();

        loadData();
    }

    private void loadData() {
        if (db == null) return;

        ResultSet res = null;

        try {
            statement = db.createStatement();
            res = statement.executeQuery("SELECT * FROM worldcup");

            while(res.next()){
                teamList.add(new Team(res.getInt("id"),
                        res.getString("team"),
                        res.getString("continent"),
                        res.getInt("played"),
                        res.getInt("won"),
                        res.getInt("tie"),
                        res.getInt("lost"),
                        res.getInt("goalsfor"),
                        res.getInt("goalsagainst"),
                        res.getInt("points"),
                        res.getInt("participations"),
                        res.getInt("championships"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Data{" +
                "teamList=" + teamList.toString() +
                "}";
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }
}
