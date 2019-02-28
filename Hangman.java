import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        clearScreen();
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = reader.nextLine();
        Player user = new Player(name);
        DrawHangman drawArt = new DrawHangman();
        boolean quitGame = false;
        while (!quitGame) {
            Word secretWord = new Word();
            boolean isGameWon = false;
            user.setStartTime();
            while (user.getLives() > 0 && !isGameWon) {
                clearScreen();
                drawArt.printHangman(user.getLives());
                if (args.length > 0 && args[0].equals("-demo")){
                    System.out.println("Secret word: " + secretWord.getCapital());
                }
                if (user.getLives() < 5) {
                    System.out.println("HINT: what is the capital of " + secretWord.getCountryName());
                }
                System.out.println("Dashed word: " + secretWord.getDashedWord());
                System.out.println("Your bad guesses: " + user.getBasGuesses());
                System.out.print("Enter a character or a word: ");
                String input = reader.nextLine().toUpperCase();
                if (input.length() > 1) {
                    if (secretWord.isInputACorrectGuess(input)) {
                        isGameWon = true;
                    }
                    else {
                        user.decreaseLive(2);
                        user.addToBasGuesses(input);
                    }
                }
                else {
                    if (secretWord.isInputInCapital(input)) {
                        secretWord.addToCorrectGuesses(input);
                        if (secretWord.isWordGuessed()) {
                            isGameWon = true;
                        }
                    }
                    else {
                        user.decreaseLive(1);
                        user.addToBasGuesses(input);
                    }
                }
                user.increaseTries();
            }
            if (isGameWon) {
                clearScreen();
                user.setEndTime();
                drawArt.printHangman(user.getLives());
                System.out.println(user.getName() + ", you won after " + user.getTries() + " tries! You playd for " + user.getTime() + " seconds.");
                user.calculateScore(secretWord.getCapital());
            }
            else {
                clearScreen();
                drawArt.printHangman(user.getLives());
                System.out.println(user.getName() + ", you lost! Capital of " + secretWord.getCountryName() + " is " + secretWord.getCapital());
            }
            String playAgain = "";
            while (!(playAgain.equals("y") || playAgain.equals("n"))) {
                System.out.print("Do you want to play again(y/n): ");
                playAgain = reader.nextLine();
            }
            if (playAgain.equals("n")) {
                quitGame = true;
            }
            else {
                user.reset();
                secretWord.reset();
            }
        }
        
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    
}