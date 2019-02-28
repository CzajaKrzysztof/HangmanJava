import java.util.*;

public class Word {
    private Country chosenCountry;
    private ArrayList<String> correctGuesses;

    public Word() {
        this.correctGuesses = new ArrayList<String>();
        this.correctGuesses.add(" ");
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

    public boolean isWordGuessed() {
        boolean result = false;
        String dashedWord = this.makeDashedWord();
        if (!dashedWord.contains("_")) {
            result = true;
        }
        return result;
    }

    public boolean isInputACorrectGuess(String input) {
        boolean result = false;
        if (chosenCountry.getCapital().toUpperCase().equals(input)) {
            result = true;
        }
        return result;
    }

    public void addToCorrectGuesses(String input) {
        this.correctGuesses.add(input);
    }

    public boolean isInputInCapital(String input) {
        boolean result = false;
        if (chosenCountry.getCapital().toUpperCase().contains(input)) {
            result = true;
        }
        return result;
    }

    public String getDashedWord() {
        return this.makeDashedWord();
    }

    public String getCountryName() {
        return this.chosenCountry.getName();
    }

    public String getCapital() {
        return this.chosenCountry.getCapital();
    }
}