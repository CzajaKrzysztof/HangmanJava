import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = reader.nextLine();
        Player user = new Player(name);
        boolean quitGame = false;
        while (!quitGame) {
            Word secretWord = new Word();
            System.out.println("Country name: " + secretWord.getCountryName());
            System.out.println("Secret word: " + secretWord.getCapital());
            boolean isGameWon = false;
            user.setStartTime();
            
            while (user.getLives() > 0 && !isGameWon) {
                System.out.println("Users lives: " + user.getLives());
                System.out.println("Dashed word: " + secretWord.getDashedWord());
                System.out.print("Enter character or word: ");
                String input = reader.nextLine().toUpperCase();
                if (input.length() > 1) {
                    if (secretWord.isInputACorrectGuess(input)) {
                        isGameWon = true;
                        System.out.println("You won!");
                        user.setEndTime();
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
                            System.out.println("You won!");
                            user.setEndTime();

                        }
                    }
                    else {
                        user.decreaseLive(1);
                        user.addToBasGuesses(input);
                    }
                }
                user.increaseTries();
            }
            if (!isGameWon) {
                System.out.println("You lost!");
                user.resetLives();
            }
            String playAgain = "";
            while (!(playAgain.equals("y") || playAgain.equals("n"))) {
                System.out.print("Do you want to play again(y/n): ");
                playAgain = reader.nextLine();
            }
            if (playAgain.equals("n")) {
                quitGame = true;
            }
        }
        
    }
}