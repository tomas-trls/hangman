public class Player {
    private String name;
    private char input;

    private int lives = 8;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getInput() {
        return input;
    }

    public void setInput(char input) {
        this.input = input;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void looseALife (String input){
        switch (this.getLives()) {
            case 8:
                System.out.printf("❌ Wrong Letter! You tried %s \n", input);
                System.out.println("_______");
                break;
            case 7:
                System.out.printf("❌ Wrong Letter! 😕 You tried %s \n", input);
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                break;
            case 6:
                System.out.printf("❌ Wrong Letter! 😡 You tried %s \n", input);
                System.out.println("   _______");
                System.out.println("   |/  ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                break;
            case 5:
                System.out.printf("❌ Wrong Letter! 😓 You tried %s \n", input);
                System.out.println("   _______");
                System.out.println("   |/    |");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                break;
            case 4:
                System.out.printf("❌ Wrong Letter! 😨 You tried %s \n", input);
                System.out.println("   _______");
                System.out.println("   |/     |");
                System.out.println("   |     😣");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                break;
            case 3:
                System.out.printf("❌ Wrong Letter! 😰 You tried %s \n", input);
                System.out.println("   _______");
                System.out.println("   |/     |");
                System.out.println("   |     😣");
                System.out.println("   |    💪|🤳");
                System.out.println("   |      ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                break;
            case 2:
                System.out.printf("❌ Wrong Letter! 😱 You tried %s \n", input);
                System.out.println("   _______");
                System.out.println("   |/     |");
                System.out.println("   |     😣");
                System.out.println("   |    💪|🤳");
                System.out.println("   |      |");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("___|___");
                break;
            case 1:
                System.out.printf("❌ Wrong Letter! 🥶 You tried %s \n", input);
                System.out.println("   _______");
                System.out.println("   |/     |");
                System.out.println("   |     😣");
                System.out.println("   |    💪|🤳");
                System.out.println("   |      |");
                System.out.println("   |    🦶\\");
                System.out.println("   |   ");
                System.out.println("___|___");
                break;
        }
        this.setLives(this.getLives() - 1);
    }
}
