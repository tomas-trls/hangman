import java.util.Arrays;
import java.util.Scanner;

public class Game {

    String[] wordsArr = {"france", "elephant", "giraffe", "Nology", "Spain", "Marseille", "Javascript"};
    WordLibrary words = new WordLibrary(wordsArr);
    String randomWord = words.getRandomWord();

    void launchGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the HangMan Game! \n Please select an option: \n 1: Play | 2: Quit ");
        String option = scanner.nextLine();
        if (option.equals("2")) {
            System.out.println(stopGame());
        } else {
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            Player player = new Player(name);
            playGame(player);
        }

    }

    void playGame(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecting a random word...");
        System.out.println("... ... ... ... ... .... ... ...");
        System.out.println("...Starting the game...");

        String[] guessArr = new String[randomWord.length()];

        Arrays.fill(guessArr, "_");

        String[] wordCharArr = randomWord.split("");
        int chainErrorsCounter = 0;
        int chainSuccessCounter = 0;

        while (player.getLives() != 0) {
            System.out.println("Remaining ❤️ lives: " + player.getLives());
            String guessString = String.join("", guessArr);
            System.out.println(guessString);
            System.out.println("Please add a or a word guess(with the correct amount of letters:");
            String input = scanner.nextLine();

            if (input.length() == randomWord.length()) {
                if (input.toUpperCase().equals(randomWord)) {
                    win(player);
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
                            win(player);
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


    void win(Player player){
        System.out.printf("🎉 You win 🌟 %s! You had %s ❤ left, the word was %s", player.getName(), player.getLives(), randomWord);
    }
    void loose(Player player,String word) {
        System.out.printf("\n You loose %s 😢, the word was %s!", player.getName(), randomWord);
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
        return "You have quit the game.";
    }


}
