import java.util.ArrayList;

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

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public long getTime() {
        return this.endTime - this.startTime;
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
            this.lives--;
        }
    }

    public int getLives() {
        return this.lives;
    }

    public void addToBasGuesses(String badGuess) {
        this.badGuesses.add(badGuess);
    }

    public String getBasGuesses() {
        String result = this.badGuesses.get(0);
        for (int i = 1; i < this.badGuesses.size(); i++) {
            result += ", " + this.badGuesses.get(i);
        }
        return result;
    }

    public String toString() {
        return this.name + " " + this.tries + " " + this.lives + " " + this.startTime + " " + this.endTime + " " + this.getBasGuesses();
    }

}