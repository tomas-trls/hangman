import java.util.Arrays;
import java.util.Scanner;

public class Game {

    String[] wordsArr = {"france", "elephant", "giraffe", "Nology", "Spain", "Marseille", "Javascript", "able",
            "about", "absolute", "accept", "account", "achieve", "across", "act", "active", "actual", "add", "address",
            "admit", "advertise", "affect", "afford", "after", "afternoon", "again", "against", "age", "agent", "ago",
            "agree", "air", "all", "allow", "almost", "along", "already", "alright", "also", "although", "always",
            "america", "amount", "and", "another", "answer", "any", "apart", "apparent", "appear", "apply", "appoint",
            "approach", "appropriate", "area", "argue", "arm", "around", "arrange", "art", "as", "ask", "associate",
            "assume", "at", "attend", "authority", "available", "aware", "away", "awful", "baby", "back", "bad", "bag",
            "balance", "ball", "bank", "bar", "base", "basis", "be", "bear", "beat", "beauty", "because", "become",
            "bed", "before", "begin", "behind", "believe", "benefit", "best", "bet", "between", "big", "bill", "birth",
            "bit", "black", "bloke", "blood", "blow", "blue", "board", "boat", "body", "book", "both", "bother",
            "bottle", "bottom", "box", "boy", "break", "brief", "brilliant", "bring", "britain", "brother", "budget",
            "build", "bus", "business", "busy", "but", "buy", "by", "cake", "call", "can", "car", "card", "care",
            "carry", "case", "cat", "catch", "cause", "cent", "centre", "certain", "chair", "chairman", "chance",
            "change", "chap", "character", "charge", "cheap", "check", "child", "choice", "choose", "Christ",
            "Christmas", "church", "city", "claim", "class", "clean", "clear", "client", "clock", "close", "closes",
            "clothe", "club", "coffee", "cold", "colleague", "collect", "college", "colour", "come", "comment",
            "commit", "committee", "common", "community", "company", "compare", "complete", "compute", "concern",
            "condition", "confer", "consider", "consult", "contact", "continue", "contract", "control", "converse",
            "cook", "copy", "corner", "correct", "cost", "could", "council", "count", "country", "county", "couple",
            "course", "court", "cover", "create", "cross", "cup", "current", "cut", "dad", "danger", "date", "day",
            "dead", "deal", "dear", "debate", "decide", "decision", "deep", "definite", "degree", "department",
            "depend", "describe", "design", "detail", "develop", "die", "difference", "difficult", "dinner", "direct",
            "discuss", "district", "divide", "do", "doctor", "document", "dog", "door", "double", "doubt", "down",
            "draw", "dress", "drink", "drive", "drop", "dry", "due", "during", "each", "early", "east", "easy", "eat",
            "economy", "educate", "effect", "egg", "eight", "either", "elect", "electric", "eleven", "else", "employ",
            "encourage", "end", "engine", "english", "enjoy", "enough", "enter", "environment", "equal", "especial",
            "europe", "even", "evening", "ever", "every", "evidence", "exact", "example", "except", "excuse",
            "exercise", "exist", "expect", "expense", "experience", "explain", "express", "extra", "eye", "face",
            "fact", "fair", "fall", "family", "far", "farm", "fast", "father", "favour", "feed", "feel", "few",
            "field", "fight", "figure", "file", "fill", "film", "final", "finance", "find", "fine", "finish", "fire",
            "first", "fish", "fit", "five", "flat", "floor", "fly", "follow", "food", "foot", "for", "force", "forget",
            "form", "fortune", "forward", "four", "france", "free", "friday", "friend", "from", "front", "full", "fun",
            "function", "fund", "further", "future", "game", "garden", "gas", "general", "germany", "get", "girl",
            "give", "glass", "go", "god", "good", "goodbye", "govern", "grand", "grant", "great", "green", "ground",
            "group", "grow", "guess", "guy", "hair", "half", "hall", "hand", "hang", "happen", "happy", "hard", "hate",
            "have", "he", "head", "health", "hear", "heart", "heat", "heavy", "hell", "help", "here", "high", "history",
            "hit", "hold", "holiday", "home", "honest", "hope", "horse", "hospital", "hot", "hour", "house", "how",
            "however", "hullo", "hundred", "husband", "idea", "identify", "if", "imagine", "important", "improve", "in",
            "include", "income", "increase", "indeed", "individual", "industry", "inform", "inside", "instead",
            "insure", "interest", "into", "introduce", "invest", "involve", "issue", "it", "item", "jesus", "job",
            "join", "judge", "jump", "just", "keep", "key", "kid", "kill", "kind", "king", "kitchen", "knock", "know",
            "labour", "lad", "lady", "land", "language", "large", "last", "late", "laugh", "law", "lay", "lead",
            "learn", "leave", "left", "leg", "less", "let", "letter", "level", "lie", "life", "light", "like", "likely",
            "limit", "line", "link", "list", "listen", "little", "live", "load", "local", "lock", "london", "long",
            "look", "lord", "lose", "lot", "love", "low", "luck", "lunch", "machine", "main", "major", "make", "man",
            "manage", "many", "mark", "market", "marry", "match", "matter", "may", "maybe", "mean", "meaning",
            "measure", "meet", "member", "mention", "middle", "might", "mile", "milk", "million", "mind", "minister",
            "minus", "minute", "miss", "mister", "moment", "monday", "money", "month", "more", "morning", "most",
            "mother", "motion", "move", "mrs", "much", "music", "must", "name", "nation", "nature", "near", "necessary",
            "need", "never", "new", "news", "next", "nice", "night", "nine", "no", "non", "none", "normal", "north",
            "not", "note", "notice", "now", "number", "obvious", "occasion", "odd", "of", "off", "offer", "office",
            "often", "okay", "old", "on", "once", "one", "only", "open", "operate", "opportunity", "oppose", "or",
            "order", "organize", "original", "other", "otherwise", "ought", "out", "over", "own", "pack", "page",
            "paint", "pair", "paper", "paragraph", "pardon", "parent", "park", "part", "particular", "party", "pass",
            "past", "pay", "pence", "pension", "people", "per", "percent", "perfect", "perhaps", "period", "person",
            "photograph", "pick", "picture", "piece", "place", "plan", "play", "please", "plus", "point", "police",
            "policy", "politic", "poor", "position", "positive", "possible", "post", "pound", "power", "practise",
            "prepare", "present", "press", "pressure", "presume", "pretty", "previous", "price", "print", "private",
            "probable", "problem", "proceed", "process", "produce", "product", "programme", "project", "proper",
            "propose", "protect", "provide", "public", "pull", "purpose", "push", "put", "quality", "quarter",
            "question", "quick", "quid", "quiet", "quite", "radio", "rail", "raise", "range", "rate", "rather", "read",
            "ready", "real", "realise", "really", "reason", "receive", "recent", "reckon", "recognize", "recommend",
            "record", "red", "reduce", "refer", "regard", "region", "relation", "remember", "report", "represent",
            "require", "research", "resource", "respect", "responsible", "rest", "result", "return", "rid", "right",
            "ring", "rise", "road", "role", "roll", "room", "round", "rule", "run", "safe", "sale", "same", "saturday",
            "save", "say", "scheme", "school", "science", "score", "scotland", "seat", "second", "secretary", "section",
            "secure", "see", "seem", "self", "sell", "send", "sense", "separate", "serious", "serve", "service", "set",
            "settle", "seven", "sex", "shall", "share", "she", "sheet", "shoe", "shoot", "shop", "short", "should",
            "show", "shut", "sick", "side", "sign", "similar", "simple", "since", "sing", "single", "sir", "sister",
            "sit", "site", "situate", "six", "size", "sleep", "slight", "slow", "small", "smoke", "so", "social",
            "society", "some", "son", "soon", "sorry", "sort", "sound", "south", "space", "speak", "special",
            "specific", "speed", "spell", "spend", "square", "staff", "stage", "stairs", "stand", "standard", "start",
            "state", "station", "stay", "step", "stick", "still", "stop", "story", "straight", "strategy", "street",
            "strike", "strong", "structure", "student", "study", "stuff", "stupid", "subject", "succeed", "such",
            "sudden", "suggest", "suit", "summer", "sun", "sunday", "supply", "support", "suppose", "sure", "surprise",
            "switch", "system", "table", "take", "talk", "tape", "tax", "tea", "teach", "team", "telephone",
            "television", "tell", "ten", "tend", "term", "terrible", "test", "than", "thank", "the", "then", "there",
            "therefore", "they", "thing", "think", "thirteen", "thirty", "this", "thou", "though", "thousand", "three",
            "through", "throw", "thursday", "tie", "time", "to", "today", "together", "tomorrow", "tonight", "too",
            "top", "total", "touch", "toward", "town", "trade", "traffic", "train", "transport", "travel", "treat",
            "tree", "trouble", "true", "trust", "try", "tuesday", "turn", "twelve", "twenty", "two", "type", "under",
            "understand", "union", "unit", "unite", "university", "unless", "until", "up", "upon", "use", "usual",
            "value", "various", "very", "video", "view", "village", "visit", "vote", "wage", "wait", "walk", "wall",
            "want", "war", "warm", "wash", "waste", "watch", "water", "way", "we", "wear", "wednesday", "wee", "week",
            "weigh", "welcome", "well", "west", "what", "when", "where", "whether", "which", "while", "white", "who",
            "whole", "why", "wide", "wife", "will", "win", "wind", "window", "wish", "with", "within", "without",
            "woman", "wonder", "wood", "word", "work", "world", "worry", "worse", "worth", "would", "write", "wrong",
            "year", "yes", "yesterday", "yet", "you", "young"};
    WordLibrary words = new WordLibrary(wordsArr);


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
            String randomWord = words.getRandomWord();
            playGame(player, randomWord);
        } else {
            menu();
        }
    }

    void playGame(Player player, String randomWord){
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
            String newRandomWord = words.getRandomWord();
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
