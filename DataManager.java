import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class DataManager {
    ArrayList<Country> countries = new ArrayList<Country>();

    public ArrayList<Country> getCountries() {
        Scanner reader;
        try {
            File myFile = new File("countries_and_capitals.txt");
            reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] countryArray = line.split(" \\| ");
                this.countries.add(new Country(countryArray[0], countryArray[1]));
            }
            reader.close();
            return countries;
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return this.countries; // we exit the method
        }
    }
}