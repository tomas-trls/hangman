public class WordLibrary {
    String[] wordsArr;
    public WordLibrary(String[] words) {
        this.wordsArr = words;
    }

    String getRandomWord(){
        int randomIndex = (int) (Math.random() * wordsArr.length);
        return wordsArr[randomIndex].toUpperCase();
    }
}
