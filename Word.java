import java.util.*;

public class Word {
    private Country chosenCountry;
    private String dashedWord;
    private ArrayList<String> correctGuesses;

    public Word() {
        this.correctGuesses = new ArrayList<String>();
        this.chosenCountry = this.choseRandomCountry();
    }

    private Country choseRandomCountry() {
        int randomInt = -1;
        DataManager manager = new DataManager();
        ArrayList<Country> allCountries = manager.getCountries();
        Random randomizer = new Random();
        randomInt = randomizer.nextInt(allCountries.size());
        return allCountries.get(randomInt);

    }

    private String makeDashedWord(ArrayList<String> list) {
        
    }
}