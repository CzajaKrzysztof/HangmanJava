import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    public ArrayList<String> getFileContentArray(String file_name) {
        ArrayList<String> contentArray = new ArrayList<String>();
        Scanner reader;
        try {
            File myFile = new File(file_name);
            reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                contentArray.add(line);
            }
            reader.close();
            return contentArray;
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return contentArray;
        }
    }

    public ArrayList<Score> getScores() {
        ArrayList<Score> scoreArrayList = new ArrayList<Score>();
        Scanner reader;
        try {
            File scoreFile = new File("highs_score.txt");
            reader = new Scanner(scoreFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] score = line.split(" \\| ");
                scoreArrayList.add(new Score(score[0], score[1], score[2], score[3], score[4]));
            }
            reader.close();
            return scoreArrayList;
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return scoreArrayList;
        }
    }

    public void saveStringToFile(String dataToWrite) {
        try {
            File file = new File("highs_score.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(dataToWrite);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}