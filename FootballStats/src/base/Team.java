package base;

public class Team {

    private int id;
    private String team;
    private String continent;
    private int played;
    private int won;
    private int tie;
    private int lost;
    private int goalsfor;
    private int goalsagainst;
    private int points;
    private int participations;
    private int championships;

    public Team(int id, String team, String continent, int played, int won, int tie, int lost, int goalsfor, int goalsagainst, int points, int participations, int championships) {
        this.id = id;
        this.team = team;
        this.continent = continent;
        this.played = played;
        this.won = won;
        this.tie = tie;
        this.lost = lost;
        this.goalsfor = goalsfor;
        this.goalsagainst = goalsagainst;
        this.points = points;
        this.participations = participations;
        this.championships = championships;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getGoalsfor() {
        return goalsfor;
    }

    public void setGoalsfor(int goalsfor) {
        this.goalsfor = goalsfor;
    }

    public int getGoalsagainst() {
        return goalsagainst;
    }

    public void setGoalsagainst(int goalsagainst) {
        this.goalsagainst = goalsagainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getParticipations() {
        return participations;
    }

    public void setParticipations(int participations) {
        this.participations = participations;
    }

    public int getChampionships() {
        return championships;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", team='" + team + '\'' +
                ", continent='" + continent + '\'' +
                ", played=" + played +
                ", won=" + won +
                ", tie=" + tie +
                ", lost=" + lost +
                ", goalsfor=" + goalsfor +
                ", goalsagainst=" + goalsagainst +
                ", points=" + points +
                ", participations=" + participations +
                ", championships=" + championships +
                "}\n";
    }

    public void setChampionships(int championships) {
        this.championships = championships;
    }
}
