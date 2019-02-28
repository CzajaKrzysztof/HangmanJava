import java.util.*;

public class Word {
    private Country chosenCountry;
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

    private String makeDashedWord() {
        String dashedWord = "";
        String capital = this.chosenCountry.getCapital().toUpperCase();
        for (int i = 0; i < capital.length(); i++) {
            if (this.correctGuesses.contains("" + capital.charAt(i))) {
                dashedWord += "" + capital.charAt(i) + " ";
            } 
            else {
                dashedWord += "_ ";
            }
        }
        return dashedWord;
    }

    public String getDashedWord() {
        return this.makeDashedWord();
    }

    public String getCountryName() {
        return this.chosenCountry.getCapital();
    }

    public String getCapital() {
        return this.chosenCountry.getCapital();
    }
}