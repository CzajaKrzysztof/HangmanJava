import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = reader.nextLine();
        Player user = new Player(name);
        //Zaczac od stowrzenia obiektu Word
        
        
        // DataManager manager = new DataManager();
        // ArrayList<Country> allCountries = manager.getCountries();
        // for (Country country: allCountries) {
        //     System.out.println(country.toString());
        // }
    }
}