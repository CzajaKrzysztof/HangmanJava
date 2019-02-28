import java.util.HashMap;
import java.util.ArrayList;

public class DrawHangman {
    private final HashMap<Integer, String> asciiArts;

    public DrawHangman() {
        asciiArts = new HashMap<Integer,String>();
        this.asciiArts.put(0,"hangman_0.txt");
        this.asciiArts.put(1,"hangman_1.txt");
        this.asciiArts.put(2,"hangman_2.txt");
        this.asciiArts.put(3,"hangman_3.txt");
        this.asciiArts.put(4,"hangman_4.txt");
        this.asciiArts.put(5,"hangman_5.txt");
        this.asciiArts.put(6,"hangman_6.txt");
        this.asciiArts.put(7,"hangman_7.txt");
        this.asciiArts.put(8,"hangman_8.txt");
        this.asciiArts.put(9,"hangman_9.txt");
        this.asciiArts.put(10,"hangman_10.txt");
    }

    private ArrayList<String> getAsciArt(int lives) {
        ArrayList<String> hangmanArt;
        String file_name = "";

        file_name = this.asciiArts.get(lives);
        DataManager manager = new DataManager();
        hangmanArt = manager.getFileContentArray(file_name);

        return hangmanArt;
    }

    public void printHangman(int lives) {
        ArrayList<String> hangmanArt;
        hangmanArt = this.getAsciArt(lives);
        for (String line: hangmanArt) {
            System.out.println(line);
        }
    }
}