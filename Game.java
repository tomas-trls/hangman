import java.util.Scanner;

public class Game {

    String[] wordsArr= {"france", "elephant", "giraffe", "Nology","Spain", "Marseille", "Javascript"};
    WordLibrary words = new WordLibrary(wordsArr);
    String randomWord = words.getRandomWord();
    void launchGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the HangMan Game! \n Please select an option: \n 1: Play | 2: Quit ");
        String option = scanner.nextLine();
        if(option.equals("2")){
            System.out.println(stopGame());
        } else {
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            Player player =  new Player(name);
            System.out.println("Selecting a random word...");
            System.out.println("... ... ... ... ... .... ... ...");
            System.out.println("...Starting the game...");
            //System.out.println(randomWord);

           String[] guessArr = new String[randomWord.length()];

            for (int i = 0; i < guessArr.length; i++) {
                guessArr[i] = "_";
            }

            String[] wordCharArr = randomWord.split("");


            while(player.getLives() != 0){
                System.out.println("Remaining ❤️ lives: " + player.getLives());
                String guessString = String.join("", guessArr);
                System.out.println(guessString);
                System.out.println("Please add a letter:");
                String input = scanner.nextLine();


                if(input.length() == randomWord.length()) {
                    if(input.toUpperCase().equals(randomWord)){
                        System.out.printf("🎉 You win 🌟, the word was %s", randomWord);
                        break;
                    } else {
                        player.setLives(player.getLives() - 1);
                    }
                } else if (input.length() > 1 || input.equals("")) {
                    System.out.println("Please enter only one letter or guess a word with the exact same number of letters.");
                } else {
                    if(randomWord.contains(input)) {
                        int index = 0;
                        for (int i = 0; i < wordCharArr.length; i++) {
                            if(input.contains(wordCharArr[i])){
                                index = i;
                                break;
                            }
                        }
                        guessArr[index] = input;
                        System.out.println("✅ Correct!");
                    } else {
                        switch (player.getLives()) {
                            case 8:
                                System.out.printf("❌ Wrong Letter! You tried %s \n", input);
                                break;
                            case 7:
                                System.out.printf("❌ Wrong Letter! 😕 You tried %s \n", input);
                                break;
                            case 6:
                                System.out.printf("❌ Wrong Letter! 😡 You tried %s \n", input);
                                break;
                            case 5:
                                System.out.printf("❌ Wrong Letter! 😓 You tried %s \n", input);
                                break;
                            case 4:
                                System.out.printf("❌ Wrong Letter! 😨 You tried %s \n", input);
                                break;
                            case 3:
                                System.out.printf("❌ Wrong Letter! 😰 You tried %s \n", input);
                                break;
                            case 2:
                                System.out.printf("❌ Wrong Letter! 😱 You tried %s \n", input);
                                break;
                            case 1:
                                System.out.printf("❌ Wrong Letter! 🥶 You tried %s \n", input);
                                break;
                        }
                        player.setLives(player.getLives() - 1);
                    }


                }
                if(player.getLives() == 0) {
                    System.out.printf("\n You loose, the word was %s", randomWord );
                }
            }


        }
    }


    String stopGame(){
        return "You have quit the game.";
    }



}
