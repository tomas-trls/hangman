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
            System.out.println(randomWord);
            System.out.println(player.getLives());

            String[] letters = breakTheWord();

            while(player.getLives() != 0){
                System.out.println(player.getLives());
                System.out.println("Please add a letter:");
                String input = scanner.nextLine();
                if(input.length() == letters.length) {
                    if(input.toUpperCase().equals(randomWord)){
                        System.out.printf("You win, the word was %s", randomWord);
                        break;
                    } else {
                        player.setLives(player.getLives() - 1);
                    }
                } else if (input.length() > 1 || input.equals("")) {
                    System.out.println("Please enter only one letter or guess a word with the exact same number of letters.");
                } else {
                    System.out.printf("You tried %s \n", input);
                    player.setLives(player.getLives() - 1);
                }
                if(player.getLives() == 0) {
                    System.out.printf("\n You loose, the word was %s", randomWord );
                }
            }


        }
    }

    String[] breakTheWord(){
        return randomWord.split("");
    }



    String stopGame(){
        return "You have quit the game.";
    }



}
