import java.util.HashMap;
import java.util.Map;

public class WordsCounter {

    private Map<String, Integer> dictionary = new HashMap<>();

    private void printUniqueWords() {
        System.out.println("Unique words: ");
        System.out.println(dictionary.keySet());
        System.out.println();
    }

    private void printDictionary() {
        System.out.println("Dictionary:");
        dictionary.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }

    public WordsCounter(String[] array) {
        for (String currentWord : array) {
            int count = 0;
            if (dictionary.containsKey(currentWord)) {
                count = dictionary.get(currentWord);
            }
            dictionary.put(currentWord, count + 1);
        }
    }

    public static void main(String[] args) {
        String[] array = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        WordsCounter wordsCounter = new WordsCounter(array);
        wordsCounter.printUniqueWords();
        wordsCounter.printDictionary();
    }

}
