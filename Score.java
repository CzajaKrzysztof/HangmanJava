import java.util.*;

public class Score {
    private String name;
    private String date;
    private Long time;
    private int tries;
    private String capital;

    public Score() {

    }

    public Score(String name, String date, String time, String tries, String capital) {
        this.name = name;
        this.date = date;
        this.time = Long.parseLong(time);
        this.tries = Integer.parseInt(tries);
        this.capital = capital;
    }

    public String getName() {
        return this.name;
    }

    public String getdate() {
        return this.date;
    }

    public Long getTime() {
        return this.time;
    }

    public int getTries() {
        return this.tries;
    }

    public String getCapital() {
        return this.capital;
    }

    public static ArrayList<Score> getUsersScore() {
        ArrayList<Score> highScore = new ArrayList<Score>();
        DataManager manager = new DataManager();
        highScore = manager.getScores();
        return highScore;
    }

    public String toString() {
        String score = this.name + " " + this.date + " " + this.time + " " + this.tries + " " + this.capital;
        return score;
    }
}