import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    void launchGame() {
        System.out.println("\n📖Welcome to the HangMan Game 🦥🐒!");
        menu(new Player("not a player"));
    }

    ArrayList<Player> playersArr = new ArrayList<>();

    void menu(Player player) {
        if (player.getName().equals("not a player")) {
            System.out.println("  Please select a valid option: \n1: New Game | 2: Scores | 3: Quit");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.equals("1")) {
                System.out.println("Please enter your name:");
                String name = scanner.nextLine();
                player = new Player(name);
                playersArr.add(player);
                String randomWord = WordLibrary.getRandomWord();
                playGame(player, randomWord);
            } else if (option.equals("2")) {
                System.out.println("\t\tScores");
                System.out.println("\tNo Players ----");
                menu(player);
            } else if (option.equals("3")) {
                stopGame();
            } else {
                menu(player);
            }
        } else {
            System.out.println("CURRENT PLAYER: " + player.getName());
            System.out.println("\t     Please select a valid option: \n1: New Game 2: Continue | 3: Scores | 4: Quit");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.equals("1")) {
                System.out.println("Please enter your name:");
                String name = scanner.nextLine();
                String randomWord = WordLibrary.getRandomWord();
                boolean nameTaken = false;

                for (Player playerObject : playersArr) {
                    if (playerObject.getName().equalsIgnoreCase(name)) {
                        System.out.println("😓 This name is taken! 🙈");
                        menu(playerObject);
                        nameTaken = true;
                        break;
                    }
                }
                if (!nameTaken) {
                    Player playerObject = new Player(name);
                    System.out.println(playerObject.getName());
                    playersArr.add(playerObject);
                    playGame(playerObject, randomWord);
                }

            } else if (option.equals("2")) {
                System.out.println("Do you want to continue with an old player profile or on this profile?");
                System.out.println("1: Old Player | 2: Current Player | 3: Back");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    System.out.println("Select a Player:");
                    for (Player playerObject : playersArr) {
                        System.out.println(playerObject.getId() + ". " + playerObject.getName() + " ---- " + playerObject.getScore() + " points.");
                    }
                    int playerChosen = scanner.nextInt();
                    String randomWord = WordLibrary.getRandomWord();
                    player = playersArr.stream().filter(playerObject -> playerObject.getId() == playerChosen).findFirst().get();
                    player.setLives(8);
                    playGame(player, randomWord);
                } else if (choice.equals("2")) {
                    String randomWord = WordLibrary.getRandomWord();
                    player.setLives(8);
                    playGame(player, randomWord);
                } else if (choice.equals("3")) {
                    menu(player);
                } else {
                    System.out.println("Please select a valid option");
                }
            } else if (option.equals("3")) {
                System.out.println("\t\tScores");
                List<Player> sortedPlayers = playersArr.stream().sorted(Comparator.comparing(Player::getScore).reversed()).collect(Collectors.toList());
                for (Player playerObject : sortedPlayers) {
                    System.out.println("- " + playerObject.getName() + " ---- " + playerObject.getScore() + " points.");
                }
                System.out.println("1. Back");
                String back = scanner.nextLine();
                if (back.equals("1")) {
                    menu(player);
                }
            } else if (option.equals("4")) {
                playersArr.clear();
                stopGame();
            } else {
                menu(player);
            }
        }
    }


    void playGame(Player player, String randomWord) {
        System.out.println("CURRENT PLAYER: " + player.getName());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecting a random word...");
        System.out.println("... ... ... ... ... ... ");
        System.out.println("...Starting the game...");

        String[] guessArr = new String[randomWord.length()];
        Arrays.fill(guessArr, "_");
        String[] wordCharArr = randomWord.split("");
        Set<String> inputSet = new HashSet<>();
        int chainErrorsCounter = 0;
        int chainSuccessCounter = 0;

        while (player.getLives() != 0) {
            System.out.println("Please add a or a word guess (with the correct amount of letters.):");

            System.out.printf("\t%s ❤️ left! \n", player.getLives());
            if (!inputSet.isEmpty()) {
                System.out.println("Letters guessed: " + String.join(",", inputSet));
            }
            String guessString = String.join("", guessArr);
            System.out.println("\n\t" + guessString);

            String input = scanner.nextLine();

            if (input.length() == randomWord.length()) {
                if (input.toUpperCase().equals(randomWord)) {
                    win(player, randomWord);
                    break;
                } else {
                    System.out.println("🤣 You guess the wrong word and you loose the game. 🤣");
                    player.setLives(0);
                }
            } else if (input.length() > 1 || input.equals("")) {
                chainErrorsCounter++;
                System.out.println("🐱‍🚀 Please enter only one letter or guess a word with the exact same number of letters. 🤗");
            } else if (input.matches("[0-9]")) {
                chainErrorsCounter++;
                System.out.println("🤓 Words are not made with numbers! ");
            } else {
                if (randomWord.contains(input.toUpperCase())) {
                    if (Arrays.toString(guessArr).contains(input.toUpperCase())) {
                        wrongLetter();
                        chainErrorsCounter++;
                        inputSet.add(input.toUpperCase());
                    } else {
                        correctWord(wordCharArr, guessArr, input);
                        chainSuccessCounter++;
                        inputSet.add(input.toUpperCase());
                        if (Arrays.toString(guessArr).equals(Arrays.toString(wordCharArr))) {
                            win(player, randomWord);
                            break;
                        }
                        if (chainSuccessCounter > 2) {
                            System.out.println("🔥 YOU ARE ON FIREEE! 🔥");
                        }
                    }
                } else {
                    if (inputSet.contains(input.toUpperCase())) {
                        wrongLetter();
                        chainErrorsCounter++;
                    } else {
                        inputSet.add(input.toUpperCase());
                        chainSuccessCounter = 0;
                        player.looseALife(input);
                    }
                }
            }
            if (chainErrorsCounter > 2) {
                System.out.println("❌⚡ Please try to focus... You loose a life to remind yourself that sometimes it's better to think than just spam. ⚡❌");
                player.looseALife(input);
                chainErrorsCounter = 0;
            }
            if (player.getLives() == 0) {
                loose(player, randomWord);
            }
        }
    }

    void win(Player player, String randomWord) {
        System.out.printf("🎉 You win 🌟 %s! You had %s ❤ left, the word was %s!", player.getName(), player.getLives(), randomWord);
        player.setScore(player.getScore() + 100);
        System.out.printf("\nYour score is %s", player.getScore());
        System.out.println("\nDo you want to play again?");
        playAgain(player);
    }

    void loose(Player player, String randomWord) {
        System.out.printf("\nYou loose %s 😢, the word was %s!", player.getName(), randomWord);
        System.out.printf("\nYour score was %s", player.getScore());
        System.out.println("\nDo you want to play again?");
        playAgain(player);
    }

    void playAgain(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yes/No");
        String answer = scanner.nextLine();

        if (answer.toUpperCase().contains("Y")) {
            String newRandomWord = WordLibrary.getRandomWord();
            player.setLives(8);
            playGame(player, newRandomWord);
        } else if (answer.toUpperCase().contains("N")) {
            menu(player);
        } else {
            System.out.println("Please select a valid option.");
            playAgain(player);
        }

    }


    void correctWord(String[] wordArr, String[] guessArr, String input) {
        int index = 0;
        for (int i = 0; i < wordArr.length; i++) {
            if (input.toUpperCase().contains(wordArr[i])) {
                index = i;
                guessArr[index] = input.toUpperCase();
            }
        }
        System.out.println("✅ Correct!");
    }

    void wrongLetter() {
        System.out.println("😡 You already wrote this letter! 😡");
    }

    void stopGame() {
        System.out.println("You have quit the game. \n 👋 Bye Bye 👋");
    }

}
