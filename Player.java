import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Player {
    private String name;
    private int tries;
    private int lives;
    private long startTime;
    private long endTime;
    private ArrayList<String> badGuesses;

    public Player(String name) {
        this.name = name;
        this.tries = 0;
        this.lives = 10;
        this.startTime = 0;
        this.endTime = 0;
        badGuesses = new ArrayList<String>();
    }

    public String getName() {
        return this.name;
    }
    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public long getTime() {
        return (this.endTime - this.startTime) / 1000;
    }

    public void increaseTries() {
        this.tries++;
    }

    public int setTries() {
        return this.tries;
    }

    public void decreaseLive(int amount) {
        if (this.lives < amount) {
            this.lives = 0;
        }
        else {
            this.lives -= amount;
        }
    }

    public int getLives() {
        return this.lives;
    }

    public int getTries() {
        return this.tries;
    }

    public void addToBasGuesses(String badGuess) {
        this.badGuesses.add(badGuess);
    }

    public String getBasGuesses() {
        String result = "";
        if (!badGuesses.isEmpty()) {
            result = this.badGuesses.get(0);
            for (int i = 1; i < this.badGuesses.size(); i++) {
                result += ", " + this.badGuesses.get(i);
            }
        } else {
            result = "";
        }
            return result;
    }

    public void reset() {
        this.lives = 10;
        this.tries = 0;
        this.badGuesses.clear();
        this.startTime = 0;
        this.endTime = 0;
    }

    public void calculateScore(String capital) {
        String scoreString = this.getName() + " | " + this.getDate() + " | " + this.getTime() + " | " + this.getTries() + " | " + capital;
        DataManager manager = new DataManager();
        manager.saveStringToFile(scoreString);

    }

    private String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}