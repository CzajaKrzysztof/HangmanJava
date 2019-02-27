import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        ArrayList<Country> allCountries = manager.getCountries();
        for (Country country: allCountries) {
            System.out.println(country.toString());
        }
    }
}