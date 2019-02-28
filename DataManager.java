import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class DataManager {
    ArrayList<Country> countries = new ArrayList<Country>();

    public DataManager() {

    }

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
            return this.countries;
        }
    }

    public ArrayList<String> getAsciiArt(String file_name) {
        ArrayList<String> asciiArt = new ArrayList<String>();
        Scanner reader;
        try {
            File myFile = new File(file_name);
            reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                asciiArt.add(line);
            }
            reader.close();
            return asciiArt;
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return asciiArt;
        }
    }
}