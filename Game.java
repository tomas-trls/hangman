import java.util.Arrays;
import java.util.Scanner;
public class Game {

    void launchGame() {
        System.out.println("\nWelcome to the HangMan Game!");
        menu();
    }

    void menu(){
        System.out.println("\t Please select a valid option: \n\t     1: Play | 2: Quit");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (option.equals("2")) {
            System.out.println(stopGame());
        } else if( option.equals("1")){
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            Player player = new Player(name);
            String randomWord = WordLibrary.getRandomWord();
            playGame(player, randomWord);
        } else {
            menu();
        }
    }

    void playGame(Player player, String randomWord){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecting a random word...");
        System.out.println("... ... ... ... ... ... ");
        System.out.println("...Starting the game...");

        String[] guessArr = new String[randomWord.length()];
        Arrays.fill(guessArr, "_");
        String[] wordCharArr = randomWord.split("");

        int chainErrorsCounter = 0;
        int chainSuccessCounter = 0;

        while (player.getLives() != 0) {
            System.out.println("Please add a or a word guess (with the correct amount of letters.):");

            System.out.printf("\t%s ❤️ left! \n", player.getLives());
            String guessString = String.join("", guessArr);
            System.out.println("\n\t"+guessString);

            String input = scanner.nextLine();

            if (input.length() == randomWord.length()) {
                if (input.toUpperCase().equals(randomWord)) {
                    win(player, randomWord);
                    break;
                } else {
                    player.looseALife(input);
                }
            } else if (input.length() > 1 || input.equals("")) {
                chainErrorsCounter++;
                System.out.println("Please enter only one letter or guess a word with the exact same number of letters.");
            } else if (input.matches("[0-9]")) {
                chainErrorsCounter++;
                System.out.println("Words are not made with numbers");
            } else {
                if (randomWord.contains(input.toUpperCase())) {
                    if (Arrays.toString(guessArr).contains(input.toUpperCase())){
                        System.out.println("You already wrote this letter!");
                    } else {
                        correctWord(wordCharArr, guessArr, input);
                        chainSuccessCounter++;
                        if(Arrays.toString(guessArr).equals(Arrays.toString(wordCharArr))){
                            win(player, randomWord);
                            break;
                        }
                        if(chainSuccessCounter > 2){
                            System.out.println("🔥 YOU ARE ON FIREEE! 🔥");
                        }
                    }
                } else {
                    chainSuccessCounter = 0;
                    player.looseALife(input);
                }
            }
            if (chainErrorsCounter > 2){
                System.out.println("❌⚡ Please try to focus... You loose a life to remind yourself that sometimes it's better to think than just spam. ⚡❌");
                player.looseALife(input);
                chainErrorsCounter = 0;
            }
            if (player.getLives() == 0) {
                loose(player, randomWord);
            }
        }
    }

    void win(Player player, String randomWord){
        System.out.printf("🎉 You win 🌟 %s! You had %s ❤ left, the word was %s!", player.getName(), player.getLives(), randomWord);
        System.out.println("\nDo you want to play again?");
        playAgain(player);
    }
    void loose(Player player,String randomWord) {
        System.out.printf("\nYou loose %s 😢, the word was %s!", player.getName(), randomWord);
        System.out.println("\nDo you want to play again?");
        playAgain(player);
    }

    void playAgain(Player player){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yes/No");
        String answer = scanner.nextLine();

        if (answer.toUpperCase().contains("Y")){
            String newRandomWord = WordLibrary.getRandomWord();
            player.setLives(8);
            playGame(player, newRandomWord);
        } else if (answer.toUpperCase().contains("N")){
            System.out.println(stopGame());
        } else {
            System.out.println("Please select a valid option.");
            playAgain(player);
        }

    }


     void correctWord(String[] wordArr, String[] guessArr, String input){
        int index = 0;
        for (int i = 0; i < wordArr.length; i++) {
            if (input.toUpperCase().contains(wordArr[i])) {
                index = i;
                guessArr[index] = input.toUpperCase();
            }
        }
        System.out.println("✅ Correct!");
    }
    String stopGame() {
        return "You have quit the game. \n 👋 Bye Bye 👋";
    }

}
