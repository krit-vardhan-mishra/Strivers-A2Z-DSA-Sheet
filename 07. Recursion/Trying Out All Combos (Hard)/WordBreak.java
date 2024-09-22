import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] checked = new Boolean[s.length()+1];
        return match(s, 0, wordDict, checked);
    }

    public static boolean match(String s, int index, List<String> wordDict, Boolean[] checked) {
        if(index == s.length()) return true;
        if(checked[index] != null) return checked[index];

        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);

            if(s.startsWith(word, index)) {
                if(match(s, index + word.length(), wordDict, checked)) {
                    checked[index] = true;
                    return true;
                }
            }
        }

        return checked[index] = false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak("applepenapple", wordDict));
    }
}
